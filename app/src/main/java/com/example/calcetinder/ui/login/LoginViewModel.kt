package com.example.calcetinder.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calcetinder.datos.Repositorio
import com.example.calcetinder.modelo.Usuario
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class LoginViewModel(private val repositorio: Repositorio) : ViewModel() {
    private val _usuarioActual = MutableStateFlow<Usuario?>(null)
    val usuarioActual: StateFlow<Usuario?> = _usuarioActual
    private val _mensajeError = MutableStateFlow("")
    val mensajeError: StateFlow<String> = _mensajeError

    fun login(identificador: String, contrasena: String) {
        viewModelScope.launch {
            try {
                val usuario = repositorio.loginUsuario(identificador, contrasena).first()
                if (usuario != null) { _usuarioActual.value = usuario; _mensajeError.value = "" }
                else { _mensajeError.value = "Usuario o contrasena incorrectos" }
            } catch (e: Exception) { _mensajeError.value = "Error: ${e.message}" }
        }
    }

    fun registro(nombre: String, email: String, contrasena: String, ciudad: String) {
        viewModelScope.launch {
            try {
                val u = Usuario(nombre = nombre, email = email, contrasena = contrasena, ciudad = ciudad)
                val id = repositorio.insertarUsuario(u).toInt()
                _usuarioActual.value = u.copy(id = id)
                _mensajeError.value = ""
            } catch (e: Exception) { _mensajeError.value = "Error: ${e.message}" }
        }
    }

    fun logout() { _usuarioActual.value = null }
}
