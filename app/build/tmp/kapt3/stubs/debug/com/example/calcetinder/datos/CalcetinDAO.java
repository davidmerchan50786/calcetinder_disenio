package com.example.calcetinder.datos;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n2\u0006\u0010\u000b\u001a\u00020\fH\'J\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000e0\n2\u0006\u0010\u000f\u001a\u00020\fH\'J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000e0\nH\'\u00a8\u0006\u0011"}, d2 = {"Lcom/example/calcetinder/datos/CalcetinDAO;", "", "actualizar", "", "calcetin", "Lcom/example/calcetinder/modelo/Calcetin;", "(Lcom/example/calcetinder/modelo/Calcetin;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "eliminar", "insertar", "obtener", "Lkotlinx/coroutines/flow/Flow;", "id", "", "obtenerPorUsuario", "", "usuarioId", "obtenerTodos", "app_debug"})
@androidx.room.Dao()
public abstract interface CalcetinDAO {
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertar(@org.jetbrains.annotations.NotNull()
    com.example.calcetinder.modelo.Calcetin calcetin, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object actualizar(@org.jetbrains.annotations.NotNull()
    com.example.calcetinder.modelo.Calcetin calcetin, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object eliminar(@org.jetbrains.annotations.NotNull()
    com.example.calcetinder.modelo.Calcetin calcetin, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM calcetines WHERE id = :id")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.example.calcetinder.modelo.Calcetin> obtener(int id);
    
    @androidx.room.Query(value = "SELECT * FROM calcetines WHERE usuarioId = :usuarioId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.calcetinder.modelo.Calcetin>> obtenerPorUsuario(int usuarioId);
    
    @androidx.room.Query(value = "SELECT * FROM calcetines")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.calcetinder.modelo.Calcetin>> obtenerTodos();
}