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

    override fun onCreateView(i: LayoutInflater, c: ViewGroup?, s: Bundle?): View {
        _binding = FragmentRegistroBinding.inflate(i, c, false)
        return binding.root
    }

    override fun onViewCreated(view: View, s: Bundle?) {
        super.onViewCreated(view, s)
        val db = CalcetinderDB.obtenerDB(requireContext())
        val repo = Repositorio(db.usuarioDAO(), db.calcetinDAO(), db.matchDAO())
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : androidx.lifecycle.ViewModel> create(mc: Class<T>): T = LoginViewModel(repo) as T
        }).get(LoginViewModel::class.java)
        binding.btnRegistrar.setOnClickListener {
            val n = binding.etNombre.text.toString()
            val e = binding.etEmail.text.toString()
            val p = binding.etContrasena.text.toString()
            val c = binding.etCiudad.text.toString()
            if (n.isNotEmpty() && e.isNotEmpty() && p.isNotEmpty() && c.isNotEmpty())
                viewModel.registro(n, e, p, c)
            else Toast.makeText(context, "Rellena todos los campos", Toast.LENGTH_SHORT).show()
        }
        binding.btnVolver.setOnClickListener { findNavController().navigateUp() }
        lifecycleScope.launch {
            viewModel.usuarioActual.collect { u ->
                if (u != null) {
                    requireContext().getSharedPreferences("calcetinder", Context.MODE_PRIVATE)
                        .edit().putInt("usuarioId", u.id).apply()
                    findNavController().navigate(R.id.action_registroFragment_to_swipeFragment)
                }
            }
        }
        lifecycleScope.launch {
            viewModel.error.collect { err ->
                if (err.isNotEmpty()) Toast.makeText(context, err, Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}