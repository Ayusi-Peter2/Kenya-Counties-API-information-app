package com.example.retrofitlibrarydemo.ApiInterface;

import com.example.retrofitlibrarydemo.models.ListOfCounties;
import com.example.retrofitlibrarydemo.models.countiesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCallInterface {
  @GET("api/v1")
    Call<List<countiesResponse>> getCounties();
}