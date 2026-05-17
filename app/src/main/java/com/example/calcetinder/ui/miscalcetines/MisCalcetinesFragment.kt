package com.example.calcetinder.ui.miscalcetines

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calcetinder.datos.CalcetinderDB
import com.example.calcetinder.datos.Repositorio
import com.example.calcetinder.databinding.FragmentMiscalcetinesBinding
import kotlinx.coroutines.launch

// TODO falta el dialogo de crear/editar y el menu
class MisCalcetinesFragment : Fragment() {
    private var _binding: FragmentMiscalcetinesBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MisCalcetinesViewModel
    private lateinit var adapter: CalcetinAdapter
    private var usuarioId: Int = 0

    override fun onCreateView(i: LayoutInflater, c: ViewGroup?, s: Bundle?): View {
        _binding = FragmentMiscalcetinesBinding.inflate(i, c, false)
        return binding.root
    }

    override fun onViewCreated(view: View, s: Bundle?) {
        super.onViewCreated(view, s)
        val prefs = requireContext().getSharedPreferences("calcetinder", Context.MODE_PRIVATE)
        usuarioId = prefs.getInt("usuarioId", 0)
        val db = CalcetinderDB.obtenerDB(requireContext())
        val repo = Repositorio(db.usuarioDAO(), db.calcetinDAO(), db.matchDAO())
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : androidx.lifecycle.ViewModel> create(mc: Class<T>): T =
                MisCalcetinesViewModel(repo) as T
        }).get(MisCalcetinesViewModel::class.java)
        adapter = CalcetinAdapter(emptyList(), {}, {})
        binding.rvCalcetines.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@MisCalcetinesFragment.adapter
        }
        viewModel.cargarCalcetinesPorUsuario(usuarioId)
        lifecycleScope.launch { viewModel.misCalcetines.collect { adapter.actualizarLista(it) } }
    }
    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}