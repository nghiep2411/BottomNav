package com.example.demo

import android.content.Intent
import android.content.res.Resources
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.demo.model.Songs
import com.example.demo.service.MyService


class PlayMusicFragment : Fragment() {

    lateinit var seekBar: SeekBar
    lateinit var tvProgress : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_play_music, container, false)
        seekBar = view.findViewById(R.id.seekBar)

        seekBar.thumb = getThumb(0)



        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {

                // You can have your own calculation for progress
                seekBar.thumb = getThumb(progress)

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }
            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })

        return view

    }

    private fun getThumb(progress : Int): Drawable? {
        val thumbView: View = LayoutInflater.from(requireContext())
            .inflate(R.layout.layout_seekbar_thumb, null, false)
        (thumbView.findViewById(R.id.tvProgress) as TextView).text = progress.toString()
        thumbView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        val bitmap = Bitmap.createBitmap(
            thumbView.measuredWidth ,
            thumbView.measuredHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        thumbView.layout(1, 1, thumbView.measuredWidth, thumbView.measuredHeight)
        thumbView.draw(canvas)
        return BitmapDrawable(resources, bitmap)
    }

    fun clickStartService(){
        val song =  Songs(R.drawable.sangchi,"Sang chi","hiepnn")
        val intent = Intent(requireContext(),MyService::class.java)
        val bundle  = Bundle()
        bundle.putSerializable("object_song",song)
        context?.startService(intent)
    }
    fun clickStopService(){
        val intent = Intent(requireContext(),MyService::class.java)
        context?.stopService(intent)
    }


}