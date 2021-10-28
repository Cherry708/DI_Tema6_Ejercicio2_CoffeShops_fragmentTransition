package com.example.di_practica3_ejercicio1_tema3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentItemAdapter(var listaItems: ArrayList<CommentItem>)
    : RecyclerView.Adapter<CommentItemAdapter.ItemViewHolder>() {
    lateinit var onClick : (View) -> Unit


    //La clase declarada como itemViewHolder hereda, es, un ViewHolder
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var comentario: TextView

        init {
            comentario = itemView.findViewById(R.id.tvComentario)
        }

        fun bindTarjeta(item: CommentItem, onClick: (View) -> Unit) = with(itemView) {
            comentario.setText(item.comentario)

            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.comment_item, viewGroup, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: ItemViewHolder, pos: Int) {
        val item = listaItems.get(pos)
        viewHolder.bindTarjeta(item, onClick)
    }

    override fun getItemCount(): Int {
        return listaItems.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}