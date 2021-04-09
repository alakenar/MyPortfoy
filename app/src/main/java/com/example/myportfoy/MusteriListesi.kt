package com.example.myportfoy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.databinding.ActivityHomepageBinding
import com.example.myportfoy.databinding.ActivityMusteriListesiBinding

class MusteriListesi: AppCompatActivity() {

    private lateinit var mlistesibind: ActivityMusteriListesiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mlistesibind = ActivityMusteriListesiBinding.inflate(layoutInflater)
        setContentView(mlistesibind.root)
    }
}