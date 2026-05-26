package com.example.calcetinder.ui.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = CalcetinderDB.obtenerDB(requireContext())
        val repo = Repositorio(db.usuarioDAO(), db.calcetinDAO(), db.matchDAO())
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : androidx.lifecycle.ViewModel> create(m: Class<T>): T = LoginViewModel(repo) as T
        }).get(LoginViewModel::class.java)

        binding.btnLogin.setOnClickListener {
            val identificador = binding.etEmail.text.toString().trim()
            val contrasena = binding.etContrasena.text.toString()
            when {
                identificador.isEmpty() -> Toast.makeText(context, "Introduce tu email o nombre", Toast.LENGTH_SHORT).show()
                contrasena.length < 6   -> Toast.makeText(context, "La contraseña tiene mínimo 6 caracteres", Toast.LENGTH_SHORT).show()
                else -> viewModel.login(identificador, contrasena)
            }
        }
        binding.btnRegistro.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registroFragment)
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.usuarioActual.collect { u ->
                if (u != null) {
                    requireContext().getSharedPreferences("calcetinder", Context.MODE_PRIVATE)
                        .edit().putInt("usuarioId", u.id).apply()
                    findNavController().navigate(R.id.action_loginFragment_to_swipeFragment)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.mensajeError.collect { if (it.isNotEmpty()) Toast.makeText(context, it, Toast.LENGTH_SHORT).show() }
        }
    }

    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}
