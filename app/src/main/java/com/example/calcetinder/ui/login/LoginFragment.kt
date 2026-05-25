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
import com.example.calcetinder.databinding.FragmentLoginBinding
import kotlinx.coroutines.launch

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var viewModel: LoginViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val b = FragmentLoginBinding.bind(view)
        val db = CalcetinderDB.obtenerDB(requireContext())
        val repo = Repositorio(db.usuarioDAO(), db.calcetinDAO(), db.matchDAO())
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : androidx.lifecycle.ViewModel> create(m: Class<T>) = LoginViewModel(repo) as T
        })[LoginViewModel::class.java]

        b.btnLogin.setOnClickListener {
            val email = b.etEmail.text.toString().trim()
            val pass = b.etContrasena.text.toString().trim()
            if (validar(b, email, pass)) viewModel.login(email, pass)
        }

        b.btnRegistro.setOnClickListener { findNavController().navigate(R.id.action_loginFragment_to_registroFragment) }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.usuarioActual.collect { u ->
                u?.let {
                    requireContext().getSharedPreferences("calcetinder", Context.MODE_PRIVATE).edit().putInt("usuarioId", it.id).apply()
                    findNavController().navigate(R.id.action_loginFragment_to_swipeFragment)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.error.collect { if (it.isNotEmpty()) Toast.makeText(context, it, Toast.LENGTH_SHORT).show() }
        }
    }

    private fun validar(b: FragmentLoginBinding, email: String, pass: String): Boolean {
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) b.etEmail.error = "Email inválido"
        if (pass.length < 4) b.etContrasena.error = "Mínimo 4 caracteres"
        return b.etEmail.error == null && b.etContrasena.error == null
    }
}