package com.example.myportfoy.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.databinding.ActivityHomepageBinding

class HomepageActivity : AppCompatActivity() {

    private lateinit var hpagebind: ActivityHomepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hpagebind = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(hpagebind.root)


        hpagebind.yenikayitButton.setOnClickListener {
            val intent = Intent(this, YeniKayitActivity::class.java)
            startActivity(intent)

        }

        hpagebind.tlisteButton.setOnClickListener {
            val intent = Intent(this, TarihselListeActivity::class.java)
            startActivity(intent)

        }
        hpagebind.mlisetesiButton.setOnClickListener {
            val intent = Intent(this, MusteriListesiActivity::class.java)
            startActivity(intent)

        }
        hpagebind.knotlarButton.setOnClickListener {
            val intent = Intent(this, KisiselNotlarActivity ::class.java)
            startActivity(intent)

        }

    }
}