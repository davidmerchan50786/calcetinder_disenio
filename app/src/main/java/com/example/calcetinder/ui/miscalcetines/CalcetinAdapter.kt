package com.example.calcetinder.ui.miscalcetines

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calcetinder.databinding.ItemCalcetinBinding
import com.example.calcetinder.modelo.Calcetin

class CalcetinAdapter(
    private var lista: List<Calcetin> = emptyList(),
    private val esGestion: Boolean = false,
    private val onEdit: (Calcetin) -> Unit = {},
    private val onDelete: (Calcetin) -> Unit = {}
) : RecyclerView.Adapter<CalcetinAdapter.VH>() {

    inner class VH(val b: ItemCalcetinBinding) : RecyclerView.ViewHolder(b.root)

    override fun onCreateViewHolder(p: ViewGroup, t: Int) = 
        VH(ItemCalcetinBinding.inflate(LayoutInflater.from(p.context), p, false))

    override fun onBindViewHolder(h: VH, p: Int) {
        val c = lista[p]
        h.b.apply {
            tvNombre.text = c.nombre
            tvDescripcion.text = c.descripcion
            tvColor.text = "Color: ${c.color}"
            tvMaterial.text = "Material: ${c.material}"
            
            val visibilidad = if (esGestion) View.VISIBLE else View.GONE
            btnEditar.visibility = visibilidad
            btnEliminar.visibility = visibilidad
            
            btnEditar.setOnClickListener { onEdit(c) }
            btnEliminar.setOnClickListener { onDelete(c) }
        }
    }

    override fun getItemCount() = lista.size

    fun actualizar(nueva: List<Calcetin>) {
        lista = nueva
        notifyDataSetChanged()
    }
}