package com.example.calcetinder.ui.swipe;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u0012H\u0082@\u00a2\u0006\u0002\u0010\u0017R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/calcetinder/ui/swipe/SwipeViewModel;", "Landroidx/lifecycle/ViewModel;", "repo", "Lcom/example/calcetinder/datos/Repositorio;", "(Lcom/example/calcetinder/datos/Repositorio;)V", "_calcetines", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/calcetinder/modelo/Calcetin;", "_indice", "", "calcetines", "Lkotlinx/coroutines/flow/StateFlow;", "getCalcetines", "()Lkotlinx/coroutines/flow/StateFlow;", "indiceActual", "getIndiceActual", "cargarCalcetines", "", "dislike", "like", "usuarioId", "siguiente", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class SwipeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.calcetinder.datos.Repositorio repo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.calcetinder.modelo.Calcetin>> _calcetines = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.calcetinder.modelo.Calcetin>> calcetines = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _indice = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> indiceActual = null;
    
    public SwipeViewModel(@org.jetbrains.annotations.NotNull()
    com.example.calcetinder.datos.Repositorio repo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.calcetinder.modelo.Calcetin>> getCalcetines() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getIndiceActual() {
        return null;
    }
    
    public final void cargarCalcetines() {
    }
    
    public final void like(int usuarioId) {
    }
    
    public final void dislike() {
    }
    
    private final java.lang.Object siguiente(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}