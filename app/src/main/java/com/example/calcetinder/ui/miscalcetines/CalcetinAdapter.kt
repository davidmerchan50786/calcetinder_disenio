package com.example.calcetinder.ui.miscalcetines

import android.graphics.drawable.GradientDrawable
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
            ivCalcetin.setImageDrawable(GradientDrawable().apply {
                shape = GradientDrawable.OVAL
                setColor(colorHex(c.color))
            })
            val vis = if (esGestion) View.VISIBLE else View.GONE
            btnEditar.visibility = vis
            btnEliminar.visibility = vis
            btnEditar.setOnClickListener { onEdit(c) }
            btnEliminar.setOnClickListener { onDelete(c) }
        }
    }

    override fun getItemCount() = lista.size
    fun actualizar(nueva: List<Calcetin>) { lista = nueva; notifyDataSetChanged() }

    companion object {
        fun colorHex(nombre: String): Int = when (nombre.lowercase().trim()) {
            "rojo" -> 0xFFFF5252.toInt(); "verde" -> 0xFF4CAF50.toInt()
            "azul" -> 0xFF2196F3.toInt(); "amarillo" -> 0xFFFFEB3B.toInt()
            "negro" -> 0xFF212121.toInt(); "blanco" -> 0xFFEEEEEE.toInt()
            "gris" -> 0xFF9E9E9E.toInt(); "rosa" -> 0xFFE91E63.toInt()
            "naranja" -> 0xFFFF9800.toInt(); "morado" -> 0xFF9C27B0.toInt()
            "marrón" -> 0xFF795548.toInt(); "turquesa" -> 0xFF00BCD4.toInt()
            else -> 0xFFCCCCCC.toInt()
        }
    }
}
