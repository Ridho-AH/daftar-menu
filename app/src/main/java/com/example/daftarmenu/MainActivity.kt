package com.example.daftarmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.tab_main
import kotlinx.android.synthetic.main.activity_main.vp_main

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vp_main.adapter = ViewPageAdapter(supportFragmentManager)
        tab_main.setupWithViewPager(vp_main)
    }

    inner class ViewPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        private val pages = listOf(
            FragmentMakanan.getInstance(),
            FragmentMinuman.getInstance()
        )

        override fun getItem(position: Int): Fragment {
            return pages[position]
        }

        override fun getCount(): Int {
            return pages.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when (position) {
                0 -> "Makanan"
                else -> "Minuman"
            }
        }
    }
}
