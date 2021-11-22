package com.example.demo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R
import com.example.demo.model.ItemCategory
import com.example.demo.model.ListVideoCategory

class VideoCategoryAdapter(var context : Context,var listVideoCategory : ArrayList<ListVideoCategory>) :
    RecyclerView.Adapter<VideoCategoryAdapter.VideoCategoryViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoCategoryViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_parent,parent,false)
        return VideoCategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoCategoryViewHolder, position: Int) {
        val currentItem : ListVideoCategory = listVideoCategory[position]
        holder.title.text=currentItem.title


        setCatItemRecycler(holder.rcvHome,currentItem.itemCategory)
//        val listItemCategory : ArrayList<ItemCategory> =  holder.
//        val adapterChild  = ItemCategoryAdapter(listItemCategory)
//        val layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
//        holder.rcvHome.layoutManager=layoutManager
//        holder.rcvHome.adapter=adapterChild
    }

    override fun getItemCount(): Int {
        return listVideoCategory.size
    }

    class VideoCategoryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var title : TextView =itemView.findViewById(R.id.textTitle)
        var rcvHome : RecyclerView = itemView.findViewById(R.id.recyclerParent)
    }

    fun setCatItemRecycler(recyclerView : RecyclerView, list:ArrayList<ItemCategory>){
        val catItemAdapter = ItemCategoryAdapter(context,list)
        recyclerView.layoutManager= GridLayoutManager(context,3)
        recyclerView.adapter=catItemAdapter
    }
}