package com.example.calcetinder.ui.matches

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calcetinder.datos.Repositorio
import com.example.calcetinder.modelo.Calcetin
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MatchesViewModel(private val repo: Repositorio) : ViewModel() {
    private val _matches = MutableStateFlow<List<Calcetin>>(emptyList())
    val matches: StateFlow<List<Calcetin>> = _matches

    fun cargarMatches(usuarioId: Int) {
        viewModelScope.launch {
            repo.obtenerMatches(usuarioId).collect { listaMatches ->
                val listaCalcetines = mutableListOf<Calcetin>()
                for (match in listaMatches) {
                    val c = repo.obtenerCalcetin(match.calcetinId).first()
                    if (c != null) listaCalcetines.add(c)
                }
                _matches.value = listaCalcetines
            }
        }
    }
}