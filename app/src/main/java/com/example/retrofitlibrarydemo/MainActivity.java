package com.example.retrofitlibrarydemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.retrofitlibrarydemo.ApiInterface.ApiCallInterface;
import com.example.retrofitlibrarydemo.adapters.CountiesAdapter;
import com.example.retrofitlibrarydemo.models.ListOfCounties;
import com.example.retrofitlibrarydemo.models.countiesResponse;
import com.example.retrofitlibrarydemo.retrofit.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;
    CountiesAdapter adapter;
    countiesResponse county;
    List <countiesResponse> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Error", "error");
        recyclerView = findViewById(R.id.recyclerView);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("fetching county information");
        list =new ArrayList<>();

        recyclerView.setHasFixedSize(true);
       // recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapter = new CountiesAdapter(MainActivity.this, list);
        recyclerView.setAdapter(adapter);
        getInformation();

    }

    public void getInformation() {
        progressDialog.show();
        ApiCallInterface apiCallInterface = RetrofitInstance.getRetrofit().create(ApiCallInterface.class);
        Call<List<countiesResponse>> call = apiCallInterface.getCounties();

        call.enqueue(new Callback<List<countiesResponse>>() {

            @Override
            public void onResponse(Call<List<countiesResponse>> call, Response<List<countiesResponse>> response) {
                progressDialog.dismiss();

                list.addAll(response.body());
                adapter.notifyDataSetChanged();
               // String name,code,size,capital;
              //  Toast.makeText(MainActivity.this, "Success "+list.get(3).getCapital().get(0), Toast.LENGTH_SHORT).show();
               //try{
              //  Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
               // list=response.body();
/*
                for(countiesResponse r:response.body())
                {
                    name=r.getName();
                    code=r.getCode();
                    size=r.getAreaSqKm();

                    county=new countiesResponse(name,code,size,r.getCapital().get(0));
                    list.add(county);
                   // adapter.notifyDataSetChanged();
                }
                */
                //Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
               // Toast.makeText(MainActivity.this, "Successfully retrieved " + countiesList.getCountiesResponseList().add(), Toast.LENGTH_SHORT).show();
           // }
              //  catch (Exception e)
              //  {
               //     Toast.makeText(MainActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
               // }
            }

            @Override
            public void onFailure(Call<List<countiesResponse>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Failed "+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }

        });
    }
}