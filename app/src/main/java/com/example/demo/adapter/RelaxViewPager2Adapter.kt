package com.example.demo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.demo.fragment.*

class RelaxViewPager2Adapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {


    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 ->  MovieFragment()
            1 ->  TelevisionFragment()
            2 -> SportFragment()
            3 -> ClipFragment()
            else -> MusicFragment()

        }

    }
}