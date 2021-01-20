package com.zorzolli.netflixclone

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_video.*

class Video : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val videoUrl = Uri.parse("https://firebasestorage.googleapis.com/v0/b/netflix-clone-4021d.appspot.com/o/Videos%2FTHE%20WITCHER%20_%20TRAILER%20FINAL%20_%20NETFLIX.mp4?alt=media&token=66d77d00-8b54-413d-96db-f843a8b67621")

        val decordview = window.decorView
        val options = View.SYSTEM_UI_FLAG_FULLSCREEN
        decordview.systemUiVisibility = options

        video.setMediaController(MediaController(this))
        video.setVideoURI(videoUrl)
        video.requestFocus()
    }
}