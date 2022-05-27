package com.example.tablayout_page;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

/*
 * pager
 *   - 화면을 스와이프 해주는 역할
 *   - 데이터와 화면을 잘 연결하기 위해 어댑터가 필요함
 *   - 탭바 와 연결됨
 *
 * TabLayout
 *   - 탭을 담당하는 역할
 *   - 보통 같이 작성하지만 따로해도 상관없다.
 *
 * 두개를 만들고 나서는 연결을 해줘야한다.
 * 리스너 를 이용
 *   - 연결해주기 위해 필요
 *
 * */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    static final int TAB_COUNT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 자바에서 동적으로 탭 만들어줄때
        // 탭 레이아웃 안에 새로운 탭을 만들겠다. 하는 코드
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("ONE"));
        tabLayout.addTab(tabLayout.newTab().setText("TWO"));
        tabLayout.addTab(tabLayout.newTab().setText("THREE"));

        // 클릭시 이벤트 리스너 등록하는 방법 .addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {});
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            // 1번 탭에서 2번 탭으로 진행할때 1번탭이 사라질 일이 있다면 onTabUnselected 에서 작성
            // 새로운 탭이 선택되었을때는 onTabSelected 에서 작성 하면 된다는 결론.

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int position = tab.getPosition();

            }

            // 활성화 된거 한번 더 눌렀을 때
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int position = tab.getPosition();

            }
        });

        ViewPager viewPager = findViewById(R.id.viewPager);
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), TAB_COUNT);
        viewPager.setAdapter(myPagerAdapter);
    }
}

class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(@NonNull FragmentManager fm, int behavior) {  // behavior : 몇개 있는지
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
        return MainActivity.TAB_COUNT;
    }
}