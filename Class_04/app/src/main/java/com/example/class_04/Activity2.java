package com.example.class_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);    // 순서 중요

        // 값을 받는 방법

//      방어적 코드가 필요하다.
//      if (getIntent() != null)
//      int 는 값이 없다면 기본값을 0으로 세팅해야한다.
//      String 은 자동 초기화. 기본값 세팅 안해도 됨.

//        TextView textView = findViewById(R.id.nameTextView);

//        if (getIntent() != null) {
//            String getData = getIntent().getStringExtra(Activity1.KEY_NAME);
//            textView.setText(getData);
//        }
    }
}