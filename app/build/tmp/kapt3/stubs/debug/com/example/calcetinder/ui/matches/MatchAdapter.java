package com.example.calcetinder.ui.matches;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\b2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/calcetinder/ui/matches/MatchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/calcetinder/ui/matches/MatchAdapter$VH;", "matches", "", "Lcom/example/calcetinder/modelo/Calcetin;", "(Ljava/util/List;)V", "actualizar", "", "nueva", "getItemCount", "", "onBindViewHolder", "h", "pos", "onCreateViewHolder", "p", "Landroid/view/ViewGroup;", "t", "VH", "app_debug"})
public final class MatchAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.calcetinder.ui.matches.MatchAdapter.VH> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.calcetinder.modelo.Calcetin> matches;
    
    public MatchAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.calcetinder.modelo.Calcetin> matches) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.example.calcetinder.ui.matches.MatchAdapter.VH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup p, int t) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.calcetinder.ui.matches.MatchAdapter.VH h, int pos) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void actualizar(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.calcetinder.modelo.Calcetin> nueva) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/calcetinder/ui/matches/MatchAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "b", "Lcom/example/calcetinder/databinding/ItemCalcetinBinding;", "(Lcom/example/calcetinder/ui/matches/MatchAdapter;Lcom/example/calcetinder/databinding/ItemCalcetinBinding;)V", "bind", "", "c", "Lcom/example/calcetinder/modelo/Calcetin;", "app_debug"})
    public final class VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.example.calcetinder.databinding.ItemCalcetinBinding b = null;
        
        public VH(@org.jetbrains.annotations.NotNull()
        com.example.calcetinder.databinding.ItemCalcetinBinding b) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.calcetinder.modelo.Calcetin c) {
        }
    }
}