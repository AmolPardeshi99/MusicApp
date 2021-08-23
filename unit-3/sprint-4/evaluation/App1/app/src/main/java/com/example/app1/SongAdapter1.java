package com.example.app1;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SongAdapter1  extends RecyclerView.Adapter<SongViewHolder> {

    private List<Result> resultList;

    public SongAdapter1(List<Result> resultList) {
        this.resultList = resultList;
    }

    @NonNull
    @NotNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SongViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
