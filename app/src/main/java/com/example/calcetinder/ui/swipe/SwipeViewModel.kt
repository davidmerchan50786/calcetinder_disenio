package com.example.calcetinder.ui.swipe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calcetinder.datos.Repositorio
import com.example.calcetinder.modelo.Calcetin
import com.example.calcetinder.modelo.Match
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SwipeViewModel(private val repositorio: Repositorio) : ViewModel() {
    private val _calcetines = MutableStateFlow<List<Calcetin>>(emptyList())
    val calcetines: StateFlow<List<Calcetin>> = _calcetines
    private val _indiceActual = MutableStateFlow(0)
    val indiceActual: StateFlow<Int> = _indiceActual

    fun cargarCalcetines() {
        viewModelScope.launch {
            repositorio.obtenerTodosCalcetines().collect { lista -> _calcetines.value = lista }
        }
    }
    fun like(usuarioId: Int) {
        val calcetin = _calcetines.value.getOrNull(_indiceActual.value) ?: return
        viewModelScope.launch {
            repositorio.insertarMatch(Match(usuarioId = usuarioId, calcetinId = calcetin.id, tipoMatch = "like"))
            avanzarSiguiente()
        }
    }
    fun dislike() { viewModelScope.launch { avanzarSiguiente() } }
    private fun avanzarSiguiente() { _indiceActual.value = _indiceActual.value + 1 }
}
