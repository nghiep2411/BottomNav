package com.example.demo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R
import com.example.demo.model.ListMusic

class ListMusicAdapter(val context: Context,val list : ArrayList<ListMusic>) : RecyclerView.Adapter<ListMusicAdapter.ListMusicViewHolder>() {

    companion object{
        val TYPE_MUSIC_CATEGORY = 1
        val TYPE_MUSIC_ITEM = 2
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMusicViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.layout_list_music,parent,false)
        return ListMusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListMusicViewHolder, position: Int) {
        val currentItem = list[position]
        if(holder.itemViewType == TYPE_MUSIC_CATEGORY){
            val layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            val adapterCat = currentItem.listMusicCat?.let { MusicCategoryAdapter(it) }
            holder.recyclerView.layoutManager=layoutManager
            holder.titleMusic.text=currentItem.title
            holder.recyclerView.adapter=adapterCat

        }else if(holder.itemViewType == TYPE_MUSIC_ITEM){
//            val layoutManager = GridLayoutManager(context,2,GridLayoutManager.HORIZONTAL,false)

//    val layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
            val layoutManager = GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false)
            val adapterMusic = currentItem.listMusic?.let { MusicAdapter(context, it) }
            holder.recyclerView.layoutManager=layoutManager
            holder.titleMusic.text=currentItem.title
            holder.recyclerView.adapter=adapterMusic

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ListMusicViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val recyclerView : RecyclerView = itemView.findViewById(R.id.recycler_list_music)
        val titleMusic : TextView = itemView.findViewById(R.id.titleMusic)
    }

}