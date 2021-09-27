package com.example.unit4_codingeval_2.activity.adapter.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.unit4_codingeval_2.model.remote.retrofit.ItemOnClickListener
import kotlinx.android.synthetic.main.item_layout.view.*

class PizzaViewHolder(itemView:View, var listener: ItemOnClickListener):RecyclerView.ViewHolder(itemView) {

    fun setData(pizza: PizzaModel){
       itemView.apply {
           tvDesc.text = pizza.desc
           tvPrise.text = pizza.prize.toString()
           tvTitle.text = pizza.name


           btnAddToCart.setOnClickListener{
               listener.onItemClicked(pizza)
           }
       }
    }



}