package com.example.lostfoundapp.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.lostfoundapp.Activities.MySharedPref;
import com.example.lostfoundapp.Activities.pojoUsers.Users;
import com.example.lostfoundapp.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.example.lostfoundapp.Activities.Utilities.Validation;

public class LoginForm extends AppCompatActivity {

    AppCompatActivity mActivity = LoginForm.this;
    private static final String TAG = "LoginForm";

    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;
    private Button btnSignup;


    String userFile;

    private ArrayList<com.example.lostfoundapp.Activities.pojoUsers.Users> usersArrayList = new ArrayList<>();

    public LoginForm(Button btnSignup) {
        this.btnSignup = btnSignup;
        Intent myIntent = new Intent(LoginForm.this, SignUpForm.class);
        //myIntent.putExtra("key", value); //Optional parameters
        LoginForm.this.startActivity(myIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_form);
        initView();
        try {
            userFile =  readUsers("users");
        }catch (Exception e){
            e.printStackTrace();
        }
        readFromString();

        for (int i =0 ; i< usersArrayList.size() ; i++){
            Log.e(TAG, "email: "+usersArrayList.get(i).getUserEmail() );
            Log.e(TAG, "password: "+usersArrayList.get(i).getUserPassword() );
            Log.e(TAG, "............................." );
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick: ");
                if (isValid()){
                    if (checkFromList(edtEmail.getText().toString(),
                            edtPassword.getText().toString())) {

                        MySharedPref.writeString(mActivity,MySharedPref.isLogin,"True");
                        MySharedPref.writeString(mActivity,MySharedPref.emailId,edtEmail.getText().toString());
                        startActivity(new Intent(mActivity , MenuActivity.class));
                    }else {
                        Toast.makeText(mActivity,"Wrong Credentials Entered",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void readFromString() {
        try {
            JSONArray userJsonArray = new JSONArray(userFile);
            for (int i =0 ; i<userJsonArray.length() ;i++){
                com.example.lostfoundapp.Activities.pojoUsers.Users users = new Users();
                JSONObject userObject = userJsonArray.getJSONObject(i);
                users.setUserID(userObject.getInt("userID"));
                users.setUserEmail(userObject.getString("userEmail"));
                users.setUserPassword(userObject.getString("userPassword"));
                usersArrayList.add(users);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String readUsers(String fileName) throws IOException
    {
        BufferedReader reader = null;
        reader = new BufferedReader(new InputStreamReader(getAssets().open(fileName), "UTF-8"));

        String content = "";
        String line;
        while ((line = reader.readLine()) != null)
        {
            content = content + line;
        }

        return content;

    }



    private boolean checkFromList(String email, String password) {
        Log.e(TAG, "email: "+email );
        Log.e(TAG, "password: "+password );
        for (int i =0 ; i<usersArrayList.size(); i++) {
            if (usersArrayList.get(i).getUserEmail().equalsIgnoreCase(email)) {
                Log.e(TAG, "email found: " );
                if (usersArrayList.get(i).getUserPassword().equalsIgnoreCase(password)) {
                    Log.e(TAG, "password found: ." );
                    return true;
                }
            }
        }
        return false;
    }


    private void initView() {

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }

    private boolean isValid() {
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();

        if (email.isEmpty() || email.trim().length() == 0) {
            edtEmail.setError("Enter Email ID");
            return false;
        }else if (!Validation.isValidEmail(email)){
            edtEmail.setError("Enter Valid Email ID");
            return false;
        }
        else if (password.isEmpty() || password.trim().length() == 0) {
            edtPassword.setError("Enter Password");
            return false;
        }else if (!Validation.isValidPassword(password)){
            edtPassword.setError("Enter Valid Password");
        }
        return true;

    }

}


