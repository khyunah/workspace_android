package com.example.movie_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.movie_1.databinding.ActivityMainBinding;
import com.example.movie_1.utils.FragmentType;

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

        // 2, 3번이 저번에 했던 플래그먼트 올리는 방식이랑 똑같음
        // View itemView = LayoutInflater.from(context).inflate(R.layout.item_closet, parent, false);

        replaceFragment(FragmentType.MOVIE);

        addBottomNavigationListener();
    }

    private void replaceFragment(FragmentType type) {
        Fragment fragment;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if (type == FragmentType.MOVIE) {
            // 생성
            fragment = MovieFragment.newInstance();
        } else {
            // 생성
            fragment = InfoFragment.newInstance();
        }

        transaction.replace(binding.mainContainer.getId(), fragment, type.toString());
        transaction.commit();
    }

    private void addBottomNavigationListener() {
        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.page1:
                    replaceFragment(FragmentType.MOVIE);
                    break;
                case R.id.page2:
                    replaceFragment(FragmentType.INFO);
                    break;
            }
            return true;
        });
    }
}