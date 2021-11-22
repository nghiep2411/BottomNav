package com.example.demo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R
import com.example.demo.model.Songs

class AlbumDetailAdapter(val listSong : ArrayList<Songs>) : RecyclerView.Adapter<AlbumDetailAdapter.AlbumDetailViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumDetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_songs,parent,false)
        return AlbumDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumDetailViewHolder, position: Int) {
        val currentItem : Songs = listSong[position]
        holder.imageSong.setImageResource(currentItem.imageSong)
        holder.nameSong.text = currentItem.nameSong
        holder.singleSong.text = currentItem.singleSong

    }

    override fun getItemCount(): Int {
        return listSong.size
    }

    class AlbumDetailViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val imageSong : ImageView = itemView.findViewById(R.id.imgSong)
        val nameSong : TextView = itemView.findViewById(R.id.nameSong)
        val singleSong : TextView = itemView.findViewById(R.id.singleSong)
    }
}