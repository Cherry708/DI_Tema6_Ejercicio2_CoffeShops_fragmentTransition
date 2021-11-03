package com.example.di_practica2_ejercicio4_tema3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.di_practica3_ejercicio1_tema3.R

/*
Los adaptadores cuentan con dos clases fundamentales que cooperan para definir la forma
en la que se presentan los datos.

La clase ShopItemAdapter es un Adapter y la clase ItemViewHolder es un ViewHolder

Al definir todos los adaptadores, que heredan de Adapter, es necesario sobrecargar
los metodos abstractos de la interfaz.


 */

class ShopItemAdapter(var listaItems: ArrayList<ShopItem>) :
    RecyclerView.Adapter<ShopItemAdapter.ItemViewHolder>() {
    lateinit var onClick : (View) -> Unit


    /*
    La clase declarada como itemViewHolder hereda, es, un ViewHolder.
    En esta clase proporcionamos una referencia al tipo de views que usaremos,
    es decir, definiremos el aspecto de las views.
     */
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /*
        Propiedades que componen la view
         */
        private var titulo: TextView
        private var subtitulo: TextView
        private var estrellas: RatingBar
        private var puntuacion: TextView
        private var imagen: ImageView

        /*
        Asignamos a las propiedades las views que componen el item
         */
        init {
            titulo = itemView.findViewById(R.id.tvTitulo)
            subtitulo = itemView.findViewById(R.id.tvSubtitulo)
            estrellas = itemView.findViewById(R.id.rbEstrellas)
            puntuacion = itemView.findViewById(R.id.tvPuntuacion)
            imagen = itemView.findViewById(R.id.ivImagen)
        }

        /*
        Asignamos a las propiedades de la view el contenido de cada item,
        cada uno de estos items pertenece a la lista de items suministrada al adaptador.
        Los items son proporcionados en el metodo onBindViewHolder,
         */
        fun bindTarjeta(item: ShopItem, onClick: (View) -> Unit) = with(itemView) {
            titulo.setText(item.titulo)
            subtitulo.setText(item.subtitulo)
            imagen.setImageResource(item.imagen)
            estrellas.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener{
                    ratingBar, rating, fromUser -> puntuacion.text = rating.toString()
            }
            setOnClickListener { onClick(itemView) }
        }
    }

    /*
    Sobrecargamos los metodos abstractos de la interfaz Adapter para determinar el funcionamiento
    de nuestro adaptador.
     */

    /*
    Generamos una nueva view, esta funcion es invocada por la clase LayourManager que
    determina la vista de las views. (recView.layoutManager = LinearLayoutManager(...))
     */
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.shop_item, viewGroup, false)
        return ItemViewHolder(itemView)
    }

    /*
    Sustituye el contenido de las views que componen a los items
     */
    override fun onBindViewHolder(viewHolder: ItemViewHolder, pos: Int) {
        //Recogemos un elemento de la lista de items
        val item = listaItems.get(pos)
        //Asignamos al viewHolder el item mediante el metodo bindTarjeta
        viewHolder.bindTarjeta(item, onClick)
    }

    override fun getItemCount(): Int {
        return listaItems.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}