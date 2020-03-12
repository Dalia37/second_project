package com.example.mypurchases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText phone_num ;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phone_num = findViewById(R.id.login_ed_phone);
        login = findViewById(R.id.login_btn_phone);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = phone_num.getText().toString();
                if (value.isEmpty()){
                    Toast.makeText(login.this, getResources().getString(R.string.enter_your_phonr), Toast.LENGTH_SHORT).show();


                }else {
                    Intent intent = new Intent(login.this, login_1.class);
                  intent.putExtra("number",value);
                   startActivity(intent);
                }

            }
        });
    }
}
