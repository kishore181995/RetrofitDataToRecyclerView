package com.example.myapplication.models;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import java.util.List;

public class SlabsAdapter extends RecyclerView.Adapter<SlabsAdapter.MyViewHOlder>
{
    List<Slab> exampleSlabsList;
    Context mContext;

    public SlabsAdapter(List<Slab> mainExmapleList, Context mainActivity) {
        this.exampleSlabsList = mainExmapleList;
        this.mContext = mainActivity;
    }


    @NonNull
    @Override
    public MyViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_slabs, parent, false);
        return new MyViewHOlder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHOlder holder, int position)
    {
        holder.slabminmax.setText(Math.round(exampleSlabsList.get(position).getMin())+" & "+Math.round(exampleSlabsList.get(position).getMax()));
        holder.wagerpercentage.setText(Math.round(exampleSlabsList.get(position).getWageredPercent())+"% (Max. \u20B9"+Math.round(exampleSlabsList.get(position).getWageredMax())+")");
        holder.bonus.setText(Math.round(exampleSlabsList.get(position).getOtcPercent())+"% (Max. \u20B9"+Math.round(exampleSlabsList.get(position).getOtcMax())+")");

    }

    @Override
    public int getItemCount() {
        return exampleSlabsList.size();
    }

    public class MyViewHOlder extends RecyclerView.ViewHolder {
        AppCompatTextView slabminmax,wagerpercentage,bonus;
        public MyViewHOlder(@NonNull View itemView) {
            super(itemView);
            slabminmax = itemView.findViewById(R.id.salbminmaxTv);
            wagerpercentage = itemView.findViewById(R.id.slabwaggpercentTv);
            bonus = itemView.findViewById(R.id.salbwagBonusTv);
        }
    }
}
