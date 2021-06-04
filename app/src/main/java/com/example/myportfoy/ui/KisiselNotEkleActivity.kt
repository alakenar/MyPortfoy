package com.example.myportfoy.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.databinding.ActivityKisiselNotEkleBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

class KisiselNotEkleActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference
    private lateinit var knoteklebind: ActivityKisiselNotEkleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        knoteklebind = ActivityKisiselNotEkleBinding.inflate(layoutInflater)
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


            val cal = Calendar.getInstance();
            val dateOnly = SimpleDateFormat("dd/MM/yyyy");
            val datet= dateOnly.format(cal.getTime())

            val hashMap: HashMap<String, Any> = HashMap()


            hashMap["userId"] = userId
            hashMap["nbaslik"] = nbaslik
            hashMap["ynot"] = ynot
            hashMap["olusturmaTarihi2"] = datet

            reference.push().setValue(hashMap).addOnSuccessListener {


                Toast.makeText(this, "Notunuz kaydedilmiştir.", Toast.LENGTH_SHORT).show()


                val i = Intent(this, KisiselNotlarListeActivity::class.java)
                startActivity(i)
                KisiselNotEkleActivity().finish()

            }.addOnFailureListener { Toast.makeText(this, "Notunuz kaydedilemedi.", Toast.LENGTH_SHORT).show()
            }
        }
    }





