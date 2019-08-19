package com.example.lostfoundapp.Activities.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lostfoundapp.Activities.Activities.ItemDetails;
import com.example.lostfoundapp.Activities.pojoUsers.Items;
import com.example.lostfoundapp.Activities.pojoUsers.Users;
import com.example.lostfoundapp.R;

import java.util.ArrayList;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.MyViewHolder>  {

    AppCompatActivity context;
    ArrayList<Items> itemsArrayList;
    private static final String TAG = "BrandAdapter";

    public BrandAdapter(AppCompatActivity context, ArrayList<Items> itemsArrayList) {
        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.itemadapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Items items = itemsArrayList.get(position);

        holder.tvItemName.setText(items.getItemName());
        holder.tvStatus.setText(items.getStatus());
        holder.tvDate.setText(String.valueOf(items.getContact()));

        Log.e(TAG, "onBindViewHolder: "+items.getItemImage() );

        Glide.with(context).load(items.getItemImage()).into(holder.imgItem);

        holder.llItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , ItemDetails.class);
                intent.putExtra("data",items);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemsArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayoutCompat llItem;
        ImageView imgItem;
        TextView tvStatus;
        TextView tvItemName;
        TextView tvDate;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            llItem = itemView.findViewById(R.id.llItem);
            imgItem = itemView.findViewById(R.id.imgItem);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            tvItemName = itemView.findViewById(R.id.tvItemName);
            tvDate = itemView.findViewById(R.id.tvDate);

        }
    }
}
