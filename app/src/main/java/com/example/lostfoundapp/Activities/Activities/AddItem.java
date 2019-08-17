package com.example.lostfoundapp.Activities.Activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lostfoundapp.Activities.pojoUsers.Items;
import com.example.lostfoundapp.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AddItem extends AppCompatActivity {

    ArrayList<itemsList>  mItemsList;

    public AddItem(ImageView aItemImg, Spinner statusSpinner, TextView aItemName, DatePicker aDate, TextView aDescription, TextView aLocation, TextView aContact, Spinner statusSpinner1, List<String> varSpinnerData, float varScaleX, float varScaleY) {
        this.aItemImg = aItemImg;
        this.statusSpinner = statusSpinner;
        this.aItemName = aItemName;
        this.aDate = aDate;
        this.aDescription = aDescription;
        this.aLocation = aLocation;
        this.aContact = aContact;
        this.statusSpinner = statusSpinner1;
    }

    ImageView aItemImg;
    Spinner statusSpinner;
    TextView aItemName;
    DatePicker aDate;
    TextView aDescription;
    TextView aLocation;
    TextView aContact;
    Button btnPost;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.additem_activity);

        mItemsList = new ArrayList<>();

        Button buttonPost = findViewById(R.id.btnPost);
        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preference", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(mItemsList);
        editor.putString("item add task", json);
        editor.apply();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preference", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("item add task", null);
        Type type = new TypeToken<ArrayList<>>() {}.getType();
        mItemsList = gson.fromJson(json, type);

    }
}
