package com.example.app1

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*

class SongViewHolder (private val view : View): RecyclerView.ViewHolder(view) {

    fun setData(result: Result){
        view.apply {
            result.run {
                tvArtistName.text = artistName
                tvCollectionName.text = collectionName
                tvTrackName.text = trackName
                Glide.with(ivPreviewImage).load(artworkUrl100).into(ivPreviewImage)
            }
        }
    }
}