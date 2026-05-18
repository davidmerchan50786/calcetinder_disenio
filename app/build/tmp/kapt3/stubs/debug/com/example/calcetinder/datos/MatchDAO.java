package com.example.calcetinder.datos;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\'J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'\u00a8\u0006\r"}, d2 = {"Lcom/example/calcetinder/datos/MatchDAO;", "", "insertar", "", "match", "Lcom/example/calcetinder/modelo/Match;", "(Lcom/example/calcetinder/modelo/Match;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "obtenerMatches", "Lkotlinx/coroutines/flow/Flow;", "", "usuarioId", "", "obtenerTodos", "app_debug"})
@androidx.room.Dao()
public abstract interface MatchDAO {
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertar(@org.jetbrains.annotations.NotNull()
    com.example.calcetinder.modelo.Match match, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM matches WHERE usuarioId = :usuarioId AND tipoMatch = \'like\'")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.calcetinder.modelo.Match>> obtenerMatches(int usuarioId);
    
    @androidx.room.Query(value = "SELECT * FROM matches")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.calcetinder.modelo.Match>> obtenerTodos();
}