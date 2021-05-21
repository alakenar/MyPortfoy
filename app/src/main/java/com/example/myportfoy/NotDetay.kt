package com.example.myportfoy

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.databinding.NotDetayBinding

class NotDetay: AppCompatActivity() {

    private lateinit var ndetaybind: NotDetayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ndetaybind = NotDetayBinding.inflate(layoutInflater)
        setContentView(ndetaybind.root)

            val veri = intent.extras?.getParcelable<VerilerNot>("veri")


           ndetaybind.notbasligi.text= veri?.nbaslik.toString()

           ndetaybind.ynot.text= veri?.ynot.toString()



    }
}