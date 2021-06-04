package com.example.myportfoy.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.databinding.ActivityYeniKayitBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap


class YeniKayitActivity: AppCompatActivity() {

    private lateinit var ykayitbind: ActivityYeniKayitBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ykayitbind = ActivityYeniKayitBinding.inflate(layoutInflater)
        setContentView(ykayitbind.root)


        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        ykayitbind.yeniKayitButton.setOnClickListener {

            val adsoyad = ykayitbind.adSoyad.text.toString()
            val fadi = ykayitbind.firmaAdi.text.toString()
            val tno = ykayitbind.telNo.text.toString()
            val sno = ykayitbind.sozNo.text.toString()
            val mkutusu= ykayitbind.metinKutusu.text.toString()

            if (adsoyad.isEmpty() || fadi.isEmpty() || adsoyad.isEmpty() || fadi.isEmpty()|| mkutusu.isEmpty()) {
                Toast.makeText(this, "Lütfen tüm alanları doldurun.", Toast.LENGTH_SHORT).show()
            } else {

                kayıtOl(adsoyad, fadi, tno, sno, mkutusu)
            }
        }
    }

            private fun kayıtOl(adsoyad: String, fadi: String, tno:String, sno: String, mkutusu: String) {


                val firebaseUser = auth.currentUser
                val userId = firebaseUser!!.uid

                reference = database.getReference("YeniKayıt")

                val cal = Calendar.getInstance();
                val dateOnly = SimpleDateFormat("dd/MM/yyyy");
                val date= dateOnly.format(cal.getTime())

                val hashMap: HashMap<String, Any> = HashMap()

                hashMap["userId"] = userId
                hashMap["adsoyad"] = adsoyad
                hashMap["fadi"] = fadi
                hashMap["tno"] = tno
                hashMap["sno"] = sno
                hashMap["mkutusu"] = mkutusu
                hashMap["olusturmaTarihi"] = date



                reference.push().setValue(hashMap).addOnSuccessListener {


                    Toast.makeText(this, "Yeni kişi kaydedilmiştir.", Toast.LENGTH_SHORT).show()


                    val i = Intent(this, MusteriListesiActivity::class.java)
                    startActivity(i)
                    YeniKayitActivity().finish()

                }.addOnFailureListener { Toast.makeText(this, "Yeni kişi eklenirken bir hata oluştu. Lütfen boşlukları eksiksiz doldurarak yeniden deneyin", Toast.LENGTH_SHORT).show()
                }
        }

    }
