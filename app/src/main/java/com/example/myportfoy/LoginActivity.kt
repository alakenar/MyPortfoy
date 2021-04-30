package com.example.myportfoy

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.databinding.LoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity(){

    private lateinit var loginbind: LoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginbind = LoginBinding.inflate(layoutInflater)
        setContentView(loginbind.root)

        auth = FirebaseAuth.getInstance()


        loginbind.uyeol.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        loginbind.girisButton.setOnClickListener {

            val mail = loginbind.girisMail.text.toString()
            val sifre = loginbind.girisSifre.text.toString()


            if (mail.isEmpty() || sifre.isEmpty()) {
                Toast.makeText(this, "Lütfen tüm alanları doldurun.", Toast.LENGTH_SHORT).show()
            } else {
                auth.signInWithEmailAndPassword(mail.trim(), sifre.trim())
                        .addOnSuccessListener {

                            val i = Intent(this, HomepageActivity::class.java)
                            startActivity(i)
                            LoginActivity().finish()

                        }.addOnFailureListener { exception ->
                            Toast.makeText(this, exception.localizedMessage, Toast.LENGTH_SHORT).show()
                        }
            }
        }

    }
}