package com.example.mypurchases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class login_1 extends AppCompatActivity {
    TextView num , edit ;
    Button commit ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_1);
        num = findViewById(R.id.login1_tv_phone);
        edit = findViewById(R.id.login1_tv_edit);
        commit = findViewById(R.id.login1_btn_commit);
        String phone_num =  getIntent().getStringExtra("number");
        num.setText(phone_num);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_1.this , login.class);
                startActivity(intent);
            }
        });
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_1.this , type.class);
                startActivity(intent);
            }
        });


    }
}
