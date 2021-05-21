package com.example.myportfoy

import androidx.recyclerview.widget.RecyclerView
import com.example.myportfoy.databinding.ItemYeniKayitBinding

class KayitViewHolder

      (val binding: ItemYeniKayitBinding) : RecyclerView.ViewHolder (binding.root){

    fun bindTo(verilerKayit: VerilerKayit, onClickListener: (VerilerKayit) -> Unit) {

        binding.adSoyad.text= verilerKayit.adsoyad

        binding.root.setOnClickListener {

            onClickListener(verilerKayit)

        }
    }
}