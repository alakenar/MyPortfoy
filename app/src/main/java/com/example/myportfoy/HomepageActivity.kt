package com.example.myportfoy

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
    }



}