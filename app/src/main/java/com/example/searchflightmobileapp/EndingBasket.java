package com.example.searchflightmobileapp;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class EndingBasket extends AppCompatActivity {

    Button btn_AdminMode, btn_MainPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending_basket);

        btn_MainPage = findViewById(R.id.btn_MainPage);
        btn_AdminMode = findViewById(R.id.btn_AdminMode);

        btn_MainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EndingBasket.this, MainActivity.class);
                startActivity(i);
            }
        });


        btn_AdminMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent i = new Intent(EndingBasket.this, AdminMode.class);
               // startActivity(i);
            }
        });
    }
}