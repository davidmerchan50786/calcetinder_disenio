package com.example.calcetinder.ui.miscalcetines

import android.content.Context
import android.os.Bundle
import android.view.View
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

        val adapter = CalcetinAdapter(esGestion = true, 
            onEdit = { mostrarDialogo(it) }, 
            onDelete = { viewModel.eliminarCalcetin(it) })
        
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
        c?.let {
            db.etNombre.setText(it.nombre)
            db.etDescripcion.setText(it.descripcion)
            db.etColor.setText(it.color)
            db.etMaterial.setText(it.material)
        }
        AlertDialog.Builder(requireContext())
            .setTitle(if (c == null) "Nuevo" else "Editar")
            .setView(db.root)
            .setPositiveButton("Guardar") { _, _ ->
                val n = db.etNombre.text.toString()
                if (n.isNotBlank()) {
                    if (c == null) viewModel.crearCalcetin(uid, n, db.etDescripcion.text.toString(), db.etColor.text.toString())
                    else viewModel.actualizarCalcetin(c.copy(nombre = n, descripcion = db.etDescripcion.text.toString(), color = db.etColor.text.toString(), material = db.etMaterial.text.toString()))
                } else Toast.makeText(context, "Nombre vacío", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancelar", null).show()
    }
}