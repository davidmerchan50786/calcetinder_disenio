package com.example.calcetinder.ui.swipe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calcetinder.datos.Repositorio
import com.example.calcetinder.modelo.Calcetin
import com.example.calcetinder.modelo.Match
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SwipeViewModel(private val repo: Repositorio) : ViewModel() {
    private val _calcetines = MutableStateFlow<List<Calcetin>>(emptyList())
    val calcetines: StateFlow<List<Calcetin>> = _calcetines
    private val _indice = MutableStateFlow(0)
    val indiceActual: StateFlow<Int> = _indice

    fun cargarCalcetines() {
        viewModelScope.launch { repo.obtenerTodosCalcetines().collect { _calcetines.value = it } }
    }
    fun like(usuarioId: Int) {
        val c = _calcetines.value.getOrNull(_indice.value) ?: return
        viewModelScope.launch {
            repo.insertarMatch(Match(usuarioId = usuarioId, calcetinId = c.id, tipoMatch = "like"))
            siguiente()
        }
    }
    fun dislike() { viewModelScope.launch { siguiente() } }
    private suspend fun siguiente() {
        val n = _indice.value + 1
        _indice.value = if (n < _calcetines.value.size) n else 0
    }
}