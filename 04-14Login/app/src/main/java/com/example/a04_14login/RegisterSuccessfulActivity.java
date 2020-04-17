package com.example.a04_14login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class RegisterSuccessfulActivity extends AppCompatActivity implements View.OnClickListener {

    TextView topicSuccessfulTV,userIdSuccessfulTV,sexSuccessfulTV,hobbySuccessfulTV,nationSuccessfulTV;
    Button ReturnBackBT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_successful);
        init();
    }

    private void init() {
        topicSuccessfulTV = (TextView) findViewById(R.id.topicSuccessful);
        userIdSuccessfulTV = (TextView) findViewById(R.id.userIdSuccessful);
        sexSuccessfulTV = (TextView) findViewById(R.id.sexSuccessful);
        hobbySuccessfulTV = (TextView) findViewById(R.id.hobbySuccessful);
        nationSuccessfulTV = (TextView) findViewById(R.id.nationSuccessful);
        ReturnBackBT = (Button)findViewById(R.id.ReturnLogin);
        show();
        ReturnBackBT.setOnClickListener(this);
    }
    private void show(){
        Intent intent = getIntent();
        ArrayList<String> RegisterList = intent.getStringArrayListExtra("RegisterData");
        topicSuccessfulTV.setText(RegisterList.get(0));
        userIdSuccessfulTV.setText(RegisterList.get(1));
        sexSuccessfulTV.setText(RegisterList.get(2));
        hobbySuccessfulTV.setText(RegisterList.get(3));
        nationSuccessfulTV.setText(RegisterList.get(4));
    }

    @Override
    public void onClick(View v) {
        Intent intentLogin = new Intent();
        intentLogin.setClass(RegisterSuccessfulActivity.this,ActivityLogin.class);
        startActivity(intentLogin);
    }
}
