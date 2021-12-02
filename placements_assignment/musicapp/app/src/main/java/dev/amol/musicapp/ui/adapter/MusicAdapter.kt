package dev.amol.musicapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.amol.musicapp.R
import dev.amol.musicapp.databinding.ItemlayoutBinding
import dev.amol.musicapp.model.remote.responsedata.Result
import kotlin.coroutines.coroutineContext

class MusicAdapter(
     val context: Context,
    private val musicList: MutableList<Result>
):RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    class MusicViewHolder(val itemlayoutBinding: ItemlayoutBinding):RecyclerView.ViewHolder(itemlayoutBinding.root){
        fun setData(result: Result){
            itemlayoutBinding.musicData = result

            Glide.with(itemlayoutBinding.ivArtistImg).load(result.artworkUrl100).into(itemlayoutBinding.ivArtistImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        return MusicViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.itemlayout,parent,false))
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val result = musicList[position]
        holder.setData(result)
    }

    override fun getItemCount(): Int {
        return musicList.size
    }
}