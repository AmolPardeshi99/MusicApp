package com.example.kotlinandroid

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class PostViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(responseDTO: ResponseDTO) {
        // settext here
        // scoping function   left,run, also, apply
        itemView.apply {
            tvName.text = responseDTO.name
            tvBody.text = responseDTO.body
            tvEmail.text = responseDTO.email
        }
    }
}