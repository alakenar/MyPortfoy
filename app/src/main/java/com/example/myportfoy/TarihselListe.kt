package com.example.myportfoy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.databinding.TarihselListeBinding

class TarihselListe: AppCompatActivity() {

    private lateinit var tlistebind: TarihselListeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tlistebind = TarihselListeBinding.inflate(layoutInflater)
        setContentView(tlistebind.root)
    }
}