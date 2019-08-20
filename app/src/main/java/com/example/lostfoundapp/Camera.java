package com.example.lostfoundapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.example.lostfoundapp.Activities.Activities.MenuActivity;

public class Camera extends AppCompatActivity {
    public static final int CAMERA_REQUEST= 9999;
    ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        imageview = findViewById(R.id.imageView4);
        imageview.setImageBitmap(MenuActivity.bitmap);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode== CAMERA_REQUEST)
        {
            MenuActivity.bitmap = (Bitmap)data.getExtras().get("data");
            imageview.setImageBitmap(MenuActivity.bitmap);
        }
    }
}