package com.example.myportfoy

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.databinding.KayitDetayBinding

class KayitDetay: AppCompatActivity() {

    private lateinit var kdetbind: KayitDetayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kdetbind = KayitDetayBinding.inflate(layoutInflater)
        setContentView(kdetbind.root)

        val veri = intent.extras?.getParcelable<VerilerKayit>("veri")


        kdetbind.adisoyad.text= veri?.adsoyad.toString()

        kdetbind.firmaadi.text= veri?.fadi.toString()

        kdetbind.telno.text=veri?.tno.toString()

        kdetbind.sozno.text=veri?.sno.toString()

        kdetbind.metinkutusu.text=veri?.mkutusu.toString()



    }
}