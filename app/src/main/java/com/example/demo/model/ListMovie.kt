package com.example.demo.model

data class ListMovie(
    val type: Int,
    val titleMovie : String,
    val listMovieCat: ArrayList<Movie>?,
    val listTopMovie: ArrayList<Movie>?
)