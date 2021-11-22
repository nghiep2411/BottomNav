package com.example.demo.model

data class ListMusic(
    val type: Int,
    val title: String, val listMusicCat: ArrayList<Music>?, val listMusic: ArrayList<Music>?
)