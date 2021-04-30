package com.example.myportfoy

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.databinding.KisiselNotEkleBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*
import kotlin.collections.HashMap

class KisiselNotEkle : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference
    private lateinit var knoteklebind: KisiselNotEkleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        knoteklebind = KisiselNotEkleBinding.inflate(layoutInflater)
        setContentView(knoteklebind.root)


        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()


        knoteklebind.notEkle.setOnClickListener {

            val nbaslik = knoteklebind.notBasligi.text.toString()
            val ynot = knoteklebind.yazilanNot.text.toString()

            if (nbaslik.isEmpty() || ynot.isEmpty()) {
                Toast.makeText(this, "Lütfen tüm alanları doldurun.", Toast.LENGTH_SHORT).show()
            } else {

                kNotEkle(nbaslik, ynot)
            }
        }


    }
        private fun kNotEkle(nbaslik: String, ynot: String) {


            val firebaseUser = auth.currentUser
            val userId = firebaseUser!!.uid

            reference = database.getReference("Notlar")

            val hashMap: HashMap<String, String> = HashMap()

            hashMap["userId"] = userId
            hashMap["nbaslik"] = nbaslik
            hashMap["ynot"] = ynot

            reference.push().setValue(hashMap).addOnSuccessListener {


                Toast.makeText(this, "Notunuz kaydedilmiştir.", Toast.LENGTH_SHORT).show()


                val i = Intent(this, KisiselNotlarListe::class.java)
                startActivity(i)
                KisiselNotEkle().finish()

            }.addOnFailureListener { Toast.makeText(this, "Notunuz kaydedilemedi.", Toast.LENGTH_SHORT).show()
            }
        }
    }





