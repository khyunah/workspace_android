package com.example.tablayout_page;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TabLayout tabLayout = findViewById(R.id.myTabLayoutContainer);
        tabLayout.addTab(tabLayout.newTab().setText("뉴스"));
        tabLayout.addTab(tabLayout.newTab().setText("홈"));
        tabLayout.addTab(tabLayout.newTab().setText("쇼핑"));
        tabLayout.getSelectedTabPosition();
    }
}