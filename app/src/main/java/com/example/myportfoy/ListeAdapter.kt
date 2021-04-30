package com.example.myportfoy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myportfoy.databinding.ItemKisiselNotBinding

class ListeAdapter(private val newList: List<Veriler>, val onClickListener:(Veriler)->Unit) : RecyclerView.Adapter<ListeViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListeViewHolder {

       val inflater= LayoutInflater.from(parent.context)
        val binding= ItemKisiselNotBinding.inflate(inflater,parent,false)

        return ListeViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return newList.size

    }

    override fun onBindViewHolder(holder: ListeViewHolder, position: Int) {
        holder.bindTo(newList[position], onClickListener)


    }

}