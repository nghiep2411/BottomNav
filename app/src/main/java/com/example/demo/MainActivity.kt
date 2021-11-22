package com.example.demo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.widget.ViewPager2
import com.example.demo.adapter.ViewPager2Adapter
import com.example.demo.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    lateinit var viewPagerAdapter : ViewPager2Adapter
    lateinit var viewPager2: ViewPager2
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var fragment: Fragment

    var FRAGMENT_HOME : Int = 1
    var FRAGMENT_MOVITEL : Int = 2
    var FRAGMENT_PROMOTION : Int = 3
    var FRAGMENT_SELFCARE : Int = 4
    var FRAGMENT_RELAX : Int = 5

    var mCurrentFragment = FRAGMENT_HOME





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        viewPager2=findViewById(R.id.viewPager2)
        bottomNavigationView=findViewById(R.id.bottom_navigation)

//        viewPagerAdapter= ViewPager2Adapter(this)
//        viewPager2.adapter=viewPagerAdapter
        replaceFragment(HomeFragment())


        bottomNavigationView.setOnItemSelectedListener{
            when (it.itemId) {
                R.id.home -> {
                    openHomeFragment()

                }
                R.id.movitel-> {
                    openMovitelFragment()
                }
                R.id.promotion -> {

                }
                R.id.selfcare -> {

                }
                R.id.relax -> {
                    openRelaxFragment()
                }
            }

            true}


    }

     fun replaceFragment(fragment: Fragment){
        val transaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_container,fragment)
        transaction.commit()
    }



    fun openHomeFragment(){
        if(mCurrentFragment != FRAGMENT_HOME){
            replaceFragment(HomeFragment())
            mCurrentFragment=FRAGMENT_HOME
        }
    }
    fun openMovitelFragment(){
        if(mCurrentFragment != FRAGMENT_MOVITEL){
            replaceFragment(ShopFragment())
            mCurrentFragment=FRAGMENT_MOVITEL
        }
    }
    fun openRelaxFragment(){
        if(mCurrentFragment != FRAGMENT_RELAX){
            replaceFragment(RelaxFragment())
            mCurrentFragment=FRAGMENT_RELAX
        }
    }

    class Builder internal constructor(private val contextForOpen: Context) {
        private var params: Bundle? = null


        fun start(fragmentClass: Class<out Fragment>, isFinish: Boolean = false) {
            try {
                val intent = Intent(contextForOpen, CategoryDetailFragment::class.java)
                intent.putExtras(params ?: Bundle())
//                intent.putExtra(STATUS_BAR_COLOR, statusBarColor)
//                intent.putExtra(SHOW_STATUS_BAR, showStatusBar)
//                intent.putExtra(SHOW_FULLSCREEN_WITH_STATUS_BAR, showFullScreen)
//                intent.putExtra(FRAGMENT_NAME, fragmentClass.name)
                contextForOpen.startActivity(intent)
                if (isFinish && contextForOpen is AppCompatActivity) contextForOpen.finish()
            } catch (e: Exception) {
                e.printStackTrace()

            }
        }
    }


}