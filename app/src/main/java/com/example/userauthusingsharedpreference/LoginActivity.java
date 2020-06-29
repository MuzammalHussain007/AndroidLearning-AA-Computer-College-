package com.example.userauthusingsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    private static final String EMAIL_KEY = "MyEmail";
    private EditText mEmail,mPassword;
    private Button mLogin;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private static final String FILE_NAME="Myfile";
    private static String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        connectJavaAndXML();


        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserinfor();
              startActivity(new Intent(LoginActivity.this,MainActivity.class));

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences=getSharedPreferences(FILE_NAME,MODE_PRIVATE);
          String e=sharedPreferences.getString(EMAIL_KEY,"123");
          if (e!="123")
          {
              startActivity(new Intent(LoginActivity.this,MainActivity.class));
          }
    }

    private void getUserinfor() {
         email=mEmail.getText().toString();
         SharedPreferences sharedPreferences=getSharedPreferences(FILE_NAME,MODE_PRIVATE);
         SharedPreferences.Editor editor=sharedPreferences.edit();
         editor.putString(EMAIL_KEY,email).commit();
    }


    private void connectJavaAndXML() {
        mEmail=(EditText) findViewById(R.id.username);
        mPassword=(EditText) findViewById(R.id.password);
        mLogin=(Button) findViewById(R.id.login);
    }
}