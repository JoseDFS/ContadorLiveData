package com.example.contadorlive

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contadorlive.PartidoDB.PartidoEntity
import kotlinx.android.synthetic.main.recycler_view_item.view.*


class AdapterPartido(var partidos:List<PartidoEntity>,val clickListener: (PartidoEntity)->Unit): RecyclerView.Adapter<AdapterPartido.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return partidos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(partidos[position],clickListener)
    }

    fun updateList(newPartidos:List<PartidoEntity>){
        newPartidos.forEach{
            Log.d("QUe pex","x2")
        }
        this.partidos=newPartidos
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: PartidoEntity,clickListener: (PartidoEntity) -> Unit) = with(itemView) {
            this.tv_teams_vs.text = item.equipo_a + " vs " + item.equipo_b
            this.tv_fecha.text = item.fecha
            this.tv_id_partido.text = item.id.toString()
            this.setOnClickListener{clickListener(item)}

        }

    }
}