package com.example.myportfoy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.databinding.ActivityKisiselNotlarBinding

class KisiselNotlar : AppCompatActivity(){

    private lateinit var knotlarbind: ActivityKisiselNotlarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        knotlarbind= ActivityKisiselNotlarBinding.inflate(layoutInflater)
        setContentView(knotlarbind.root)
    }

}