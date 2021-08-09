package com.example.firstapp;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ResponseModel> {
    @NonNull
    @Override
    public ResponseModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull  ResponseModel holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
