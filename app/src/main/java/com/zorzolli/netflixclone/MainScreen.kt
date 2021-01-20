package com.zorzolli.netflixclone

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main_screen.*

class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        var serie = serie1
        val images = Uri.parse("https://firebasestorage.googleapis.com/v0/b/netflix-clone-4021d.appspot.com/o/Imagens%2Fwitcher.png?alt=media&token=947f5ed2-0103-4dff-b1e0-13abaca820bb")

        Picasso.get().load(images).fit().placeholder(R.drawable.gif).into(serie1)
        Picasso.get().load(images).fit().placeholder(R.drawable.gif).into(serie2)
        Picasso.get().load(images).fit().placeholder(R.drawable.gif).into(serie3)
        Picasso.get().load(images).fit().placeholder(R.drawable.gif).into(serie4)

        serie.setOnClickListener {
            var intent = Intent(this, Episodes::class.java)
            startActivity(intent)
            finish()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_main_screen, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_getOut -> {
                FirebaseAuth.getInstance().signOut()
                BackFormLogin()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun BackFormLogin() {
        var intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
        finish()
    }
}