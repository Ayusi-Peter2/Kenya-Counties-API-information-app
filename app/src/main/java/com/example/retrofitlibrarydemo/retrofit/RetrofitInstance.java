package com.example.retrofitlibrarydemo.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit;
    //private static String baseURL="https://counties-kenya.herokuapp.com/api/";

    public static Retrofit getRetrofit()
    {
        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder().baseUrl("https://counties-kenya.herokuapp.com/").addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
