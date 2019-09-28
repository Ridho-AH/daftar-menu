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
import kotlinx.android.synthetic.main.fragment_makanan.rv_makanan

class FragmentMakanan : Fragment() {
    companion object {
        fun getInstance(): FragmentMakanan {
            return FragmentMakanan()
        }
    }
    val dataMakanan= mutableListOf<MenuModel>()
    val rvAdapter=RvAdapter(dataMakanan)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(
            layout.fragment_makanan,
            container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_makanan.adapter=rvAdapter
        rv_makanan.layoutManager=
            LinearLayoutManager(context)

        addDummyData()
    }

    private fun addDummyData(){
        dataMakanan.add(
            MenuModel("Mie",
                "Rp 3.500,00",
                R.drawable.mie)
        )
        dataMakanan.add(
            MenuModel("Nasgor",
                "Rp 9.000,00",
                R.drawable.nasgor)
        )
        dataMakanan.add(
            MenuModel("Soto",
                "Rp 4.500,00",
                R.drawable.soto)
        )
        rvAdapter.notifyDataSetChanged()

    }
}