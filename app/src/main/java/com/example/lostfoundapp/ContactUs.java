package com.example.lostfoundapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ContactUs extends AppCompatActivity{

TextView txt_PhoneNumber;
        Button buttoncall;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);


        buttoncall = (Button)findViewById(R.id.buttoncall);
        txt_PhoneNumber = findViewById(R.id.txt);

        buttoncall.setOnClickListener(new View.OnClickListener() {
private void requestOnPermisson() {
        ActivityCompat.requestPermissions(PhoneCall.this, new String[]{Manifest.permission.CALL_PHONE}, 1);


        }

@Override
public void onClick(View view) {
        Intent intentCall = new Intent(Intent.ACTION_CALL);
        String number = txt_PhoneNumber.getText().toString();

        if (number.trim().isEmpty()) {
        Toast.makeText(PhoneCall.this, "phone call invalid", Toast.LENGTH_SHORT
        );
        } else {
        intentCall.setData(Uri.parse("tel:" + number));

        }
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
        Toast.makeText(PhoneCall.this, "please grant permission", Toast.LENGTH_SHORT);
        requestOnPermisson();
        } else {
        startActivity(intentCall);
        }
        }
        });




        }
        }
