package com.example.lostfoundapp.Activities.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lostfoundapp.Activities.pojoUsers.Users;
import com.example.lostfoundapp.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    BrandsAdapter firstAdapter;
    Context context;


    String strItems;
    ArrayList<Item> itemsArrayList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context = HomeActivity.this;
        recyclerView = findViewById(R.id.recyclerView);
        firstAdapter = new BrandsAdapter(context, itemsArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(firstAdapter);

        try {
            strItems = readItems("itemslist");
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        setArrayListOfItems();
    }

    
    private void setArrayListOfItems() {

        try {
            JSONArray itemsArrayList = new JSONArray(strItems);
            for (int i = 0; i < itemsArrayList.length(); i++) {
                Item item = new Item();
                JSONObject itemObject = itemsArrayList.getJSONObject(i);


                item.setItemID(itemObject.getInt("item_id"));
                item.setItemName(itemObject.getString("item_name"));
                item.setDescription(itemObject.getString("description"));
                item.setStatus(itemObject.getString("status"));
                item.setLocation(itemObject.getString("location"));
                item.setContact(itemObject.getString("contact"));

                firstAdapter.notifyDataSetChanged();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public  abstract class BrandsAdapter extends RecyclerView.Adapter<BrandsAdapter.Holder> {

        private ArrayList<Item> itemsArrayList;
        private Context context;
        private static final String TAG = "BrandsAdapter";


        }

        class Holder extends RecyclerView.ViewHolder {

            final View iView;
            public TextView itemName, itemStatus;
            ImageView img_view;
            CardView cardItem;


            Holder(View itemView) {
                super(itemView);
                iView = itemView;
              //  itemID = itemView.findViewById(R.id.itemID);
                itemName = itemView.findViewById(R.id.itemName);
                cardItem = itemView.findViewById(R.id.cardItem);


            }
        }

        @Override
        public BrandsAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.itemadapter, parent, false);
            return new BrandsAdapter.Holder(view);
        }

        @Override
        public void onBindViewHolder(BrandsAdapter.Holder holder, final int position) {
//            int status = dataList.get(position).getStatus();
//            if (status == 1) {
            final Item item = itemsArrayList.get(position);
//            holder.itemStatus.setText(item.getItemStatus());
            holder.itemName.setText(item.getItemName());



            holder.cardItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,ItemDetails.class);
                    intent.putExtra("data",item);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return itemsArrayList.size();
        }
    }
}