package com.example.movie_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // status 바 없애주기
        // 앱보다 위에있는 녀석 윈도우
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView textView = findViewById(R.id.splashTextView);

        // 애니메이션 사용하기
        Animation slideAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_side); // 어떤 화면에서 보일지, 어떤 화면을 보일지
        textView.startAnimation(slideAnimation);

        // 애니메이션을 적용하였기 때문에 ( 애니메이션에 duration 속성을 넣어서 입력했던 시간만큼 시간이 걸린다.  )
        // 해당 시간 뒤에 액티비티가 제거될 수 있도록 postDelayed() 를 사용한다.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // getApplicationContext() : 앱 전체의 정보를 가지고 있음
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                // SplashActivity 위에 MainActivity 가 뜰것이다. ( 화면이 )

                // 스택에서 현재 이 액티비티를 제거해주는 것
                finish();
            }
        }, 1500);
    }
}