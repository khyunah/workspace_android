package com.example.movie_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
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

        // 해당 액티비티는 앱 처음 실행시에만 보여주고 메인 액티비티로 전환해준다.
        // 스택메모리에서 해당 액티비티를 지워주겠음.

        // 하지만 애니메이션에서 duration 이라는 속성을 줘서 일정시간동안 화면을 그린다.
        // 시간을 조정하는 객체를 이용하여 화면을 일정시간 뒤에 없애줘야한다.
        // Thread.sleep() 을 줘서 시간을 조정하는 방법도 있지만,
        // 최근 배운 Handler.postDelayed() 를 이용해보겠음.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                // 메인화면으로 전환
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                finish();
            }
        }, 2000);

        // status 바 없애기 / 화면 풀스크린 만들기
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
    }
}