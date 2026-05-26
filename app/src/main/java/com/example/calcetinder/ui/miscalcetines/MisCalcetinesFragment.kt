package com.example.calcetinder.ui.miscalcetines

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calcetinder.R
import com.example.calcetinder.datos.CalcetinderDB
import com.example.calcetinder.datos.Repositorio
import com.example.calcetinder.databinding.DialogCalcetinBinding
import com.example.calcetinder.databinding.FragmentMiscalcetinesBinding
import com.example.calcetinder.modelo.Calcetin
import kotlinx.coroutines.launch

class MisCalcetinesFragment : Fragment(R.layout.fragment_miscalcetines) {
    private lateinit var viewModel: MisCalcetinesViewModel
    private var uid = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val b = FragmentMiscalcetinesBinding.bind(view)
        uid = requireContext().getSharedPreferences("calcetinder", Context.MODE_PRIVATE).getInt("usuarioId", 0)
        val db = CalcetinderDB.obtenerDB(requireContext())
        val repo = Repositorio(db.usuarioDAO(), db.calcetinDAO(), db.matchDAO())
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : androidx.lifecycle.ViewModel> create(m: Class<T>) = MisCalcetinesViewModel(repo) as T
        })[MisCalcetinesViewModel::class.java]

        val adapter = CalcetinAdapter(
            esGestion = true,
            onEdit = { mostrarDialogo(it) },
            onDelete = { calcetin ->
                AlertDialog.Builder(requireContext())
                    .setTitle("Eliminar calcetín")
                    .setMessage("¿Eliminar \"${calcetin.nombre}\"?")
                    .setPositiveButton("Eliminar") { _, _ ->
                        viewModel.eliminarCalcetin(calcetin)
                        Toast.makeText(context, "Calcetín eliminado", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton(R.string.cancelar, null).show()
            }
        )
        b.rvCalcetines.layoutManager = LinearLayoutManager(context)
        b.rvCalcetines.adapter = adapter
        b.btnCrearCalcetin.setOnClickListener { mostrarDialogo() }
        viewModel.cargarCalcetinesPorUsuario(uid)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.misCalcetines.collect { adapter.actualizar(it) }
        }
    }

    private fun mostrarDialogo(c: Calcetin? = null) {
        val db = DialogCalcetinBinding.inflate(layoutInflater)
        val colores = resources.getStringArray(R.array.colores_calcetin)
        val materiales = resources.getStringArray(R.array.materiales_calcetin)
        ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, colores).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            db.spinnerColor.adapter = it
        }
        ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, materiales).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            db.spinnerMaterial.adapter = it
        }
        c?.let { cal ->
            db.etNombre.setText(cal.nombre)
            db.etDescripcion.setText(cal.descripcion)
            colores.indexOfFirst { it.equals(cal.color, ignoreCase = true) }.let { if (it >= 0) db.spinnerColor.setSelection(it) }
            materiales.indexOfFirst { it.equals(cal.material, ignoreCase = true) }.let { if (it >= 0) db.spinnerMaterial.setSelection(it) }
        }
        AlertDialog.Builder(requireContext())
            .setTitle(if (c == null) getString(R.string.nuevo_calcetin) else getString(R.string.editar_calcetin))
            .setView(db.root)
            .setPositiveButton(R.string.guardar) { _, _ ->
                val nombre = db.etNombre.text.toString().trim()
                val color = colores[db.spinnerColor.selectedItemPosition]
                val material = materiales[db.spinnerMaterial.selectedItemPosition]
                if (nombre.isNotBlank()) {
                    if (c == null) {
                        viewModel.crearCalcetin(uid, nombre, db.etDescripcion.text.toString().trim(), color, material)
                        Toast.makeText(context, "Calcetín guardado", Toast.LENGTH_SHORT).show()
                    } else {
                        viewModel.actualizarCalcetin(c.copy(nombre = nombre, descripcion = db.etDescripcion.text.toString().trim(), color = color, material = material))
                        Toast.makeText(context, "Calcetín actualizado", Toast.LENGTH_SHORT).show()
                    }
                } else Toast.makeText(context, "El nombre no puede estar vacío", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton(R.string.cancelar, null).show()
    }
}
