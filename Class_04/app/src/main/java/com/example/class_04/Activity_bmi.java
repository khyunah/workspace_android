package com.example.class_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Activity_bmi extends AppCompatActivity {

    private EditText heightEt;
    private EditText weightEt;

    private Button okBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        initData();
    }

    private void initData(){
        heightEt = findViewById(R.id.heightEt);
        weightEt = findViewById(R.id.weightEt);
        okBtn = findViewById(R.id.okBtn);
    }

    private void addEventListener(){
        okBtn.setOnClickListener(view -> {
            String height = heightEt.getText().toString();
            String weight = weightEt.getText().toString();

            Intent intent = new Intent(this, Activity_bmicheck.class);
            intent.putExtra("height",height);
            intent.putExtra("weight",weight);
        });
    }
}