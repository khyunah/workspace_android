package com.example.tablayout_page;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class ViewPagerEx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_ex);

        // 컴포넌트 들고오기
        ViewPager viewPager = findViewById(R.id.myViewPagerContainer);

        // 플래그먼트 세팅한 뷰 페이저 어댑터 메모리에 올리기
        MyViewpagerAdapter myViewpagerAdapter = new MyViewpagerAdapter(getSupportFragmentManager(), 3);

        // 컴포넌트 뷰페이저에 플래그먼트 세팅한 뷰페이저어댑터 연결해주기
        viewPager.setAdapter(myViewpagerAdapter);

    }

    // 뷰 페이저에 플래그먼트 셋팅하는 뷰페이저어댑터
    class MyViewpagerAdapter extends FragmentPagerAdapter {

        public MyViewpagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new FragmentOne();
                    break;
                case 1:
                    fragment = new FragmentTwo();
                    break;
                case 2:
                    fragment = new FragmentThree();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}