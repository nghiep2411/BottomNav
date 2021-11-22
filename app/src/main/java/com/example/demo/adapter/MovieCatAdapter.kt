package com.example.demo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R
import com.example.demo.model.Movie

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.demo.fragment.CategoryDetailFragment

import androidx.fragment.app.FragmentTransaction


class MovieCatAdapter( val listMovieCat: ArrayList<Movie>) : RecyclerView.Adapter<MovieCatAdapter.MovieCatViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false)
        return MovieCatViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieCatViewHolder, position: Int) {
        val currentItem = listMovieCat[position]
        holder.imageCat.setImageResource(currentItem.image)
        holder.nameCat.text=currentItem.name
        holder.itemView.setOnClickListener { object :View.OnClickListener{
            override fun onClick(v: View?) {

            }
        }
        }
    }

    override fun getItemCount(): Int {
        return listMovieCat.size
    }

    class MovieCatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageCat : ImageView =  itemView.findViewById(R.id.imageCategory)
        val nameCat : TextView =  itemView.findViewById(R.id.nameCategory)
    }
}