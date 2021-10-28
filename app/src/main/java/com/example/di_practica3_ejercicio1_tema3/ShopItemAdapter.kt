package com.example.di_practica2_ejercicio4_tema3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.di_practica3_ejercicio1_tema3.R

class ShopItemAdapter(var listaItems: ArrayList<ShopItem>) : RecyclerView.Adapter<ShopItemAdapter.ItemViewHolder>() {
    lateinit var onClick : (View) -> Unit


    //La clase declarada como itemViewHolder hereda, es, un ViewHolder
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var titulo: TextView
        private var subtitulo: TextView
        private var estrellas: RatingBar
        private var puntuacion: TextView
        private var imagen: ImageView

        init {
            titulo = itemView.findViewById(R.id.tvTitulo)
            subtitulo = itemView.findViewById(R.id.tvSubtitulo)
            estrellas = itemView.findViewById(R.id.rbEstrellas)
            puntuacion = itemView.findViewById(R.id.tvPuntuacion)
            imagen = itemView.findViewById(R.id.ivImagen)
        }

        fun bindTarjeta(item: ShopItem, onClick: (View) -> Unit) = with(itemView) {
            titulo.setText(item.titulo)
            subtitulo.setText(item.subtitulo)
            imagen.setImageResource(item.imagen)
            estrellas.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener{ratingBar, rating, fromUser ->
                puntuacion.text = rating.toString()
            }
            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.shop_item, viewGroup, false)
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