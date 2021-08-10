package com.example.firstapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<itemViewHolder> {

    private FragmentListner fragmentListner;
    private List<ResponseModel> itemList;

    public ItemAdapter(FragmentListner fragmentListner, List<ResponseModel> itemList) {
        this.fragmentListner = fragmentListner;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new itemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemViewHolder holder, int position) {
        ResponseModel responseModel = itemList.get(position);
        holder.setData(responseModel);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = responseModel.getTitle();
                String subTitle= responseModel.getSubTitle();
                String Imageurl = responseModel.getImage();
                Bundle bundle = new Bundle();
                bundle.putString("title",title);
                bundle.putString("subtitle",subTitle);
                bundle.putString("Imageurl",Imageurl);
                fragmentListner.onItemClicked(bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
