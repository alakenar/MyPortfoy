package com.example.myportfoy.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.myportfoy.databinding.ItemKisiselNotBinding
import com.example.myportfoy.model.VerilerNot

class NotlarViewHolder
    (val binding: ItemKisiselNotBinding) : RecyclerView.ViewHolder (binding.root){

    fun bindTo(verilerNot: VerilerNot, onClickListener: (VerilerNot) -> Unit) {


        binding.notBasligi.text= verilerNot.nbaslik

        binding.root.setOnClickListener {

            onClickListener(verilerNot)

        }
    }
}