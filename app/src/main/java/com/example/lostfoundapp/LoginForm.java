package com.example.lostfoundapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class LoginForm extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtPassword;
    private Switch swRM;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        initView();

        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                login();
            }
        });
    }

    private void initView()
    {
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
    }

    private void login()
    {
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();

        if (email.isEmpty() || email.trim().length() == 0)
        {
            edtEmail.setError("Enter Email ID");
            return;
        }

        if(email.equals("admin@gmail.com") && password.equals("admin"))
        {
            Intent mIntent = new Intent(LoginForm.this, HomeActivity.class);
            mIntent.putExtra("name", "Shivani Dhiman");
            mIntent.putExtra("id", 100);

            startActivity(mIntent);
            finish();
        }

       // Toast.makeText(getApplicationContext(),userName + " : " +  password,Toast.LENGTH_SHORT).show();

    }
}


