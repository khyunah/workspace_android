package com.example.mytablayout_pager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
        myViewPagerContainer.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(myTabLayoutContainer));

        // 탭 클릭시 뷰페이저도 같이 이동
        myTabLayoutContainer.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                myViewPagerContainer.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}

