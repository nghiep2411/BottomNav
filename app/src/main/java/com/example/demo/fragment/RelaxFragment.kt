package com.example.demo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.demo.R
import com.example.demo.adapter.RelaxViewPager2Adapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class RelaxFragment : Fragment() {


    lateinit var navigationRelax : BottomNavigationView
    lateinit var viewPager2Relax : ViewPager2
    lateinit var relaxViewPager2Adapter : RelaxViewPager2Adapter


    val FRAGMENT_MOVIE = 0
    val FRAGMENT_TELEVISION = 1
    val FRAGMENT_SPORT = 2
    val FRAGMENT_CLIP = 3
    val FRAGMENT_MUSIC = 4

    var mCurrentFragment = FRAGMENT_MOVIE



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_relax, container, false)
        navigationRelax=view.findViewById(R.id.bottom_navigation_tab_relax)

        navigationRelax.setOnItemSelectedListener{
            when (it.itemId) {
                R.id.nav_movie -> {
                    openMovieFragment()
                }
                R.id.nav_television-> {
                    openTelevisionFragment()
                }
                R.id.nav_sport -> {
                    openSportFragment()
                }
                R.id.nav_clip -> {
                    openClipFragment()
                }
                R.id.nav_music -> {
                    openMusicFragment()
                }
            }

            true}


        viewPager2Relax =  view.findViewById(R.id.view_pager_2)
        relaxViewPager2Adapter= RelaxViewPager2Adapter(context as FragmentActivity)
        viewPager2Relax.adapter = relaxViewPager2Adapter

        viewPager2Relax.registerOnPageChangeCallback(object  : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                when(position){
                    0->{
                        mCurrentFragment=FRAGMENT_MOVIE
                        navigationRelax.menu.findItem(R.id.nav_movie).isChecked=true
                    }
                    1->{
                        mCurrentFragment=FRAGMENT_TELEVISION
                        navigationRelax.menu.findItem(R.id.nav_television).isChecked=true
                    }
                    2->{
                        mCurrentFragment=FRAGMENT_SPORT
                        navigationRelax.menu.findItem(R.id.nav_sport).isChecked=true
                    }
                    3->{
                        mCurrentFragment=FRAGMENT_CLIP
                        navigationRelax.menu.findItem(R.id.nav_clip).isChecked=true
                    }
                    4->{
                        mCurrentFragment=FRAGMENT_MUSIC
                        navigationRelax.menu.findItem(R.id.nav_music).isChecked=true
                    }
                }
            }
        })

        return view
    }


    fun openMovieFragment(){
        if(mCurrentFragment != FRAGMENT_MOVIE){
            viewPager2Relax.currentItem=0
            mCurrentFragment = FRAGMENT_MOVIE
        }
    }
    fun openTelevisionFragment(){

        if(mCurrentFragment != FRAGMENT_TELEVISION){
            viewPager2Relax.currentItem=1
            mCurrentFragment = FRAGMENT_TELEVISION
        }
    }
    fun openSportFragment(){
        if(mCurrentFragment != FRAGMENT_SPORT){
            viewPager2Relax.currentItem=2
            mCurrentFragment = FRAGMENT_SPORT
        }
    }
    fun openClipFragment(){
        if(mCurrentFragment != FRAGMENT_CLIP){
            viewPager2Relax.currentItem=3
            mCurrentFragment = FRAGMENT_CLIP
        }
    }
    fun openMusicFragment(){
        if(mCurrentFragment != FRAGMENT_MUSIC){
            viewPager2Relax.currentItem=4
            mCurrentFragment = FRAGMENT_MUSIC
        }
    }



}