package com.example.class_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Activity_bmicheck extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicheck);

        String height = getIntent().getStringExtra("height");
        String weight = getIntent().getStringExtra("weight");


    }
}