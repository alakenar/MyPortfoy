package com.example.myportfoy.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.databinding.ActivityKisiselNotlarBinding

class KisiselNotlarActivity: AppCompatActivity() {

    private lateinit var knotlarbind: ActivityKisiselNotlarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        knotlarbind = ActivityKisiselNotlarBinding.inflate(layoutInflater)
        setContentView(knotlarbind.root)


        knotlarbind.kisiselNotEkle.setOnClickListener {
            val intent = Intent(this, KisiselNotEkleActivity::class.java)
            startActivity(intent)

        }
        knotlarbind.notlariGoruntule.setOnClickListener {
            val intent = Intent(this, KisiselNotlarListeActivity::class.java)
            startActivity(intent)

        }
    }
}