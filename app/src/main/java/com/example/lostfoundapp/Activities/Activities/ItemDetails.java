package com.example.lostfoundapp.Activities.Activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lostfoundapp.R;

public class ItemDetails extends AppCompatActivity {
    SharedPreferences preferences;
    //ImageView imgSat;
    TextView tvitemID;
    TextView tvitemName;
    TextView tvDescription;
    TextView tvStatus;
    TextView tvLocation;



    Item model ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
        setTitle("Details");

        if (getIntent().getExtras()!=null){
            model = (Item) getIntent().getSerializableExtra("data");
        }

        tvitemID =  findViewById(R.id.getItemID);
        //imgSat = findViewById(R.id.imgSat);
        tvitemName.setText(model.getItemName());

        tvDescription = findViewById(R.id.tvDescription);
        tvStatus.setText(model.getStatus());
        //tvLaunchDate.setText(modal.getLaunchDateUnix());

        tvLocation = findViewById(R.id.tvLocation);
    }
}
