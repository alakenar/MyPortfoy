package com.example.myportfoy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.databinding.HomepageBinding

class HomepageActivity : AppCompatActivity() {

    private lateinit var hpagebind: HomepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hpagebind = HomepageBinding.inflate(layoutInflater)
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
            val intent = Intent(this, KisiselNotlar ::class.java)
            startActivity(intent)

        }

    }
}