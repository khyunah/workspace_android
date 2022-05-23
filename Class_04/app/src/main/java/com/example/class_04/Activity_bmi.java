package com.example.class_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Activity_bmi extends AppCompatActivity {

    // 사용자에게 입력 받을 수 있는 Text : EditText
    private EditText heightEt;
    private EditText weightEt;
    private Button okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        initData();
        addEventListener();
    }

    private void initData(){
        heightEt = findViewById(R.id.heightEt);
        weightEt = findViewById(R.id.weightEt);
        okBtn = findViewById(R.id.okBtn);
    }

    private void addEventListener(){
        okBtn.setOnClickListener(view -> {

            // 사용자가 입력한 값을 들고와서 int 로 파싱
            int height = Integer.parseInt(heightEt.getText().toString());
            int weight = Integer.parseInt(weightEt.getText().toString());

            // 화면 전환객체 만들기
            Intent intent = new Intent(this, Activity_bmicheck.class);

            // 데이터 전달
            intent.putExtra("height",height);
            intent.putExtra("weight",weight);

            // 화면 전환 시작 
            startActivity(intent);
        });
    }
}