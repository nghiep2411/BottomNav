package com.example.demo.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.PlayMusicActivity
import com.example.demo.PlayMusicFragment
import com.example.demo.R
import com.example.demo.adapter.AlbumDetailAdapter
import com.example.demo.fragment.ClipFragment.Companion.newInstance
import com.example.demo.model.Songs


class AlbumDetailFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter : AlbumDetailAdapter
    lateinit var openPlayMusic : Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_album_detail, container, false)
        recyclerView= view.findViewById(R.id.rcv_list_song)
        openPlayMusic = view.findViewById(R.id.button)

        adapter = AlbumDetailAdapter(getListSong())
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter

        openPlayMusic.setOnClickListener {
//            val transaction : FragmentTransaction = supportFragmentManager.beginTransaction()
//            transaction.replace(R.id.nav_container,fragment)
//            transaction.commit()

//            requireActivity()
//                .supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.fragment_alone, PlayMusicFragment())
//                .commitNow()

            val intent = Intent(context,PlayMusicActivity::class.java)
            context?.startActivity(intent)
        }

        return view


    }

    private fun getListSong()  : ArrayList<Songs> {
        val listSong : ArrayList<Songs> = ArrayList()
        listSong.add(Songs(R.drawable.st,"Name 1","Single 1"))
        listSong.add(Songs(R.drawable.st,"Name 2","Single 2"))
        listSong.add(Songs(R.drawable.st,"Name 3","Single 3"))
        listSong.add(Songs(R.drawable.st,"Name 4","Single 4"))
        listSong.add(Songs(R.drawable.st,"Name 5","Single 5"))
        listSong.add(Songs(R.drawable.st,"Name 6","Single 6"))
        listSong.add(Songs(R.drawable.st,"Name 7","Single 7"))
        return listSong
    }


}