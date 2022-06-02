package com.example.movie_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.movie_1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // 뷰 바인딩 생성 방법
    // 1. xml 파일의 컴포넌트들을 가지고만 오기
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. 객체 초기화 ( 메모리에 올려준다. )
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // 3. 연결
        setContentView(binding.getRoot());

    }
}