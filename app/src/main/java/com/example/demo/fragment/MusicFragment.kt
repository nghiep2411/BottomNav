package com.example.demo.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R
import com.example.demo.adapter.ListMusicAdapter
import com.example.demo.model.ListMusic
import com.example.demo.model.Music

import java.lang.Exception
import androidx.fragment.app.FragmentActivity
import com.example.demo.AloneFragmentActivity
import com.example.demo.MainActivity
import com.example.demo.`interface`.OnClickItemMusic


class MusicFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    lateinit var recyclerView: RecyclerView
    lateinit var adapter : ListMusicAdapter


    lateinit var fragmentAlone : FrameLayout

    private var myContext: FragmentActivity? = null





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_music, container, false)

        recyclerView=view.findViewById(R.id.recycler_music)


//        button.setOnClickListener {
//            Toast.makeText(requireContext(),"open play music fragment",Toast.LENGTH_LONG).show()
//            val detailFragment  = CategoryDetailFragment()
//            activity?.supportFragmentManager!!.beginTransaction().replace(R.id.fragment_detail,detailFragment)
//                .addToBackStack(null)
//                .commit()
//        }


        recyclerView.layoutManager= LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        adapter = ListMusicAdapter(requireContext(),getListData())

        recyclerView.adapter=adapter

        return view
    }


    private fun getListData(): ArrayList<ListMusic> {

        val listMusic : ArrayList<ListMusic> = ArrayList()

        val listMusicCat : ArrayList<Music> = ArrayList()
        listMusicCat.add(Music(R.drawable.st,"Son tung MTP"))
        listMusicCat.add(Music(R.drawable.vq,"Viet Quang"))
        listMusicCat.add(Music(R.drawable.st,"Son tung MTP"))
        listMusicCat.add(Music(R.drawable.vq,"Viet Quang"))
        listMusicCat.add(Music(R.drawable.st,"Son tung MTP"))
        listMusicCat.add(Music(R.drawable.vq,"Viet Quang"))
        listMusicCat.add(Music(R.drawable.st,"Son tung MTP"))
        listMusicCat.add(Music(R.drawable.vq,"Viet Quang"))
        listMusicCat.add(Music(R.drawable.st,"Son tung MTP"))
        listMusicCat.add(Music(R.drawable.vq,"Viet Quang"))

        val listMusicToDay : ArrayList<Music> = ArrayList()
        listMusicToDay.add(Music(R.drawable.ame,"Ame 1"))
        listMusicToDay.add(Music(R.drawable.ame,"Ame 2"))
        listMusicToDay.add(Music(R.drawable.ame,"Ame 3"))
        listMusicToDay.add(Music(R.drawable.ame,"Ame 4"))
        listMusicToDay.add(Music(R.drawable.ame,"Ame 5"))
        listMusicToDay.add(Music(R.drawable.ame,"Ame 6"))
        listMusicToDay.add(Music(R.drawable.ame,"Ame 7"))
        listMusicToDay.add(Music(R.drawable.ame,"Ame 8"))
        listMusicToDay.add(Music(R.drawable.ame,"Ame 9"))
        listMusicToDay.add(Music(R.drawable.ame,"Ame 10"))
        listMusicToDay.add(Music(R.drawable.ame,"Ame 11"))
        listMusicToDay.add(Music(R.drawable.ame,"Ame 12"))

        listMusic.add(ListMusic(ListMusicAdapter.TYPE_MUSIC_CATEGORY,"Music Category",listMusicCat,null))
        listMusic.add(ListMusic(ListMusicAdapter.TYPE_MUSIC_ITEM,"Music TODAY",null,listMusicToDay))

        return listMusic

    }

//    override fun onClickItemMusic() {
//        val intent  = Intent(context,CategoryDetailFragment::class.java)
//        startActivity(intent)
//    }


}