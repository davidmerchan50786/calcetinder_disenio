package com.example.calcetinder.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calcetinder.datos.Repositorio
import com.example.calcetinder.modelo.Usuario
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class LoginViewModel(private val repo: Repositorio) : ViewModel() {
    private val _usuario = MutableStateFlow<Usuario?>(null)
    val usuarioActual: StateFlow<Usuario?> = _usuario
    private val _error = MutableStateFlow("")
    val error: StateFlow<String> = _error

    fun login(email: String, pass: String) {
        viewModelScope.launch {
            try {
                val u = repo.loginUsuario(email, pass).first()
                if (u != null) { _usuario.value = u; _error.value = "" }
                else _error.value = "Email o contraseÃ±a incorrectos"
            } catch (e: Exception) { _error.value = "Error: " + e.message }
        }
    }

    fun registro(nombre: String, email: String, pass: String, ciudad: String) {
        viewModelScope.launch {
            try {
                val u = Usuario(nombre = nombre, email = email, contrasena = pass, ciudad = ciudad)
                repo.insertarUsuario(u)
                _usuario.value = u
            } catch (e: Exception) { _error.value = "Error: " + e.message }
        }
    }

    fun logout() { _usuario.value = null }
}