package com.example.calcetinder.datos;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010\u0018J\u001e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cJ\u001a\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u001f0\u001a2\u0006\u0010 \u001a\u00020!J\u001a\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u001f0\u001a2\u0006\u0010 \u001a\u00020!J\u001a\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001f0\u001a2\u0006\u0010 \u001a\u00020!J\u0012\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u001f0\u001aJ\u0016\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u001a2\u0006\u0010&\u001a\u00020!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/example/calcetinder/datos/Repositorio;", "", "usuarioDAO", "Lcom/example/calcetinder/datos/UsuarioDAO;", "calcetinDAO", "Lcom/example/calcetinder/datos/CalcetinDAO;", "matchDAO", "Lcom/example/calcetinder/datos/MatchDAO;", "(Lcom/example/calcetinder/datos/UsuarioDAO;Lcom/example/calcetinder/datos/CalcetinDAO;Lcom/example/calcetinder/datos/MatchDAO;)V", "actualizarCalcetin", "", "calcetin", "Lcom/example/calcetinder/modelo/Calcetin;", "(Lcom/example/calcetinder/modelo/Calcetin;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "eliminarCalcetin", "insertarCalcetin", "insertarMatch", "match", "Lcom/example/calcetinder/modelo/Match;", "(Lcom/example/calcetinder/modelo/Match;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertarUsuario", "", "usuario", "Lcom/example/calcetinder/modelo/Usuario;", "(Lcom/example/calcetinder/modelo/Usuario;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginUsuario", "Lkotlinx/coroutines/flow/Flow;", "identificador", "", "contrasena", "obtenerCalcetinesLikeados", "", "usuarioId", "", "obtenerCalcetinesPorUsuario", "obtenerMatches", "obtenerTodosCalcetines", "obtenerUsuario", "id", "app_debug"})
public final class Repositorio {
    @org.jetbrains.annotations.NotNull()
    private final com.example.calcetinder.datos.UsuarioDAO usuarioDAO = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.calcetinder.datos.CalcetinDAO calcetinDAO = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.calcetinder.datos.MatchDAO matchDAO = null;
    
    public Repositorio(@org.jetbrains.annotations.NotNull()
    com.example.calcetinder.datos.UsuarioDAO usuarioDAO, @org.jetbrains.annotations.NotNull()
    com.example.calcetinder.datos.CalcetinDAO calcetinDAO, @org.jetbrains.annotations.NotNull()
    com.example.calcetinder.datos.MatchDAO matchDAO) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertarUsuario(@org.jetbrains.annotations.NotNull()
    com.example.calcetinder.modelo.Usuario usuario, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.calcetinder.modelo.Usuario> loginUsuario(@org.jetbrains.annotations.NotNull()
    java.lang.String identificador, @org.jetbrains.annotations.NotNull()
    java.lang.String contrasena) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.calcetinder.modelo.Usuario> obtenerUsuario(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertarCalcetin(@org.jetbrains.annotations.NotNull()
    com.example.calcetinder.modelo.Calcetin calcetin, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object actualizarCalcetin(@org.jetbrains.annotations.NotNull()
    com.example.calcetinder.modelo.Calcetin calcetin, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object eliminarCalcetin(@org.jetbrains.annotations.NotNull()
    com.example.calcetinder.modelo.Calcetin calcetin, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.calcetinder.modelo.Calcetin>> obtenerCalcetinesPorUsuario(int usuarioId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.calcetinder.modelo.Calcetin>> obtenerTodosCalcetines() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.calcetinder.modelo.Calcetin>> obtenerCalcetinesLikeados(int usuarioId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertarMatch(@org.jetbrains.annotations.NotNull()
    com.example.calcetinder.modelo.Match match, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.calcetinder.modelo.Match>> obtenerMatches(int usuarioId) {
        return null;
    }
}