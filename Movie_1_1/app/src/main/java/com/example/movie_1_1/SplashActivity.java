package com.example.movie_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // 애니메이션 효과
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_from_top);
        findViewById(R.id.ytsMovieTitleTv).startAnimation(animation);
    }
}