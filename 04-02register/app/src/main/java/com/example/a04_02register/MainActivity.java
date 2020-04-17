package com.example.a04_02register;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView topicTV ;
    TextView userIdTV;
    TextView sexTV ;
    TextView hobbyTV;
    TextView nationTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topicTV = findViewById(R.id.topic);
        userIdTV = findViewById(R.id.userIdMain);
        sexTV = findViewById(R.id.sexMain);
        hobbyTV = findViewById(R.id.hobbyMain);
        nationTV = findViewById(R.id.nationMain);
        findViewById(R.id.enterMain).setOnClickListener(this);
        findViewById(R.id.cancelMain).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.enterMain:
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivityForResult(intent,1);
                break;
            case R.id.cancelMain:
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == 2){
            List dataRequest = data.getStringArrayListExtra("data");
            topicTV.setText(dataRequest.get(0).toString());
            userIdTV.setText(dataRequest.get(1).toString());
            sexTV.setText(dataRequest.get(2).toString());
            hobbyTV.setText(dataRequest.get(3).toString());
            nationTV.setText(dataRequest.get(4).toString());
        }
    }
}
