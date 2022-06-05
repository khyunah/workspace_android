package com.example.movie_1_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.movie_1_1.databinding.FragmentInfoBinding;

public class InfoFragment extends Fragment {

    private static InfoFragment infoFragment;
    private WebView webView;
    private FragmentInfoBinding fragmentInfoBinding;

    private InfoFragment() {

    }

    public static InfoFragment getInstance() {
        if (infoFragment == null) {
            infoFragment = new InfoFragment();
        }
        return infoFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentInfoBinding = FragmentInfoBinding.inflate(getLayoutInflater());
        webView = fragmentInfoBinding.webView;
        webView.loadUrl("https://yts.mx/");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return fragmentInfoBinding.getRoot();
    }
}