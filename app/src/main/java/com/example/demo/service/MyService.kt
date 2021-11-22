package com.example.demo.service

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.demo.PlayMusicFragment
import com.example.demo.R
import com.example.demo.notification.MyApplication.Companion.CHANNEL_ID


class MyService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
       return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.e("hiepnn","service oncreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("hiepnn","service onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.e("hiepnn","service onDestroy")
        super.onDestroy()
    }

    fun sendNotification(str : String){
        val intent = Intent(this,PlayMusicFragment::class.java)
        val pendingIntent =  PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val notification = NotificationCompat.Builder(this,CHANNEL_ID).setContentTitle("Music player app")
            .setContentText("Play music")
            .setSmallIcon(R.drawable.ic_music)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1,notification)
    }

}