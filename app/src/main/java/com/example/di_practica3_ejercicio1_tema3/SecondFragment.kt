package com.example.di_practica3_ejercicio1_tema3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Transition
import androidx.transition.TransitionInflater
import com.example.di_practica3_ejercicio1_tema3.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */

//TERMINAR
/*
El layout de este fragment contiene un titulo cuyo texto debe ser
el nombre del item shop seleccionado y un recycler view cuyo contenido
son una serie de cardViews con text.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /*
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
        */
        val slide: Transition = TransitionInflater.from(activity).inflateTransition(R.transition.slide)
        sharedElementEnterTransition = slide
        sharedElementReturnTransition = slide

        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    val listaItems = ArrayList<CommentItem>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listaItems.add(CommentItem(R.string.comentario0))
        listaItems.add(CommentItem(R.string.comentario1))
        listaItems.add(CommentItem(R.string.comentario2))
        listaItems.add(CommentItem(R.string.comentario3))
        listaItems.add(CommentItem(R.string.comentario4))

        /*
        Recogemos el valor de la clave del bundle suministrado por FirstFragment
         */
        val nombreTienda = view.findViewById<TextView>(R.id.tvNombreTienda)
        nombreTienda.text = (arguments?.getString("tvNombreTienda"))

        val recView = view.findViewById<RecyclerView>(R.id.rvComentarios)
        recView.setHasFixedSize(true)

        val adaptador = CommentItemAdapter(listaItems)
        recView.adapter = adaptador
        recView.layoutManager = GridLayoutManager(context, 2)



        adaptador.onClick = {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}