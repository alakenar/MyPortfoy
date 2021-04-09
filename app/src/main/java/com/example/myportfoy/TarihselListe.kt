package com.example.myportfoy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.databinding.ActivityHomepageBinding
import com.example.myportfoy.databinding.ActivityTarihselListeBinding

class TarihselListe: AppCompatActivity() {

    private lateinit var tlistebind: ActivityTarihselListeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tlistebind = ActivityTarihselListeBinding.inflate(layoutInflater)
        setContentView(tlistebind.root)
    }
}