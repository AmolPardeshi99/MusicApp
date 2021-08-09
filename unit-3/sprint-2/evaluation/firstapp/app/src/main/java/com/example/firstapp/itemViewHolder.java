package com.example.firstapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class itemViewHolder extends RecyclerView.ViewHolder {
    private ImageView mIvitemImage;
    private TextView mTvitemTitle, mTvitemSUbTitle;

    public itemViewHolder(@NonNull View itemView) {
        super(itemView);
        mTvitemSUbTitle = itemView.findViewById(R.id.tvitemTitle);
        mTvitemTitle = itemView.findViewById(R.id.tvitemSubTitle);
        mIvitemImage = itemView.findViewById(R.id.iv_itemImage);
    }

    public void setData(ResponseModel responseModel){
        Glide.with(mIvitemImage).load(responseModel.getImage()).into(mIvitemImage);
        mTvitemTitle.setText(responseModel.getSubTitle());
        mTvitemSUbTitle.setText(responseModel.getTitle());
    }

}
