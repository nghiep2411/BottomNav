package com.example.demo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R
import com.example.demo.model.RelatedFilm
import com.makeramen.roundedimageview.RoundedImageView

class RelatedFilmAdapter(private var context: Context,private var listRelatedFilm : ArrayList<RelatedFilm>) :  RecyclerView.Adapter<RelatedFilmAdapter.RelatedFilmViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelatedFilmViewHolder {

        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_related_film,parent,false)
        return RelatedFilmViewHolder(view)
    }

    override fun onBindViewHolder(holder: RelatedFilmViewHolder, position: Int) {
        val currentItem : RelatedFilm = listRelatedFilm[position]
        holder.imageRelatedFilm.setImageResource(currentItem.image)
        holder.nameRelatedFilm.text=currentItem.name
    }

    override fun getItemCount(): Int {
        return listRelatedFilm.size
    }

    class RelatedFilmViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

        var imageRelatedFilm : RoundedImageView = itemView.findViewById(R.id.imageRelatedFilm)
        var nameRelatedFilm : TextView = itemView.findViewById(R.id.nameRelatedFilm)
    }
}