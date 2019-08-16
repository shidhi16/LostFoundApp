package com.example.lostfoundapp.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.CursorAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lostfoundapp.Activities.sqLiteData.DatabaseHelper;
import com.example.lostfoundapp.R;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    Button btnAdd,btnShow;
    EditText txtName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = (EditText) findViewById(R.id.txt_name);
        btnAdd = (Button) findViewById(R.id.btn_Add);
        btnShow = (Button) findViewById(R.id.btn_Show);
        myDB = new DatabaseHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = txtName.getText().toString();
                if(txtName.length()!= 0){
                    AddData(newEntry);
                    txtName.setText("");
                }else{
                    Toast.makeText(MainActivity.this, "You must put something in the text field!", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewListContents.class);
                startActivity(intent);
            }
        });


    }

    public void AddData(String newEntry) {

        boolean insertData = myDB.addData(newEntry);

        if(insertData==true){
            Toast.makeText(this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
        }
    }
}
