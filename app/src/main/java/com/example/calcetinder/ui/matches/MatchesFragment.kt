package com.example.calcetinder.ui.matches

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calcetinder.R
import com.example.calcetinder.datos.CalcetinderDB
import com.example.calcetinder.datos.Repositorio
import com.example.calcetinder.databinding.FragmentMatchesBinding
import com.example.calcetinder.ui.miscalcetines.CalcetinAdapter
import kotlinx.coroutines.launch

class MatchesFragment : Fragment(R.layout.fragment_matches) {
    private lateinit var viewModel: MatchesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMatchesBinding.bind(view)
        val uid = requireContext().getSharedPreferences("calcetinder", Context.MODE_PRIVATE).getInt("usuarioId", 0)
        
        val db = CalcetinderDB.obtenerDB(requireContext())
        val repo = Repositorio(db.usuarioDAO(), db.calcetinDAO(), db.matchDAO())
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>) = MatchesViewModel(repo) as T
        })[MatchesViewModel::class.java]

        val adapter = CalcetinAdapter(esGestion = false)
        binding.rvMatches.layoutManager = LinearLayoutManager(context)
        binding.rvMatches.adapter = adapter

        viewModel.cargarMatches(uid)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.matches.collect { adapter.actualizar(it) }
        }
    }
}