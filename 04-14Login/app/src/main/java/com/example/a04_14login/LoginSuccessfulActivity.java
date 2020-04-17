package com.example.a04_14login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoginSuccessfulActivity extends AppCompatActivity {
    TextView LoginSuccessfulTV ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_successful);
        LoginSuccessfulTV = findViewById(R.id.LoginSuccessful);
        Intent intent = getIntent();
        LoginSuccessfulTV.setText(intent.getStringExtra("LoginSuccessful")+"欢迎您！");
    }
}
