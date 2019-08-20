package com.example.lostfoundapp.Activities.Activities;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.example.lostfoundapp.Activities.pojoUsers.Items;
import com.example.lostfoundapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemDetails extends AppCompatActivity {


    @BindView(R.id.imgSat)
    ImageView imgSat;
    @BindView(R.id.timelineCard)
    CardView timelineCard;
    @BindView(R.id.imgItem)
    AppCompatImageView imgItem;
    @BindView(R.id.tvStatus)
    TextView tvStatus;
    @BindView(R.id.tvItemName)
    TextView tvItemName;
   // @BindView(R.id.tvLocation)
    //TextView tvLocation;
    @BindView(R.id.tvContact)
    TextView tvContact;
    @BindView(R.id.tvDescription)
    TextView tvDesc;

    private static final String TAG = "ItemDetails";

    Items items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
        ButterKnife.bind(this);

        if (getIntent().getExtras()!=null){
            items = (Items) getIntent().getSerializableExtra("data");

            tvItemName = findViewById(R.id.tvItemName);
            tvStatus = findViewById(R.id.tvStatus);
            tvDesc = findViewById(R.id.tvDescription);
            tvContact = findViewById(R.id.tvContact);
      //      tvLocation = findViewById(R.id.tvLocation);


            tvItemName.setText(String.valueOf(items.getItemName()));
            tvStatus.setText(String.valueOf(items.getStatus()));
            tvDesc.setText(String.valueOf(items.getDescription()));
            tvContact.setText(String.valueOf(items.getContact()));
        //    tvLocation.setText(String.valueOf(items.getLocation()));


            Glide.with(this).load(items.getItemImage()).into(imgSat);
        }
    }
}
