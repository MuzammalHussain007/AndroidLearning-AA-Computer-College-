package com.example.userauthusingsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private static final String FILE_NAME="Myfile";
    private static final String EMAIL_KEY = "MyEmail";
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView= findViewById(R.id.text);
        logout= findViewById(R.id.button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences(FILE_NAME,MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.remove(EMAIL_KEY).commit();
                Toast.makeText(getApplicationContext(),"Value Remove from file",Toast.LENGTH_SHORT).show();

                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });
        String email;

       // Toast.makeText(getApplicationContext(),"Email is :"+email,Toast.LENGTH_LONG).show();
    }


}