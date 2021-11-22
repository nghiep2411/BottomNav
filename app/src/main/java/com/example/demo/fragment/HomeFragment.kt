package com.example.demo.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.demo.R
import com.example.demo.adapter.ImageSlideAdapter
import com.example.demo.adapter.VideoCategoryAdapter
import com.example.demo.model.Banner
import com.example.demo.model.ItemCategory
import com.example.demo.model.ListVideoCategory
import me.relex.circleindicator.CircleIndicator3


class HomeFragment : Fragment() {

    lateinit var recyclerView:RecyclerView
    lateinit var videoCategoryAdapter: VideoCategoryAdapter

    lateinit var viewPager2 : ViewPager2
    lateinit var bannerAdapter :  ImageSlideAdapter
    lateinit var mCircle3 : CircleIndicator3
    lateinit var listBanner: ArrayList<Banner>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
            val view = inflater.inflate(R.layout.fragment_home, container, false)
            recyclerView = view.findViewById(R.id.recyclerView_home)
            viewPager2= view.findViewById(R.id.viewPager2)
            mCircle3 =  view.findViewById(R.id.circle3)
            addDatatoList()
        addDataToViewPager2()

        //seting view pager 2
        viewPager2.offscreenPageLimit=3
        viewPager2.clipToPadding=false
        viewPager2.clipChildren=false

        val compositePageTranfomer : CompositePageTransformer =  CompositePageTransformer()
        compositePageTranfomer.addTransformer(MarginPageTransformer(40))
        viewPager2.setPageTransformer(compositePageTranfomer)


        return view


    }

    private fun addDataToViewPager2(){

        listBanner= ArrayList()
        listBanner.add(Banner(R.drawable.sangchi))
        listBanner.add(Banner(R.drawable.sangchi))
        listBanner.add(Banner(R.drawable.sangchi))
        listBanner.add(Banner(R.drawable.sangchi))
        listBanner.add(Banner(R.drawable.sangchi))
        listBanner.add(Banner(R.drawable.sangchi))
        listBanner.add(Banner(R.drawable.sangchi))

        bannerAdapter = ImageSlideAdapter(listBanner)
        viewPager2.adapter=bannerAdapter
        mCircle3.setViewPager(viewPager2)
    }
    private fun addDatatoList() {
//        var categoryList : ArrayList<ListVideoCategory> = ArrayList()
//        var listItemCategory : ArrayList<ItemCategory> =  ArrayList()
        val itemVideoCategory1 : ArrayList<ItemCategory> = ArrayList()
        itemVideoCategory1.add(ItemCategory(R.drawable.sangchi,"Sang Chi"))
        itemVideoCategory1.add(ItemCategory(R.drawable.sangchi,"Sang Chi"))
        itemVideoCategory1.add(ItemCategory(R.drawable.sangchi,"Sang Chi"))
        itemVideoCategory1.add(ItemCategory(R.drawable.sangchi,"Sang Chi"))
        itemVideoCategory1.add(ItemCategory(R.drawable.sangchi,"Sang Chi"))
        itemVideoCategory1.add(ItemCategory(R.drawable.sangchi,"Sang Chi"))
        itemVideoCategory1.add(ItemCategory(R.drawable.sangchi,"Sang Chi"))

        val itemVideoCategory2 : ArrayList<ItemCategory> = ArrayList()
        itemVideoCategory2.add(ItemCategory(R.drawable.sangchi,"Sang Chi"))
        itemVideoCategory2.add(ItemCategory(R.drawable.sangchi,"Sang Chi"))
        itemVideoCategory2.add(ItemCategory(R.drawable.sangchi,"Sang Chi"))
        itemVideoCategory2.add(ItemCategory(R.drawable.sangchi,"Sang Chi"))
        itemVideoCategory2.add(ItemCategory(R.drawable.sangchi,"Sang Chi"))
        itemVideoCategory2.add(ItemCategory(R.drawable.sangchi,"Sang Chi"))
        itemVideoCategory2.add(ItemCategory(R.drawable.sangchi,"Sang Chi"))

        val itemVideoCategory3 : ArrayList<ItemCategory> = ArrayList()
        itemVideoCategory3.add(ItemCategory(R.drawable.sangchi,"Sang Chi"))
        itemVideoCategory3.add(ItemCategory(R.drawable.sangchi,"Sang Chi"))
        itemVideoCategory3.add(ItemCategory(R.drawable.sangchi,"Sang Chi"))
        itemVideoCategory3.add(ItemCategory(R.drawable.sangchi,"Sang Chi"))
        itemVideoCategory3.add(ItemCategory(R.drawable.sangchi,"Sang Chi"))
        itemVideoCategory3.add(ItemCategory(R.drawable.sangchi,"Sang Chi"))
        itemVideoCategory3.add(ItemCategory(R.drawable.sangchi,"Sang Chi"))

        val listVideoCategory : ArrayList<ListVideoCategory> =  ArrayList()
        listVideoCategory.add(ListVideoCategory("Title 1",itemVideoCategory1))
        listVideoCategory.add(ListVideoCategory("Title 2",itemVideoCategory2))
        listVideoCategory.add(ListVideoCategory("Title 3",itemVideoCategory3))

        videoCategoryAdapter = VideoCategoryAdapter(requireContext().applicationContext,listVideoCategory)
        val layoutManager  = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=videoCategoryAdapter
        recyclerView.setHasFixedSize(true)
    }

}