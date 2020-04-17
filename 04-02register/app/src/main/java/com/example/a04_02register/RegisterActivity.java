package com.example.a04_02register;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private int i;
    private List i_2;
    private Button hobbyBt, nationBt, enterBt, cancelBt;
    private EditText userIdEt, passwordEt, passwordRepeatEt;
    private RadioGroup sexRg;
    private RadioButton man,woman;
    private CharSequence[] items = new CharSequence[]{"旅游","美食","看电影","运动"};
    private boolean[] checkedItems = {false,true,false,false};
    private boolean[] singleChoise = {true,false,false,false,false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }
    private void initView(){
        hobbyBt = (Button)findViewById(R.id.hobby);
        nationBt = (Button)findViewById(R.id.nation);
        enterBt = (Button)findViewById(R.id.enter);
        cancelBt = (Button)findViewById(R.id.cancel);
        userIdEt = (EditText)findViewById(R.id.userId);
        passwordEt = (EditText)findViewById(R.id.password);
        passwordRepeatEt = (EditText)findViewById((R.id.PassworldRepeat));
        sexRg = (RadioGroup)findViewById(R.id.sex);
        man = (RadioButton)findViewById(R.id.man);
        woman = (RadioButton)findViewById(R.id.woman);
        hobbyBt.setOnClickListener(this);
        nationBt.setOnClickListener((View.OnClickListener) this);
        enterBt.setOnClickListener((View.OnClickListener) this);
        cancelBt.setOnClickListener((View.OnClickListener) this);
    }
    private void check(){
        i = 0;
        if(userIdEt.getText().toString().equals("")){
            userIdEt.setHint("ID不可为空！");
            userIdEt.setHintTextColor(0xFFFF0000);
            i++;
        }
        if(passwordEt.getText().toString().length() < 6 || passwordEt.getText().toString().length() >= 18){
            passwordEt.setHint("请输入6-18位密码！");
            passwordEt.setHintTextColor(0xFFFF0000);
            Toast.makeText(RegisterActivity.this,"请输入6-18位密码！",Toast.LENGTH_LONG).show();
            i++;
        }
        if(!passwordRepeatEt.getText().toString().equals(passwordEt.getText().toString())){
            passwordRepeatEt.setHint("两次密码不相同！");
            passwordRepeatEt.setHintTextColor(0xFFFF0000);
            i++;
        }
        if(hobbyBt.getText().equals("请选择您的爱好！")){
            i++;
        }
        if(nationBt.getText().equals("请选择您的籍贯！")){
            i++;
        }
    }
    private void reset(){
        userIdEt.setText("");
        passwordEt.setText("");
        passwordRepeatEt.setText("");
        sexRg.check(man.getId());
        hobbyBt.setText("请选择您的爱好！");
        nationBt.setText("请选择您的籍贯！");
    }
    private void OutPut(){
        check();
        if (i!=0){
            error();
        }else{
            StringBuffer output = new StringBuffer();
            output.append("注册成功！").append("\n");
            output.append("用户名：").append(userIdEt.getText()).append("\n");
            output.append("密码：").append(passwordEt.getText()).append("\n");
            if(sexRg.getCheckedRadioButtonId()==man.getId()){
                output.append("性别：男").append("\n");
            }else if(sexRg.getCheckedRadioButtonId()==woman.getId()){
                output.append("性别：女").append("\n");
            }
            output.append("爱好：").append(hobbyBt.getText()).append("\n");
            output.append("籍贯：").append(nationBt.getText()).append("\n");
            Toast.makeText(RegisterActivity.this,output.toString(),Toast.LENGTH_LONG).show();
            ArrayList<String> listRegister = new ArrayList<String>();
            listRegister.add("注册成功！");
            listRegister.add("用户名："+userIdEt.getText());
            if(sexRg.getCheckedRadioButtonId()==man.getId()){
                listRegister.add("性别：男");
            }else if(sexRg.getCheckedRadioButtonId()==woman.getId()){
                listRegister.add("性别：女");
            }
            listRegister.add("爱好："+hobbyBt.getText());
            listRegister.add("籍贯："+nationBt.getText());
            Intent intent = new Intent();
            intent.putExtra("data",listRegister);
            setResult(2,intent);
            finish();
        }
    }
    private int num_single(){
        int a = 0;
        while(!singleChoise[a]){
            a++;
        }
        return a;
    }
    int which_a;
    private void error(){
        Toast.makeText(RegisterActivity.this,"请完善您的信息！",Toast.LENGTH_LONG).show();
    }

    public void onClick(View v) {
        if(v==hobbyBt){
            i_2 = new ArrayList();
            AlertDialog dialog;
            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setTitle("请选择您的爱好！")
                    .setIcon(R.mipmap.ic_launcher)
                    .setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            checkedItems[which] = isChecked;
                            i_2.add(which);
                        }
                    })
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            StringBuffer stringBuffer = new StringBuffer();
                            for(int i = 0; i<= checkedItems.length - 1;i++){
                                if(checkedItems[i]){
                                    stringBuffer.append(items[i]).append(" ");
                                }
                            }
                            hobbyBt.setText(stringBuffer.toString());
                            dialog.dismiss();
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(i_2.size()>0){
                                for(int ab=0;ab<i_2.size();ab++) {
                                    int abc = Integer.parseInt(i_2.get(ab).toString());
                                    checkedItems[abc] = !checkedItems[abc];
                                }
                            }
                            dialog.dismiss();
                        }
                    });
            dialog = builder.create();
            dialog.show();
        }
        else if(v==nationBt){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(R.mipmap.ic_launcher)
                    .setTitle("请选择您的籍贯！")
                    .setSingleChoiceItems(new String[]{"中国大陆", "中国香港", "中国澳门", "中国台湾", "其他"},num_single(), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            for(int a = 0;a<singleChoise.length;a++){
                                if(singleChoise[a]){
                                    which_a = a;
                                    singleChoise[a] = false;
                                }
                            }
                            singleChoise[which] = true;
                        }
                    })
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            for(int a = 0;a<singleChoise.length;a++){
                                if(singleChoise[a]){
                                    switch (a){
                                        case 0:
                                            nationBt.setText("中国大陆");
                                            break;
                                        case 1:
                                            nationBt.setText("中国香港");
                                            break;
                                        case 2:
                                            nationBt.setText("中国澳门");
                                            break;
                                        case 3:
                                            nationBt.setText("中国台湾");
                                            break;
                                        default:
                                            nationBt.setText("其他");
                                            break;
                                    }
                                }
                            }
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            for(int a = 0;a<singleChoise.length-1;a++){
                                singleChoise[a]=false;
                            }
                            singleChoise[which_a] = true;
                        }
                    });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        else if(v==enterBt){
            OutPut();
        }
        else if(v==cancelBt){
            reset();
        }
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}