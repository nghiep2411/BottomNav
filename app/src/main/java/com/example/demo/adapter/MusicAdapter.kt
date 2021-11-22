package com.example.demo.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R
import com.example.demo.`interface`.OnClickItemMusic
import com.example.demo.`interface`.OnClickListener
import com.example.demo.model.Movie
import com.example.demo.model.Music
import com.makeramen.roundedimageview.RoundedImageView
import com.example.demo.*
import com.example.demo.fragment.CategoryDetailFragment


class MusicAdapter(val context: Context, val lists : ArrayList<Music>
//,val listener : OnClickItemMusic
)
    : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

//    private lateinit var mListener: OnClickItemMusic
//
//
//    fun setItemClickListener(itemClickListener: OnClickItemMusic) {
//        mListener = itemClickListener
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_music,parent,false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val currentItem : Music = lists[position]
        holder.imageMusic.setImageResource(currentItem.image)
        holder.nameMusic.text= currentItem.name
//        holder.imagePlay.setOnClickListener { object : View.OnClickListener{
//            override fun onClick(v: View?) {
//                Toast.makeText(context,"Play music ",Toast.LENGTH_LONG).show()
//            }
//        }
//        }
        holder.itemView.setOnClickListener {
            Toast.makeText(context,"Open play music fragment",Toast.LENGTH_LONG).show()
            val intent = Intent(context,AloneFragmentActivity::class.java)
            context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return lists.size
    }

    class MusicViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
//        ,View.OnClickListener
    {
        val imageMusic : RoundedImageView = itemView.findViewById(R.id.imageMusic)
        val imagePlay : ImageView = itemView.findViewById(R.id.imagePlay)
        val nameMusic : TextView = itemView.findViewById(R.id.nameMusic)
//
//        init {
//            itemView.setOnClickListener(this)
//        }
//
//        override fun onClick(v: View?) {
//            TODO("Not yet implemented")
//        }
    }


}