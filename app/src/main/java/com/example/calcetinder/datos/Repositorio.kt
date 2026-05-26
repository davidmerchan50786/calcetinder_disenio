package com.example.calcetinder.datos

import com.example.calcetinder.modelo.Calcetin
import com.example.calcetinder.modelo.Match
import com.example.calcetinder.modelo.Usuario
import kotlinx.coroutines.flow.Flow

class Repositorio(
    private val usuarioDAO: UsuarioDAO,
    private val calcetinDAO: CalcetinDAO,
    private val matchDAO: MatchDAO
) {
    suspend fun insertarUsuario(usuario: Usuario): Long = usuarioDAO.insertar(usuario)
    fun loginUsuario(identificador: String, contrasena: String): Flow<Usuario?> = usuarioDAO.login(identificador, contrasena)
    fun obtenerUsuario(id: Int): Flow<Usuario?> = usuarioDAO.obtener(id)
    suspend fun insertarCalcetin(calcetin: Calcetin) = calcetinDAO.insertar(calcetin)
    suspend fun actualizarCalcetin(calcetin: Calcetin) = calcetinDAO.actualizar(calcetin)
    suspend fun eliminarCalcetin(calcetin: Calcetin) = calcetinDAO.eliminar(calcetin)
    fun obtenerCalcetinesPorUsuario(usuarioId: Int): Flow<List<Calcetin>> = calcetinDAO.obtenerPorUsuario(usuarioId)
    fun obtenerTodosCalcetines(): Flow<List<Calcetin>> = calcetinDAO.obtenerTodos()
    fun obtenerCalcetinesLikeados(usuarioId: Int): Flow<List<Calcetin>> = calcetinDAO.obtenerCalcetinesLikeados(usuarioId)
    suspend fun insertarMatch(match: Match) = matchDAO.insertar(match)
    fun obtenerMatches(usuarioId: Int): Flow<List<Match>> = matchDAO.obtenerMatches(usuarioId)
}
