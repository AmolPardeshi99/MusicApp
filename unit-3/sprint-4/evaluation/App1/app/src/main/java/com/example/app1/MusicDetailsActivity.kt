package com.example.app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_music_details.*
import kotlinx.android.synthetic.main.item_layout.view.*

class MusicDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_details)
        intent?.run {
            tv2ArtistName.text = getStringExtra("artistname")
            tv2CollectionName.text = getStringExtra("collectionname")
            tv2TrackName.text = getStringExtra("trackname")
            Glide.with(iv2SongImage).load(getStringExtra("imageurl")).into(iv2SongImage)

        }
    }









































}