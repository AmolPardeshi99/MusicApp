package com.example.firstapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ItemDetailsFragment extends Fragment {
    private TextView mTvTitle, mTvSubTitle,mTvDummyText;
    private ImageView mIvImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        if (getArguments()!= null){
            mTvTitle.setText(getArguments().getString("title"));
            mTvSubTitle.setText(getArguments().getString("subtitle"));
            Glide.with(mIvImage).load(getArguments().getString("Imageurl")).into(mIvImage);
        }
    }

    private void initView(View view) {
        mTvDummyText = view.findViewById(R.id.tvDummyText);
        mTvSubTitle = view.findViewById(R.id.tvSubTitle);
        mTvTitle = view.findViewById(R.id.tvTitle);
        mIvImage = view.findViewById(R.id.Iv_detailImage);

    }
}