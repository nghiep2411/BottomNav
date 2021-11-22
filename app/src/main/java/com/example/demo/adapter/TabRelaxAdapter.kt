package com.example.demo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R
import com.example.demo.model.Movie
import com.makeramen.roundedimageview.RoundedImageView

class TabRelaxAdapter(val context: Context, val list: ArrayList<Movie>)  : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object {
        const val MOVIE_CATEGORY = 1
        const val TOP_MOVIE = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == MOVIE_CATEGORY){
            return MovieCatViewHolder(LayoutInflater.from(context).inflate(R.layout.item_category,parent,false))
        }else if(viewType == TOP_MOVIE){
            return TopMovieViewHolder(LayoutInflater.from(context).inflate(R.layout.item_film,parent,false))
        }else{
            return MovieCatViewHolder(LayoutInflater.from(context).inflate(R.layout.item_category,parent,false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem =  list[position]
        if(holder is MovieCatViewHolder){
            holder.imageCat.setImageResource(currentItem.image)
            holder.nameCat.text=currentItem.name
        }else if(holder is TopMovieViewHolder ){
            holder.imageMovie.setImageResource(currentItem.image)
            holder.nameMovie.text=currentItem.name
        }
    }

    override fun getItemViewType(position: Int): Int {
        return 0
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MovieCatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val imageCat :  RoundedImageView = itemView.findViewById(R.id.imageCategory)
        val nameCat : TextView =  itemView.findViewById(R.id.nameCategory)

    }
    class TopMovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val imageMovie :  RoundedImageView = itemView.findViewById(R.id.imageFilm)
        val nameMovie : TextView =  itemView.findViewById(R.id.nameFlim)

    }
}