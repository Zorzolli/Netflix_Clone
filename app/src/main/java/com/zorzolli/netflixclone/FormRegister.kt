package com.zorzolli.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import kotlinx.android.synthetic.main.activity_form_register.*

class FormRegister : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_register)

        bt_register.setOnClickListener {

            RegisterUser()
        }
    }

    private fun RegisterUser() {

        var email = edit_email.text.toString()
        var password = edit_password.text.toString()
        var message = messageError

        if (email.isEmpty() || password.isEmpty()) {
            message.setText("Coloque o seu e-mail e sua senha!")
        } else {

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {

                    if (it.isSuccessful) {
                        Toast.makeText(this, "Cadastro Realizado com Sucesso!", Toast.LENGTH_SHORT).show()
                        BackToLogin()
                    }
                }.addOnFailureListener {

                var error = it

                when {
                    error is FirebaseAuthInvalidCredentialsException -> message.setText("Digite um e-mail válido!")
                    error is FirebaseAuthWeakPasswordException -> message.setText("Digite uma senha com no mínimo 6 caracteres!")
                    error is FirebaseAuthUserCollisionException -> message.setText("Esta conta já foi cadastrada!")
                    error is FirebaseNetworkException -> message.setText("Sem conexão com a internet!")
                    else -> message.setText("Erro ao cadastrar o usuário!")
                }
            }
        }

    }

    private fun BackToLogin () {

        var intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
        finish()
    }
}