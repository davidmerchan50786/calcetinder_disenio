package com.example.calcetinder.datos;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J \u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\'J\u0018\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\'J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u000bH\'\u00a8\u0006\u0014"}, d2 = {"Lcom/example/calcetinder/datos/UsuarioDAO;", "", "actualizar", "", "usuario", "Lcom/example/calcetinder/modelo/Usuario;", "(Lcom/example/calcetinder/modelo/Usuario;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "eliminar", "insertar", "", "login", "Lkotlinx/coroutines/flow/Flow;", "identificador", "", "contrasena", "obtener", "id", "", "obtenerTodos", "", "app_debug"})
@androidx.room.Dao()
public abstract interface UsuarioDAO {
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertar(@org.jetbrains.annotations.NotNull()
    com.example.calcetinder.modelo.Usuario usuario, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object actualizar(@org.jetbrains.annotations.NotNull()
    com.example.calcetinder.modelo.Usuario usuario, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object eliminar(@org.jetbrains.annotations.NotNull()
    com.example.calcetinder.modelo.Usuario usuario, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM usuarios WHERE id = :id")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.example.calcetinder.modelo.Usuario> obtener(int id);
    
    @androidx.room.Query(value = "SELECT * FROM usuarios WHERE (email = :identificador OR nombre = :identificador) AND contrasena = :contrasena")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.example.calcetinder.modelo.Usuario> login(@org.jetbrains.annotations.NotNull()
    java.lang.String identificador, @org.jetbrains.annotations.NotNull()
    java.lang.String contrasena);
    
    @androidx.room.Query(value = "SELECT * FROM usuarios")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.calcetinder.modelo.Usuario>> obtenerTodos();
}