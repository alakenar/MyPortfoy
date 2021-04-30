package com.example.myportfoy

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.databinding.KisiselNotlarBinding

class KisiselNotlar: AppCompatActivity() {

    private lateinit var knotlarbind: KisiselNotlarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        knotlarbind = KisiselNotlarBinding.inflate(layoutInflater)
        setContentView(knotlarbind.root)


        knotlarbind.kisiselNotEkle.setOnClickListener {
            val intent = Intent(this, KisiselNotEkle::class.java)
            startActivity(intent)

        }
        knotlarbind.notlariGoruntule.setOnClickListener {
            val intent = Intent(this, KisiselNotlarListe::class.java)
            startActivity(intent)

        }
    }
}