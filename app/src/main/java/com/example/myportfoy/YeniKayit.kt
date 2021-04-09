package com.example.myportfoy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.databinding.ActivityHomepageBinding
import com.example.myportfoy.databinding.ActivityYeniKayitBinding

class YeniKayit: AppCompatActivity() {

    private lateinit var ykayitbind: ActivityYeniKayitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ykayitbind = ActivityYeniKayitBinding.inflate(layoutInflater)
        setContentView(ykayitbind.root)
    }
}