package com.example.bottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.bottomnav.utils.FragmentType;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottomNavigation);
        addBottomNavigationListener();
        replaceFragment(FragmentType.HOME);
    }

    private void replaceFragment(FragmentType type) {
        Fragment fragment = null;

        // 플래그먼트 매니저
        FragmentManager manager = getSupportFragmentManager();

        // 플래그먼트 트랜젝션
        FragmentTransaction transaction = manager.beginTransaction();

        if (type == FragmentType.HOME) {
            fragment = new FragmentHome();
        } else if (type == FragmentType.TV) {
            fragment = new FragmentTv();
        } else if (type == FragmentType.CAL) {
            fragment = new FragmentCal();
        }

        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
    }

    private void addBottomNavigationListener() {
        bottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.page_home:
                    replaceFragment(FragmentType.HOME);
                    break;
                case R.id.page_tv:
                    replaceFragment(FragmentType.TV);
                    break;
                case R.id.page_calendar:
                    replaceFragment(FragmentType.CAL);
                    break;
            }
            return true;
        });
    }
}