package com.example.demo.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.PlayVideoActivity
import com.example.demo.R

import com.example.demo.model.ItemCategory

class ItemCategoryAdapter(var context:Context,var listItemCategory : ArrayList<ItemCategory>) : RecyclerView.Adapter<ItemCategoryAdapter.ItemCategoryViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_child,parent,false)
        return ItemCategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemCategoryViewHolder, position: Int) {
        val currentItem : ItemCategory= listItemCategory[position]
        holder.imageFilm.setImageResource(currentItem.imageFilm)
        holder.titleFilm.text= currentItem.titleFilm
        holder.itemView.setOnClickListener {
            val intent = Intent(context, PlayVideoActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listItemCategory.size
    }

    class ItemCategoryViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val imageFilm : ImageView = itemView.findViewById(R.id.imageFilm)
        val titleFilm : TextView = itemView.findViewById(R.id.textTitleFilm)
    }
}