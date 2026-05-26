package com.example.calcetinder.ui.swipe

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.calcetinder.R
import com.example.calcetinder.datos.CalcetinderDB
import com.example.calcetinder.datos.Repositorio
import com.example.calcetinder.databinding.FragmentSwipeBinding
import kotlinx.coroutines.launch

class SwipeFragment : Fragment(R.layout.fragment_swipe) {
    private lateinit var viewModel: SwipeViewModel
    private var uid = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val b = FragmentSwipeBinding.bind(view)
        uid = requireContext().getSharedPreferences("calcetinder", Context.MODE_PRIVATE).getInt("usuarioId", 0)
        
        val db = CalcetinderDB.obtenerDB(requireContext())
        val repo = Repositorio(db.usuarioDAO(), db.calcetinDAO(), db.matchDAO())
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return SwipeViewModel(repo) as T
            }
        })[SwipeViewModel::class.java]

        configurarMenu()
        viewModel.cargarCalcetines()

        b.btnLike.setOnClickListener { viewModel.like(uid) }
        b.btnDislike.setOnClickListener { viewModel.dislike() }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.calcetines.collect { lista ->
                actualizarUI(lista, viewModel.indiceActual.value, b)
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.indiceActual.collect { idx ->
                actualizarUI(viewModel.calcetines.value, idx, b)
            }
        }
    }

    private fun actualizarUI(lista: List<com.example.calcetinder.modelo.Calcetin>, idx: Int, b: FragmentSwipeBinding) {
        if (lista.isNotEmpty() && idx < lista.size) {
            val c = lista[idx]
            b.tvNombre.text = c.nombre
            b.tvDescripcion.text = c.descripcion
            b.tvColor.text = "Color: ${c.color}"
            b.tvMaterial.text = "Material: ${c.material}"
        } else {
            b.tvNombre.text = "No hay más calcetines"
            b.tvDescripcion.text = ""
            b.tvColor.text = ""
            b.tvMaterial.text = ""
        }
    }

    private fun configurarMenu() {
        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) = menuInflater.inflate(R.menu.menu_swipe, menu)
            override fun onMenuItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.action_mis_calcetines -> findNavController().navigate(R.id.action_swipeFragment_to_miscalcetinesFragment)
                    R.id.action_matches -> findNavController().navigate(R.id.action_swipeFragment_to_matchesFragment)
                    R.id.action_logout -> {
                        requireContext().getSharedPreferences("calcetinder", Context.MODE_PRIVATE).edit().clear().apply()
                        findNavController().navigate(R.id.loginFragment)
                    }
                }
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}