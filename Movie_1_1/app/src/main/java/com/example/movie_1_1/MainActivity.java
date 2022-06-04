package com.example.movie_1_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.movie_1_1.databinding.ActivityMainBinding;
import com.example.movie_1_1.utils.FragmentType;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(activityMainBinding.getRoot());
        replaceFragment(FragmentType.MOVIE);
        tabBottomNav();
    }

    private void replaceFragment(FragmentType fragmentType) {
        Fragment fragment = null;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        

        if (fragmentType == FragmentType.MOVIE) {
            fragment = MovieFragment.getInstance();
        } else {
            fragment = InfoFragment.getInstance();
        }

        transaction.replace(activityMainBinding.mainContainer.getId(), fragment);
        transaction.commit();
    }

    private void tabBottomNav() {
        activityMainBinding.bottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.iconMovie:
                    replaceFragment(FragmentType.MOVIE);
                    break;
                case R.id.iconInfo:
                    replaceFragment(FragmentType.INFO);
                    break;
            }
            return true;
        });
    }
}