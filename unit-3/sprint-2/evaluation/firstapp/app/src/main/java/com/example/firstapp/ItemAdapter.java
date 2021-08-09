package com.example.firstapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<itemViewHolder> {

    List<ResponseModel> itemList;

    public ItemAdapter(List<ResponseModel> itemList) {
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
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
