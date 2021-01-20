package com.zorzolli.netflixclone

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_episodes.*

class Episodes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episodes)

        val videoImage = Uri.parse("https://firebasestorage.googleapis.com/v0/b/netflix-clone-4021d.appspot.com/o/Imagens%2Fvideo.jpg?alt=media&token=552998c1-fd31-4311-84ae-e8c63dc6e558")
        Picasso.get().load(videoImage).placeholder(R.drawable.gif).into(imageVideo)


        playVideo.setOnClickListener {
            var intent = Intent(this, Video::class.java)
            startActivity(intent)
        }
    }
}