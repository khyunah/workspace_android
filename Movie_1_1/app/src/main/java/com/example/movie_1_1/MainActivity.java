package com.example.movie_1_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.example.movie_1_1.databinding.ActivityMainBinding;
import com.example.movie_1_1.interfaces.OnPassWebView;
import com.example.movie_1_1.utils.FragmentType;

public class MainActivity extends AppCompatActivity implements OnPassWebView {

    private ActivityMainBinding activityMainBinding;
    private WebView webView;

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
            InfoFragment infoFragment = (InfoFragment) fragment;
            infoFragment.setOnPassWebView(this);
        }

        transaction.replace(activityMainBinding.mainContainer.getId(), fragment, fragmentType.toString());
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

    @Override
    public void onSetPassWebView(WebView webView) {
        this.webView = webView;
    }

    @Override
    public void onBackPressed() {

        String fragmentTag = getSupportFragmentManager().findFragmentByTag(FragmentType.INFO.toString()).getTag();

        if (fragmentTag.equals(FragmentType.INFO.toString())) {
            if (webView.canGoBack()) {
                webView.goBack();
            } else {
                View view = activityMainBinding.bottomNav.findViewById(R.id.iconMovie);
                view.callOnClick();
            }
        } else {
            super.onBackPressed();
        }
    }
}