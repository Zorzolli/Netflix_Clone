package com.zorzolli.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import kotlinx.android.synthetic.main.activity_form_login.*

class FormLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)

        CheckLoggedUser()

        var textRegister = text_signUp

        textRegister.setOnClickListener {
            openRegister()
        }

        bt_login.setOnClickListener {

            AuthenticateUser()
        }

    }

    private fun AuthenticateUser() {

        var email = edit_email.text.toString()
        var password = edit_password.text.toString()
        var message = messageError

        if(email.isEmpty() || password.isEmpty()) {
            message.setText("Coloque o seu e-mail e sua senha!")
        } else {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Login Efetuado com Sucesso!", Toast.LENGTH_SHORT).show()
                    OpenMainScreen()
                }
            }.addOnFailureListener {

                var error = it

                when {
                    error is FirebaseAuthInvalidCredentialsException -> message.setText("E-mail ou senha estão incorretos!")
                    error is FirebaseNetworkException -> message.setText("Sem conexão com a internet!")
                    else -> message.setText("Erro ao logar usuário!")
                }

            }
        }
    }

    private fun CheckLoggedUser() {

        val currentUser = FirebaseAuth.getInstance().currentUser

        if (currentUser != null) {
            OpenMainScreen()
        }
    }

    private fun OpenMainScreen() {
        var intent = Intent(this, MainScreen::class.java)
        startActivity(intent)
        finish()
    }

    private fun openRegister() {
        var intent = Intent(this, FormRegister::class.java)
        startActivity(intent)
    }
}