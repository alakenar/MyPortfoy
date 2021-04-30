package com.example.myportfoy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myportfoy.databinding.BaslangicEkraniBinding
import com.example.myportfoy.databinding.ItemKisiselNotBinding

class ListeViewHolder
    (val binding: ItemKisiselNotBinding) : RecyclerView.ViewHolder (binding.root){

    fun bindTo(veriler: Veriler, onClickListener: (Veriler) -> Unit) {



        binding.notBasligi.text= veriler.nbaslik

        binding.root.setOnClickListener {

            onClickListener(veriler)

        }
    }
}