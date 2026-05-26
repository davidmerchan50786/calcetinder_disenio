package com.example.calcetinder.ui.matches

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calcetinder.databinding.ItemCalcetinBinding
import com.example.calcetinder.modelo.Calcetin
import com.example.calcetinder.ui.miscalcetines.CalcetinAdapter

class MatchAdapter(private var matches: List<Calcetin>) : RecyclerView.Adapter<MatchAdapter.VH>() {
    inner class VH(private val b: ItemCalcetinBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(c: Calcetin) {
            b.tvNombre.text = c.nombre
            b.tvDescripcion.text = c.descripcion
            b.tvColor.text = "Color: ${c.color}"
            b.tvMaterial.text = "Material: ${c.material}"
            b.ivCalcetin.setImageDrawable(GradientDrawable().apply {
                shape = GradientDrawable.OVAL
                setColor(CalcetinAdapter.colorHex(c.color))
            })
            b.btnEditar.visibility = android.view.View.GONE
            b.btnEliminar.visibility = android.view.View.GONE
        }
    }
    override fun onCreateViewHolder(p: ViewGroup, t: Int) =
        VH(ItemCalcetinBinding.inflate(LayoutInflater.from(p.context), p, false))
    override fun onBindViewHolder(h: VH, pos: Int) = h.bind(matches[pos])
    override fun getItemCount() = matches.size
    fun actualizar(nueva: List<Calcetin>) { matches = nueva; notifyDataSetChanged() }
}
