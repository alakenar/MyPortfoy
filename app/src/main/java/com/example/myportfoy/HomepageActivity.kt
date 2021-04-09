package com.example.myportfoy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.databinding.ActivityHomepageBinding
import com.example.myportfoy.databinding.ActivityLoginBinding
import com.example.myportfoy.databinding.ActivityMainBinding

class HomepageActivity : AppCompatActivity(){

    private lateinit var hpagebind: ActivityHomepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hpagebind = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(hpagebind.root)


        hpagebind.yenikayitButton.setOnClickListener {
            val intent = Intent(this, YeniKayit::class.java)
            startActivity(intent)

        }

        hpagebind.tlisteButton.setOnClickListener {
            val intent = Intent(this, TarihselListe::class.java)
            startActivity(intent)

        }
        hpagebind.mlisetesiButton.setOnClickListener {
            val intent = Intent(this, MusteriListesi::class.java)
            startActivity(intent)

        }
        hpagebind.knotlarButton.setOnClickListener {
            val intent = Intent(this, KisiselNotlar::class.java)
            startActivity(intent)

        }

    }
    }