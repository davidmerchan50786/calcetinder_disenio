package com.example.calcetinder.datos

import androidx.room.*
import com.example.calcetinder.modelo.Usuario
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDAO {
    @Insert suspend fun insertar(usuario: Usuario)
    @Update suspend fun actualizar(usuario: Usuario)
    @Delete suspend fun eliminar(usuario: Usuario)
    @Query("SELECT * FROM usuarios WHERE id = :id")
    fun obtener(id: Int): Flow<Usuario?>
    @Query("SELECT * FROM usuarios WHERE email = :email AND contrasena = :contrasena")
    fun login(email: String, contrasena: String): Flow<Usuario?>
    @Query("SELECT * FROM usuarios")
    fun obtenerTodos(): Flow<List<Usuario>>
}