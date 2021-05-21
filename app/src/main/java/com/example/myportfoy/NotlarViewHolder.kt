package com.example.myportfoy

import androidx.recyclerview.widget.RecyclerView
import com.example.myportfoy.databinding.ItemKisiselNotBinding

class NotlarViewHolder
    (val binding: ItemKisiselNotBinding) : RecyclerView.ViewHolder (binding.root){

    fun bindTo(verilerNot: VerilerNot, onClickListener: (VerilerNot) -> Unit) {


        binding.notBasligi.text= verilerNot.nbaslik

        binding.root.setOnClickListener {

            onClickListener(verilerNot)

        }
    }
}