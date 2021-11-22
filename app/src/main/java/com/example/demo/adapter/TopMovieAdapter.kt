package com.example.demo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R
import com.example.demo.model.Movie

class TopMovieAdapter(val listTopMovie : ArrayList<Movie>) : RecyclerView.Adapter<TopMovieAdapter.TopMovieViewHodler>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopMovieViewHodler {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_film,parent,false)
        return TopMovieViewHodler(view)
    }

    override fun onBindViewHolder(holder: TopMovieViewHodler, position: Int) {
        val currentItem = listTopMovie[position]
        holder.imageMovie.setImageResource(currentItem.image)
        holder.nameMovie.text=currentItem.name
    }

    override fun getItemCount(): Int {
        return  listTopMovie.size
    }

    class TopMovieViewHodler(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val imageMovie : ImageView =  itemView.findViewById(R.id.imageFilm)
        val nameMovie : TextView =  itemView.findViewById(R.id.nameFlim)
    }
}