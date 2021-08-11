package com.example.api_calling_using_service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("/posts/{postId}")
    Call<ResponseModel> getPost(@Path("postId") int id);
}
