package com.example.di_practica3_ejercicio1_tema3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.di_practica2_ejercicio4_tema3.ShopItem
import com.example.di_practica2_ejercicio4_tema3.ShopItemAdapter
import com.example.di_practica3_ejercicio1_tema3.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
/*
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

 */
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    val listaShops = ArrayList<ShopItem>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listaShops.add(ShopItem(R.drawable.images, R.string.cafe0, R.string.subtitulo0))
        listaShops.add(ShopItem(R.drawable.images1, R.string.cafe1, R.string.subtitulo1))
        listaShops.add(ShopItem(R.drawable.images2, R.string.cafe2, R.string.subtitulo2))
        listaShops.add(ShopItem(R.drawable.images3, R.string.cafe3, R.string.subtitulo3))
        listaShops.add(ShopItem(R.drawable.images4, R.string.cafe4, R.string.subtitulo4))
        listaShops.add(ShopItem(R.drawable.images5, R.string.cafe5, R.string.subtitulo5))
        listaShops.add(ShopItem(R.drawable.images6, R.string.cafe6, R.string.subtitulo6))

        val recView = view.findViewById<RecyclerView>(R.id.rvShops)
        recView.setHasFixedSize(true)

        val adaptador = ShopItemAdapter(listaShops)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        /*
        Al hacer click en uno de los elementos de la lista suministrada al adaptador
        navegaremos al segundo fragmento, que contendra una lista de comentarios.
        Se debe suministrar al SecondFragment el titulo del item shop seleccionado
        para mostrarlo como tvNombreTienda en fragment_second.
         */
        adaptador.onClick = {
            val itemSeleccionado = listaShops[recView.getChildAdapterPosition(it)]
            /*
            El titulo de ShopItem es un entero que apunta a un recurso, debemos llamar al recurso

            BundleOf define una clave y un valor, en el segundo framento usaremos la clave
            para obtener el valor y asignarno a tvNombreTienda
            */
            val bundle = bundleOf("tvNombreTienda" to resources.getString(itemSeleccionado.titulo))
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}