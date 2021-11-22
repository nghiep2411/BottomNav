package com.example.demo

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.PixelFormat
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.google.android.exoplayer2.DefaultLoadControl
import com.google.android.exoplayer2.LoadControl
import java.net.URL
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector

import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.util.Util
import java.lang.Exception
import android.media.MediaPlayer.OnPreparedListener
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.*
import android.os.Build
import android.os.Handler
import android.view.Window
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.adapter.RelatedFilmAdapter
import com.example.demo.fragment.HomeFragment
import com.example.demo.model.RelatedFilm
import com.shuyu.gsyvideoplayer.video.NormalGSYVideoPlayer
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer


class PlayVideoActivity : AppCompatActivity()  {


    var urlVideo : String = "https://vod03-cdn.fptplay.net/ovod/_definst_/smil:mp4/encoded/20211027/diemtinucl_ronaldovuotmatmessi/a55ffe5ea59b38b9fc2e2dc26b0b841c.smil/chunklist_b1596000.m3u8"
    lateinit var normalGSYVideoPlayer: NormalGSYVideoPlayer
    lateinit var adapter : RelatedFilmAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var listRelatedFilm : ArrayList<RelatedFilm>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_video)
        normalGSYVideoPlayer =  findViewById(R.id.video_player)
        recyclerView=findViewById(R.id.recycler_related_film)
        addDataTolist()


        normalGSYVideoPlayer.setUpLazy(urlVideo,true , null , null,"Title Video ")
//        gsyPlayer.titleTextView.visibility=GONE
        normalGSYVideoPlayer.fullscreenButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                normalGSYVideoPlayer.startWindowFullscreen(this@PlayVideoActivity, false, true)

            }
        })
        normalGSYVideoPlayer.isAutoFullWithSize=true
        normalGSYVideoPlayer.isReleaseWhenLossAudio=false
        normalGSYVideoPlayer.isShowFullAnimation=true
        normalGSYVideoPlayer.setIsTouchWiget(false)
        normalGSYVideoPlayer.backButton.setOnClickListener(object  : View.OnClickListener{
            override fun onClick(v: View?) {
                startActivity(Intent(this@PlayVideoActivity,HomeFragment::class.java))

            }
        })

        normalGSYVideoPlayer

        normalGSYVideoPlayer.playTag="Tag"
        normalGSYVideoPlayer.isAutoFullWithSize=true
        normalGSYVideoPlayer.isReleaseWhenLossAudio=true


    }

    private fun addDataTolist() {

        listRelatedFilm = ArrayList()
        listRelatedFilm.add(RelatedFilm(R.drawable.sangchi,"Name 1"))
        listRelatedFilm.add(RelatedFilm(R.drawable.sangchi,"Name 2"))
        listRelatedFilm.add(RelatedFilm(R.drawable.sangchi,"Name 3"))
        listRelatedFilm.add(RelatedFilm(R.drawable.sangchi,"Name 4"))
        listRelatedFilm.add(RelatedFilm(R.drawable.sangchi,"Name 5"))
        listRelatedFilm.add(RelatedFilm(R.drawable.sangchi,"Name 6"))
        listRelatedFilm.add(RelatedFilm(R.drawable.sangchi,"Name 7"))

        val layoutManager =  LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        adapter=RelatedFilmAdapter(this,listRelatedFilm)
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=adapter

    }

    override fun onPause() {
        super.onPause()
        normalGSYVideoPlayer.onVideoPause()
    }

    override fun onResume() {
        super.onResume()
        normalGSYVideoPlayer.onVideoResume()
    }
}
