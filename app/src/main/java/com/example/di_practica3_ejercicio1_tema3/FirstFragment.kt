package com.example.di_practica3_ejercicio1_tema3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

    val listaItems = ArrayList<ShopItem>()

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listaItems.add(ShopItem(R.drawable.images, R.string.cafe0, R.string.subtitulo0))
        listaItems.add(ShopItem(R.drawable.images1, R.string.cafe1, R.string.subtitulo1))
        listaItems.add(ShopItem(R.drawable.images2, R.string.cafe2, R.string.subtitulo2))
        listaItems.add(ShopItem(R.drawable.images3, R.string.cafe3, R.string.subtitulo3))
        listaItems.add(ShopItem(R.drawable.images4, R.string.cafe4, R.string.subtitulo4))
        listaItems.add(ShopItem(R.drawable.images5, R.string.cafe5, R.string.subtitulo5))
        listaItems.add(ShopItem(R.drawable.images6, R.string.cafe6, R.string.subtitulo6))

        val recView = view.findViewById<RecyclerView>(R.id.rvShops)
        recView.setHasFixedSize(true)

        val adaptador = ShopItemAdapter(listaItems)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        adaptador.onClick = {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}