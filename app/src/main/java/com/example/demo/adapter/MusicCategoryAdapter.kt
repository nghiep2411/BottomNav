package com.example.demo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R
import com.example.demo.model.Music
import com.makeramen.roundedimageview.RoundedImageView
import de.hdodenhof.circleimageview.CircleImageView

class MusicCategoryAdapter(val lists: ArrayList<Music>) : RecyclerView.Adapter<MusicCategoryAdapter.MusicCatViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicCatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category_music,parent,false)
        return MusicCatViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicCatViewHolder, position: Int) {
        val currentItem : Music = lists[position]
        holder.imageCat.setImageResource(currentItem.image)
        holder.nameCat.text=currentItem.name
    }

    override fun getItemCount(): Int {
       return lists.size
    }

    class MusicCatViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val imageCat : CircleImageView = itemView.findViewById(R.id.musicCategory)
        val nameCat : TextView = itemView.findViewById(R.id.categoryMusicName)
    }
}