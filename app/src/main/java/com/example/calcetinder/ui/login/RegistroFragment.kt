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
import com.example.calcetinder.databinding.FragmentRegistroBinding
import kotlinx.coroutines.launch

class RegistroFragment : Fragment() {
    private var _binding: FragmentRegistroBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentRegistroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = CalcetinderDB.obtenerDB(requireContext())
        val repo = Repositorio(db.usuarioDAO(), db.calcetinDAO(), db.matchDAO())
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : androidx.lifecycle.ViewModel> create(m: Class<T>): T = LoginViewModel(repo) as T
        }).get(LoginViewModel::class.java)

        binding.btnRegistrar.setOnClickListener {
            val nombre = binding.etNombre.text.toString()
            val email = binding.etEmail.text.toString()
            val contrasena = binding.etContrasena.text.toString()
            val ciudad = binding.etCiudad.text.toString()
            if (nombre.isNotEmpty() && email.isNotEmpty() && contrasena.isNotEmpty() && ciudad.isNotEmpty())
                viewModel.registro(nombre, email, contrasena, ciudad)
            else Toast.makeText(context, "Rellena todos los campos", Toast.LENGTH_SHORT).show()
        }
        binding.btnVolver.setOnClickListener { findNavController().navigateUp() }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.usuarioActual.collect { u ->
                if (u != null) {
                    requireContext().getSharedPreferences("calcetinder", Context.MODE_PRIVATE)
                        .edit().putInt("usuarioId", u.id).apply()
                    findNavController().navigate(R.id.action_registroFragment_to_swipeFragment)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.mensajeError.collect { if (it.isNotEmpty()) Toast.makeText(context, it, Toast.LENGTH_SHORT).show() }
        }
    }

    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}