package com.example.movie_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.movie_1.models.Movie;

public class MovieDetailActivity extends AppCompatActivity {

    // 화면을 구성하는 방법
    // 1. 데이터를 전달 받아서 화면을 구성
    // 2. 여기서 통신을 요청해서 화면을 구성

    private Movie movie;
    public static final String PARAM_NAME_1 = "movie obj";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        if (getIntent() != null) {
            movie = (Movie) getIntent().getSerializableExtra(PARAM_NAME_1);
        }
    }
}