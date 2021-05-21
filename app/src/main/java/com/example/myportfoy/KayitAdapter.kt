package com.example.myportfoy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myportfoy.databinding.ItemYeniKayitBinding

class KayitAdapter (private val newList: List<VerilerKayit>, val onClickListener:(VerilerKayit)->Unit) : RecyclerView.Adapter<KayitViewHolder>()  {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KayitViewHolder {

            val inflater= LayoutInflater.from(parent.context)
            val binding= ItemYeniKayitBinding.inflate(inflater,parent,false)

            return KayitViewHolder(binding)

        }

        override fun getItemCount(): Int {
            return newList.size

        }

        override fun onBindViewHolder(holder: KayitViewHolder, position: Int) {
            holder.bindTo(newList[position], onClickListener)


        }

    }
