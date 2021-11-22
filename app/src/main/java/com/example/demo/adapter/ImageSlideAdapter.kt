package com.example.demo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R
import com.example.demo.model.Banner
import com.makeramen.roundedimageview.RoundedImageView

class ImageSlideAdapter(var list : ArrayList<Banner>) : RecyclerView.Adapter<ImageSlideAdapter.ImageSlideViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageSlideViewHolder {
        val view : View =LayoutInflater.from(parent.context).inflate(R.layout.item_banner,parent,false)
        return ImageSlideViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageSlideViewHolder, position: Int) {
        val currentItem : Banner = list[position]
        holder.imageBanner.setImageResource(currentItem.imageBanner)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ImageSlideViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var imageBanner : RoundedImageView = itemView.findViewById(R.id.imageBanner)
    }
}