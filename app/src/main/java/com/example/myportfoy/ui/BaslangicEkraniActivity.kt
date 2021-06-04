package com.example.myportfoy.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.databinding.ActivityBaslangicEkraniBinding

class BaslangicEkraniActivity: AppCompatActivity () {

    private lateinit var bekranibind: ActivityBaslangicEkraniBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bekranibind= ActivityBaslangicEkraniBinding.inflate(layoutInflater)
        setContentView(bekranibind.root)


        val background = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(2000)
                    val intent = Intent(this@BaslangicEkraniActivity, MainActivity::class.java)
                    startActivity(intent)
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}