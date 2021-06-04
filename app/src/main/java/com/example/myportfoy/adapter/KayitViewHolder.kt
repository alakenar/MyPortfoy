package com.example.myportfoy.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.myportfoy.databinding.ItemYeniKayitBinding
import com.example.myportfoy.model.VerilerKayit

class KayitViewHolder

      (val binding: ItemYeniKayitBinding) : RecyclerView.ViewHolder (binding.root){

    fun bindTo(verilerKayit: VerilerKayit, onClickListener: (VerilerKayit) -> Unit) {

        binding.adSoyad.text= verilerKayit.adsoyad

        binding.root.setOnClickListener {

            onClickListener(verilerKayit)

        }
    }
}