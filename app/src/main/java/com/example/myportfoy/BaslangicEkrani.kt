package com.example.myportfoy

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.databinding.BaslangicEkraniBinding

class BaslangicEkrani: AppCompatActivity () {

    private lateinit var bekranibind: BaslangicEkraniBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bekranibind= BaslangicEkraniBinding.inflate(layoutInflater)
        setContentView(bekranibind.root)


        val background = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(2000)
                    val intent = Intent(this@BaslangicEkrani, MainActivity::class.java)
                    startActivity(intent)
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}