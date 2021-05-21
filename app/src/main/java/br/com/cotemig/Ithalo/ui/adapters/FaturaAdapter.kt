package br.com.cotemig.Ithalo.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.Ithalo.R
import br.com.cotemig.Ithalo.models.Fatura

class FaturaAdapter (var context: Context, var list: List<Fatura>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
                var view = LayoutInflater.from(context).inflate(R.layout.item_fatura, parent, false)
                return FaturaHolder(view)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                (holder as FaturaHolder).bind(context, list[position])
        }

        override fun getItemCount(): Int {
                return list.size
        }

        class FaturaHolder(var view: View) : RecyclerView.ViewHolder(view) {

                fun bind(context: Context, fatura: Fatura) {

                        var limiteDisponivel = view.findViewById<TextView>(R.id.limiteDisponivel)
                        limiteDisponivel.text = fatura.limiteDisponivel

                        var valor = view.findViewById<TextView>(R.id.valor)
                        valor.text = fatura.valor

                        var vencimento = view.findViewById<TextView>(R.id.vencimento)
                        vencimento.text = fatura.vencimento

                        var despesa = view.findViewById<RecyclerView>(R.id.recyclerViewFatura)
                        despesa.adapter = DespesaAdapter(context, fatura.despesas)
                        despesa.layoutManager =
                                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

                        despesa.onFlingListener = null

                        var snapHelper = PagerSnapHelper()
                        snapHelper.attachToRecyclerView(despesa)

                }
        }

}