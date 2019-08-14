package com.example.lostfoundapp.Activities.Activities;

import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lostfoundapp.R;

import java.util.ArrayList;
import java.util.List;

public class AddItem extends AppCompatActivity {

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




}
