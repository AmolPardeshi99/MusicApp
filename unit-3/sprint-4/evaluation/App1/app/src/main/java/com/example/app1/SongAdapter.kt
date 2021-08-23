package com.example.app1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SongAdapter(private val resultList: List<Result>, var itemListener: ItemListener) : RecyclerView.Adapter<SongViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val model = resultList[position]
        holder.setData(model)
        holder.itemView.setOnClickListener {
            var bundle = Bundle()
            bundle.run {
                putString("imageurl",model.artworkUrl100)
                putString("trackname",model.trackName)
                putString("artistname",model.artistName)
                putString("collectionname",model.collectionName)
                itemListener.onitemClicked(bundle)
            }
        }
    }

    override fun getItemCount(): Int {
        return resultList.size;
    }
}