package com.example.myportfoy

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.databinding.YeniKayitBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class YeniKayit: AppCompatActivity() {

    private lateinit var ykayitbind: YeniKayitBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ykayitbind = YeniKayitBinding.inflate(layoutInflater)
        setContentView(ykayitbind.root)


        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        ykayitbind.yeniKayitButton.setOnClickListener {

            val asoyad = ykayitbind.adSoyad.text.toString()
            val fadi = ykayitbind.firmaAdi.text.toString()
            val tno = ykayitbind.telNo.text.toString()
            val sno = ykayitbind.sozNo.text.toString()
            val mkutusu= ykayitbind.metinKutusu.text.toString()

            if (asoyad.isEmpty() || fadi.isEmpty() || asoyad.isEmpty() || fadi.isEmpty()|| mkutusu.isEmpty()) {
                Toast.makeText(this, "Lütfen tüm alanları doldurun.", Toast.LENGTH_SHORT).show()
            } else {

                kayıtOl(asoyad, fadi, tno, sno, mkutusu)
            }
        }
    }

            private fun kayıtOl(adsoyad: String, fadi: String, tno:String, sno: String, mkutusu: String) {


                val firebaseUser = auth.currentUser
                val userId = firebaseUser!!.uid

                reference = database.getReference("YeniKayıt")

                val hashMap: HashMap<String, String> = HashMap()

                hashMap["userId"] = userId
                hashMap["adsoyad"] = adsoyad
                hashMap["fadi"] = fadi
                hashMap["tno"] = tno
                hashMap["sno"] = sno
                hashMap["mkutusu"] = mkutusu



                reference.push().setValue(hashMap).addOnSuccessListener {


                    Toast.makeText(this, ".", Toast.LENGTH_SHORT).show()


                    val i = Intent(this, HomepageActivity::class.java)
                    startActivity(i)
                    YeniKayit().finish()

                }.addOnFailureListener { Toast.makeText(this, "Yeni Kişi Eklenilemedi.", Toast.LENGTH_SHORT).show()
                }
        }

    }
