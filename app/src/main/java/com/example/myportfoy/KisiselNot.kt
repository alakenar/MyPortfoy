package com.example.myportfoy

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.databinding.KisiselNotBinding

class KisiselNot: AppCompatActivity() {

    private lateinit var knotbind: KisiselNotBinding


    internal var numara: String?= ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        knotbind = KisiselNotBinding.inflate(layoutInflater)
        setContentView(knotbind.root)

            val veri = intent.extras?.getParcelable<Veriler>("veri")

           val notBasligi = findViewById<TextView>(R.id.not_basligi)
           notBasligi.text= veri?.nbaslik.toString()

          val yazilanNot = findViewById<TextView>(R.id.yazilan_not)
          yazilanNot.text= veri?.ynot.toString()



    }
}