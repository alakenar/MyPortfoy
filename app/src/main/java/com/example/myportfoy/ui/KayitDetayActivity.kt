package com.example.myportfoy.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.model.VerilerKayit
import com.example.myportfoy.databinding.ActivityKayitDetayBinding

class KayitDetayActivity: AppCompatActivity() {

    private lateinit var kdetbind: ActivityKayitDetayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kdetbind = ActivityKayitDetayBinding.inflate(layoutInflater)
        setContentView(kdetbind.root)

        val veri = intent.extras?.getParcelable<VerilerKayit>("veri")


        kdetbind.adisoyad.text= "Adı Soyadı:"+ veri?.adsoyad.toString()

        kdetbind.firmaadi.text= "Firma Adı :"+ veri?.fadi.toString()

        kdetbind.telno.text="Tel No:"+ veri?.tno.toString()

        kdetbind.sozno.text="Soz No:"+ veri?.sno.toString()

        kdetbind.metinkutusu.text= " "+veri?.mkutusu.toString()



    }
}