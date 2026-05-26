package com.example.calcetinder.ui.miscalcetines;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J.\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/calcetinder/ui/miscalcetines/MisCalcetinesViewModel;", "Landroidx/lifecycle/ViewModel;", "repo", "Lcom/example/calcetinder/datos/Repositorio;", "(Lcom/example/calcetinder/datos/Repositorio;)V", "_calcetines", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/calcetinder/modelo/Calcetin;", "misCalcetines", "Lkotlinx/coroutines/flow/StateFlow;", "getMisCalcetines", "()Lkotlinx/coroutines/flow/StateFlow;", "actualizarCalcetin", "", "c", "cargarCalcetinesPorUsuario", "uid", "", "crearCalcetin", "nombre", "", "desc", "color", "material", "eliminarCalcetin", "app_debug"})
public final class MisCalcetinesViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.calcetinder.datos.Repositorio repo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.calcetinder.modelo.Calcetin>> _calcetines = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.calcetinder.modelo.Calcetin>> misCalcetines = null;
    
    public MisCalcetinesViewModel(@org.jetbrains.annotations.NotNull()
    com.example.calcetinder.datos.Repositorio repo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.calcetinder.modelo.Calcetin>> getMisCalcetines() {
        return null;
    }
    
    public final void cargarCalcetinesPorUsuario(int uid) {
    }
    
    public final void crearCalcetin(int uid, @org.jetbrains.annotations.NotNull()
    java.lang.String nombre, @org.jetbrains.annotations.NotNull()
    java.lang.String desc, @org.jetbrains.annotations.NotNull()
    java.lang.String color, @org.jetbrains.annotations.NotNull()
    java.lang.String material) {
    }
    
    public final void eliminarCalcetin(@org.jetbrains.annotations.NotNull()
    com.example.calcetinder.modelo.Calcetin c) {
    }
    
    public final void actualizarCalcetin(@org.jetbrains.annotations.NotNull()
    com.example.calcetinder.modelo.Calcetin c) {
    }
}