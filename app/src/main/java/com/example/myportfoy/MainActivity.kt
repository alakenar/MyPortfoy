package com.example.myportfoy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myportfoy.databinding.MainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {


    private lateinit var mainbind: MainBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainbind = MainBinding.inflate(layoutInflater)
        setContentView(mainbind.root)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        if (auth.currentUser != null) {
        val i = Intent(this, HomepageActivity::class.java)
        startActivity(i)
          }

        mainbind.zbhvView.setOnClickListener {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }

        mainbind.kayitButton.setOnClickListener{

            val mail = mainbind.kayitMail.text.toString()
            val sifre = mainbind.kayitSifre.text.toString()

            if (mail.isEmpty() || sifre.isEmpty()) {
                Toast.makeText(this, "Lütfen tüm alanları doldurun.", Toast.LENGTH_SHORT).show()
            } else if (sifre.length < 6) {
                Toast.makeText(this, "Şifre en az 6 karakter olmalı.", Toast.LENGTH_SHORT).show()
            } else {
                kayitOl(mail, sifre)
            }
        }
    }

             private fun kayitOl(mail: String, sifre: String) {
            auth.createUserWithEmailAndPassword(mail.trim(), sifre)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        val firebaseUser = auth.currentUser
                        val userId = firebaseUser!!.uid

                        reference = database.getReference("Kullanicilar").child(userId)


                        val hashMap: HashMap<String, String> = HashMap()

                        hashMap["userID"] = userId
                        hashMap["mail"] = mail.trim()
                        hashMap["sifre"] = sifre

                        reference.setValue(hashMap)

                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                        MainActivity().finish()

                        Log.d("MainActivity",  "Email is:" +mail)
                        Log.d("MainActivity",  "Password is: $sifre")
                    }
                }.addOnFailureListener { exception ->
                    Toast.makeText(this, exception.localizedMessage, Toast.LENGTH_SHORT).show()
                }
    }
    }
