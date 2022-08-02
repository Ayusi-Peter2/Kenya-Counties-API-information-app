package com.example.retrofitlibrarydemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitlibrarydemo.R;
import com.example.retrofitlibrarydemo.models.countiesResponse;

import java.util.ArrayList;
import java.util.List;

public class CountiesAdapter extends RecyclerView.Adapter<CountiesAdapter.MyViewHolder> {
    Context context;
    List<countiesResponse> countiesResponses;

    public CountiesAdapter(Context context, List<countiesResponse> countiesResponses) {
        this.context = context;
        this.countiesResponses = countiesResponses;

    }

    @NonNull
    @Override
    public CountiesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.county_view_holder,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountiesAdapter.MyViewHolder holder, int position) {
       // countiesResponses=new ArrayList<>();
        holder.countyName.setText(countiesResponses.get(position).getName());
        holder.countyCode.setText(countiesResponses.get(position).getCode());
        holder.capital.setText(countiesResponses.get(position).getCapital().get(0));
        holder.size.setText(countiesResponses.get(position).getAreaSqKm());
    }

    @Override
    public int getItemCount() {
        return countiesResponses.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView countyName,countyCode,size,capital;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            countyName=itemView.findViewById(R.id.countryName);
            countyCode=itemView.findViewById(R.id.countyCode);
            size=itemView.findViewById(R.id.size);
            capital=itemView.findViewById(R.id.capital);

        }
    }
}
