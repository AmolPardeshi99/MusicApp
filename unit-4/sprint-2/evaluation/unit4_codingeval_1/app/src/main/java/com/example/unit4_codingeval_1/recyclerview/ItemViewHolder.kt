package com.example.unit4_codingeval_1.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_search_item.view.*
import kotlinx.android.synthetic.main.item_layout.view.*

class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun setData(dataModel: ModelClass){
        itemView.apply {
            tvShowName.text = dataModel.name
            tvShowPrise.text = dataModel.prise

        }
    }
}