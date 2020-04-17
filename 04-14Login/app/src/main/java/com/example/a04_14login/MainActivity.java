package com.example.a04_14login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button registerNewUser = findViewById(R.id.registerNew);
        Button LoginNextBT = findViewById(R.id.LoginNext);
        registerNewUser.setOnClickListener(this);
        LoginNextBT.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.registerNew:
                intent.setClass(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.LoginNext:
                intent.setClass(MainActivity.this,ActivityLogin.class);
                startActivity(intent);
                break;
        }
    }
}
