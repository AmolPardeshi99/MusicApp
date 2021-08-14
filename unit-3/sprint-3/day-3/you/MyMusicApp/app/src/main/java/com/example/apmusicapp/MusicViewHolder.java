package com.example.apmusicapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MusicViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvSongImage;
    private TextView mTvSongName;
    private CardView mSongCard;
    private OnSongClicked onSongClicked;

    public MusicViewHolder(@NonNull View itemView, OnSongClicked onSongClicked) {
        super(itemView);
        this.onSongClicked = onSongClicked;
        initView(itemView);
    }

    private void initView(View itemView) {
        mIvSongImage = itemView.findViewById(R.id.ivMusicImage);
        mTvSongName = itemView.findViewById(R.id.tvMusicName);
        mSongCard = itemView.findViewById(R.id.MusicCard);
    }

    public void setData(MusicModel musicModel) {
        mIvSongImage.setImageResource(musicModel.getImage());
        mTvSongName.setText(musicModel.getSongName());
        mSongCard.setOnClickListener(v -> {
            onSongClicked.onSongClicked(musicModel, getAdapterPosition());
        });
    }
}
