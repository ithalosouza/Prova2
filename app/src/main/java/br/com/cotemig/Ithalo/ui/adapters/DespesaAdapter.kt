package br.com.cotemig.Ithalo.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.Ithalo.R
import br.com.cotemig.Ithalo.models.ListaDespesa
import coil.load
import org.w3c.dom.Text

class DespesaAdapter ( var context: Context, var despesa: List<ListaDespesa>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_fatura, parent, false)
        return GalleryHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as GalleryHolder).bind(despesa[position])
    }

    override fun getItemCount(): Int {
        return despesa.size
    }

    class GalleryHolder(var view: View) : RecyclerView.ViewHolder(view) {
        fun bind(listaDespesa: ListaDespesa) {

            var image = view.findViewById<ImageView>(R.id.imagem)
            image.load(listaDespesa.imagem)

            var tipo = view.findViewById<TextView>(R.id.tipo)
            tipo.text = listaDespesa.tipo

            var data = view.findViewById<TextView>(R.id.data)
            data.text = listaDespesa.data

            var valor = view.findViewById<TextView>(R.id.valor)
            valor.text = listaDespesa.valor

            var descricao = view.findViewById<TextView>(R.id.descricao)
            descricao.text = listaDespesa.descricao

        }
    }
}