package com.example.calcetinder.ui.matches;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/calcetinder/ui/matches/MatchesViewModel;", "Landroidx/lifecycle/ViewModel;", "repo", "Lcom/example/calcetinder/datos/Repositorio;", "(Lcom/example/calcetinder/datos/Repositorio;)V", "_matches", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/calcetinder/modelo/Calcetin;", "matches", "Lkotlinx/coroutines/flow/StateFlow;", "getMatches", "()Lkotlinx/coroutines/flow/StateFlow;", "cargarMatches", "", "usuarioId", "", "app_debug"})
public final class MatchesViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.calcetinder.datos.Repositorio repo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.calcetinder.modelo.Calcetin>> _matches = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.calcetinder.modelo.Calcetin>> matches = null;
    
    public MatchesViewModel(@org.jetbrains.annotations.NotNull()
    com.example.calcetinder.datos.Repositorio repo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.calcetinder.modelo.Calcetin>> getMatches() {
        return null;
    }
    
    public final void cargarMatches(int usuarioId) {
    }
}