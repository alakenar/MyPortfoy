package com.example.myportfoy.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.databinding.ActivityNotDetayBinding
import com.example.myportfoy.model.VerilerNot

class NotDetayActivity: AppCompatActivity() {

    private lateinit var ndetaybind: ActivityNotDetayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ndetaybind = ActivityNotDetayBinding.inflate(layoutInflater)
        setContentView(ndetaybind.root)

            val veri = intent.extras?.getParcelable<VerilerNot>("veri")


           ndetaybind.notbasligi.text= veri?.nbaslik.toString()

           ndetaybind.ynot.text= " "+ veri?.ynot.toString()



    }
}