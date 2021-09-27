package com.example.unit4_codingeval_2.activity.adapter.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.unit4_codingeval_2.R
import com.example.unit4_codingeval_2.model.remote.retrofit.ItemOnClickListener

class PizzaAdapter(val context: Context,val list: MutableList<PizzaModel>,var listener: ItemOnClickListener): RecyclerView.Adapter<PizzaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        return PizzaViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false),listener)
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        holder.setData(list[position])

    }

    override fun getItemCount(): Int {
        return list.size
    }

}