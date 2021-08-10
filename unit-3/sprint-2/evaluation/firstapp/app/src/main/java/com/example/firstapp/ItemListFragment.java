package com.example.firstapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemListFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<ResponseModel> responseModelList = new ArrayList<>();
    private ItemAdapter itemAdapter;
    private Context context ;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        callAPI();
    }

    private void callAPI() {
        APIService apiService = Network.getInstance().create(APIService.class);
        Call<List<ResponseModel>> call = apiService.getData();
        call.enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                if (response.code() == HttpURLConnection.HTTP_OK ){
                    responseModelList = response.body();
                    setRecyclerView();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {
                Toast.makeText(getContext(),"Loading Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recyclerview);
    }


    private void setRecyclerView(){
        itemAdapter = new ItemAdapter((FragmentListner) context,responseModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }


}