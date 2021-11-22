package com.example.demo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.demo.fragment.*

class ViewPager2Adapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {


    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 ->  HomeFragment()
            1 ->  ShopFragment()
            2 ->  SelfcareFragment()
            3 ->  UtilitiesFragment()
            else ->  RelaxFragment()

        }
    }

}