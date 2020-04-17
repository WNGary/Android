package com.example.a04_14login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity implements View.OnClickListener {

    EditText userIdInputET,passwordInputET;
    Button LoginBT,cancelLoginBT;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        userIdInputET = findViewById(R.id.userIdInput);
        passwordInputET = findViewById(R.id.passwordInput);
        LoginBT = findViewById(R.id.Login);
        cancelLoginBT = findViewById(R.id.cancelLogin);
        sp = getSharedPreferences("userInfo",MODE_PRIVATE);
        LoginBT.setOnClickListener(this);
        cancelLoginBT.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Login:
                String userId = sp.getString(userIdInputET.getText().toString(),"");
                String userPassword = sp.getString(userIdInputET.getText().toString()+"password","");
                if(userId != null){
                    if (userPassword.equals(passwordInputET.getText().toString())){
                        Toast.makeText(ActivityLogin.this,"登录成功",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent();
                        intent.setClass(ActivityLogin.this,LoginSuccessfulActivity.class);
                        intent.putExtra("LoginSuccessful",userId);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(ActivityLogin.this,"用户名或者密码错误,请重新输入！",Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(ActivityLogin.this,"用户名或者密码错误,请重新输入！",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.cancelLogin:
                userIdInputET.setText("");
                passwordInputET.setText("");
                break;
        }
    }
}
