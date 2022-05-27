package com.example.mytablayout_pager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout myTabLayoutContainer = findViewById(R.id.myTabLayoutContainer);
        myTabLayoutContainer.addTab(myTabLayoutContainer.newTab().setText("shopping"));
        myTabLayoutContainer.addTab(myTabLayoutContainer.newTab().setText("news"));
        myTabLayoutContainer.addTab(myTabLayoutContainer.newTab().setText("webtoon"));

        ViewPager myViewPagerContainer = findViewById(R.id.myViewPagerContainer);

        // 어뎁터 객체를 생성
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), 3);

        // 페이지 어뎁터와 뷰페이저를 연결
        myViewPagerContainer.setAdapter(myPagerAdapter);

        // 탭이랑 페이저랑 연결하기


    }
}

