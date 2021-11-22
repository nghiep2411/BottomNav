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
import com.example.demo.model.ListMovie

class ListMovieAdapter(val context:Context, val listMovie: ArrayList<ListMovie>) : RecyclerView.Adapter<ListMovieAdapter.ListMovieViewHolder>()  {

    companion object{
        val TYPE_CATEGORY = 1
        val TYPE_TOP_MOVIE = 2

    }

    override fun getItemViewType(position: Int): Int {
        return listMovie[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_list_movie,parent,false)
        return ListMovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListMovieViewHolder, position: Int) {
        val currentItem = listMovie[position]
        if(holder.itemViewType == TYPE_CATEGORY){
            val layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            holder.titleMovie.text = currentItem.titleMovie
            holder.rcvItem.layoutManager=layoutManager
            val catAdapter = currentItem.listMovieCat?.let { MovieCatAdapter(it) }
            holder.rcvItem.adapter=catAdapter
        }else if(holder.itemViewType == TYPE_TOP_MOVIE){
            val layoutManager = GridLayoutManager(context,3,GridLayoutManager.VERTICAL,false)
            holder.titleMovie.text = currentItem.titleMovie
            holder.rcvItem.layoutManager=layoutManager
            val topMovieAdapter = currentItem.listTopMovie?.let { TopMovieAdapter(it) }
            holder.rcvItem.adapter=topMovieAdapter
        }
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    class ListMovieViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val titleMovie : TextView = itemView.findViewById(R.id.titleMovie)
        val rcvItem : RecyclerView = itemView.findViewById(R.id.recycler_list_movie)
    }
}