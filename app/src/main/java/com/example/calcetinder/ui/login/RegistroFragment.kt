package com.example.calcetinder.ui.login

import android.content.Context
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.calcetinder.R
import com.example.calcetinder.datos.CalcetinderDB
import com.example.calcetinder.datos.Repositorio
import com.example.calcetinder.databinding.FragmentRegistroBinding
import kotlinx.coroutines.launch

class RegistroFragment : Fragment(R.layout.fragment_registro) {
    private lateinit var viewModel: LoginViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val b = FragmentRegistroBinding.bind(view)
        val db = CalcetinderDB.obtenerDB(requireContext())
        val repo = Repositorio(db.usuarioDAO(), db.calcetinDAO(), db.matchDAO())
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : androidx.lifecycle.ViewModel> create(m: Class<T>) = LoginViewModel(repo) as T
        })[LoginViewModel::class.java]

        b.btnRegistrar.setOnClickListener {
            val n = b.etNombre.text.toString().trim()
            val e = b.etEmail.text.toString().trim()
            val p = b.etContrasena.text.toString().trim()
            val c = b.etCiudad.text.toString().trim()
            if (validar(b, n, e, p, c)) viewModel.registro(n, e, p, c)
        }

        b.btnVolver.setOnClickListener { findNavController().navigateUp() }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.usuarioActual.collect { u ->
                u?.let {
                    requireContext().getSharedPreferences("calcetinder", Context.MODE_PRIVATE).edit().putInt("usuarioId", it.id).apply()
                    findNavController().navigate(R.id.action_registroFragment_to_swipeFragment)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.error.collect { if (it.isNotEmpty()) Toast.makeText(context, it, Toast.LENGTH_SHORT).show() }
        }
    }

    private fun validar(b: FragmentRegistroBinding, n: String, e: String, p: String, c: String): Boolean {
        if (n.isEmpty()) b.etNombre.error = "Obligatorio"
        if (!Patterns.EMAIL_ADDRESS.matcher(e).matches()) b.etEmail.error = "Email inválido"
        if (p.length < 4) b.etContrasena.error = "Mínimo 4 caracteres"
        if (c.isEmpty()) b.etCiudad.error = "Obligatorio"
        return b.etNombre.error == null && b.etEmail.error == null && b.etContrasena.error == null && b.etCiudad.error == null
    }
}