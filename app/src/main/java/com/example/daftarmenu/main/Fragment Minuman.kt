package com.example.daftarmenu.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daftarmenu.R
import com.example.daftarmenu.R.layout
import com.example.daftarmenu.data.MenuModel
import kotlinx.android.synthetic.main.fragment_minuman.rv_minuman

class FragmentMinuman : Fragment() {
    companion object {
        fun getInstance(): FragmentMinuman {
            return FragmentMinuman()
        }
    }
    val dataMinuman= mutableListOf<MenuModel>()
    val rvAdapter=RvAdapter(dataMinuman)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            layout.fragment_minuman,
            container, false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_minuman.adapter=rvAdapter
        rv_minuman.layoutManager=
            LinearLayoutManager(context)

        addDummyData()
    }

    private fun addDummyData(){
        dataMinuman.add(
            MenuModel("Es Jeruk",
                "Rp 2.500,00",
                R.drawable.jeruk)
        )
        dataMinuman.add(
            MenuModel("Teh Anget",
                "Rp 2.000,00",
                R.drawable.teh)
        )
        dataMinuman.add(
            MenuModel("Kopi Panas",
                "Rp 3.000,00",
                R.drawable.coffee)
        )
        rvAdapter.notifyDataSetChanged()

    }
}