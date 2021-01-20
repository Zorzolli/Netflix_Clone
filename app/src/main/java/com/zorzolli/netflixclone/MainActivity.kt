package com.zorzolli.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        Handler().postDelayed({openLogin()}, 3000)
    }

    private fun openLogin() {

        var intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
        finish()
    }
}