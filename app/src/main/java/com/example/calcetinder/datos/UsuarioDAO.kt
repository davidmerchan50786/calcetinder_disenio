package com.example.calcetinder.datos

import androidx.room.*
import com.example.calcetinder.modelo.Usuario
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDAO {
    @Insert
    suspend fun insertar(usuario: Usuario): Long
    @Update
    suspend fun actualizar(usuario: Usuario)
    @Delete
    suspend fun eliminar(usuario: Usuario)
    @Query("SELECT * FROM usuarios WHERE id = :id")
    fun obtener(id: Int): Flow<Usuario?>
    @Query("SELECT * FROM usuarios WHERE (email = :identificador OR nombre = :identificador) AND contrasena = :contrasena")
    fun login(identificador: String, contrasena: String): Flow<Usuario?>
    @Query("SELECT * FROM usuarios")
    fun obtenerTodos(): Flow<List<Usuario>>
}
