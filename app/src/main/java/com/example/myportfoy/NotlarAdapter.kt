package com.example.myportfoy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myportfoy.databinding.ItemKisiselNotBinding

class NotlarAdapter(private val newList: List<VerilerNot>, val onClickListener:(VerilerNot)->Unit) : RecyclerView.Adapter<NotlarViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotlarViewHolder {

       val inflater= LayoutInflater.from(parent.context)
        val binding= ItemKisiselNotBinding.inflate(inflater,parent,false)

        return NotlarViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return newList.size

    }

    override fun onBindViewHolder(holder: NotlarViewHolder, position: Int) {
        holder.bindTo(newList[position], onClickListener)


    }

}