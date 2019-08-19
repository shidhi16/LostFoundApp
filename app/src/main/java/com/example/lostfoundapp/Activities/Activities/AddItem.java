package com.example.lostfoundapp.Activities.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;

import com.example.lostfoundapp.Activities.pojoUsers.CitiesPojo;
import com.example.lostfoundapp.Activities.pojoUsers.Items;
import com.example.lostfoundapp.LostFoundSingleton;
import com.example.lostfoundapp.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddItem extends AppCompatActivity {

    ArrayList<CitiesPojo> citiesPojoArrayList = new ArrayList<>();

    String strCities;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imgItem)
    ImageView imgItem;
    @BindView(R.id.etItemName)
    EditText etItemName;
    @BindView(R.id.statusSpinner)
    Spinner statusSpinner;
    @BindView(R.id.etDesc)
    AppCompatEditText etDesc;
    @BindView(R.id.etContact)
    AppCompatEditText etContact;
    @BindView(R.id.etAddress)
    AppCompatEditText etAddress;
    @BindView(R.id.etCities)
    AutoCompleteTextView etCities;
    @BindView(R.id.btnPost)
    Button btnPost;

    String strImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.additem_activity);
        ButterKnife.bind(this);

        try {
            strCities = readCities();
            JSONArray citiesArray = new JSONArray(strCities);
            for (int i = 0; i < citiesArray.length(); i++) {
                JSONObject citiesObject  = citiesArray.getJSONObject(i);

                CitiesPojo citiesPojo = new CitiesPojo();
                citiesPojo.setCities(citiesObject.getString("city"));
                citiesPojo.setStates(citiesObject.getString("admin"));
                citiesPojoArrayList.add(citiesPojo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String readCities() throws IOException {
        BufferedReader reader = null;
        reader = new BufferedReader(new InputStreamReader(getAssets().open("canada"), StandardCharsets.UTF_8));

        String content = "";
        String line;
        while ((line = reader.readLine()) != null) {
            content = content + line;

        }

        return content;
    }

    @OnClick({R.id.imgItem, R.id.btnPost})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgItem:
                break;
            case R.id.btnPost:
                if (valid()){

                    Items items = new Items();
                    items.setItemName(etItemName.getText().toString());
                    items.setDescription(etDesc.getText().toString());
                    items.setContact(etContact.getText().toString());
                    items.setAddress(etCities.getText().toString());
                    items.setCity(etCities.getText().toString());
                    LostFoundSingleton.getInstance().addItem(items);
                    finish();
                }else {

                }
                break;
        }
    }

    private boolean valid() {
       /* if (strImage==null || strImage.isEmpty()){
            return false;
        }else */if (etItemName.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please Enter Itemname",Toast.LENGTH_SHORT).show();
            return false;
        }else if (Objects.requireNonNull(etDesc.getText()).toString().equalsIgnoreCase(""))
        {
            Toast.makeText(this,"Please Enter Description",Toast.LENGTH_SHORT).show();
            return false;
        }else if (Objects.requireNonNull(etContact.getText()).toString().equalsIgnoreCase(""))
        {
            Toast.makeText(this,"Please Enter Contact",Toast.LENGTH_SHORT).show();
            return false;
        }else if (Objects.requireNonNull(etAddress.getText()).toString().equalsIgnoreCase(""))
        {
            Toast.makeText(this,"Please Enter Address",Toast.LENGTH_SHORT).show();
            return false;
        }else if (etCities.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please Enter Citie",Toast.LENGTH_SHORT).show();
                        return false;
        }else
        return true;
    }


}
