package com.example.movie_1;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import com.example.movie_1.databinding.FragmentInfoBinding;
import com.example.movie_1.interfaces.OnChangeToolbarType;
import com.example.movie_1.utils.Define;

public class InfoFragment extends Fragment {

    private FragmentInfoBinding binding;

    // 콜백
    private OnChangeToolbarType onChangeToolbarType;

    // 콜백 연결할 메소드
//    public void setOnChangeToolbarType(OnChangeToolbarType onChangeToolbarType) {
//        this.onChangeToolbarType = onChangeToolbarType;
//    }

    private static InfoFragment infoFragment;

    private OnBackPressedCallback onBackPressedCallback;

    private InfoFragment(OnChangeToolbarType onChangeToolbarType) {
        this.onChangeToolbarType = onChangeToolbarType;
    }

    public static InfoFragment getInstance(OnChangeToolbarType onChangeToolbarType) {
        if (infoFragment == null) {
            infoFragment = new InfoFragment(onChangeToolbarType);
        }
        return infoFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // 뷰 결합하기 위해 메모리 초기화
        binding = FragmentInfoBinding.inflate(inflater, container, false);
        onChangeToolbarType.onSetupType(Define.PAGE_TITLE_INFO);
        setupWebView();

        // 웹뷰 뒤로가기 설정
        onBackPressedCallback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Log.d("TAG", "handleOnBackPressed");
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), onBackPressedCallback);
        return binding.getRoot();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setupWebView() {
        WebView webView = binding.mWebView;
        webView.loadUrl("https://yts.mx/");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                binding.progressIndicators.setVisibility(View.GONE);
            }
        });

        // 자바스크립트 허용 코드 넣어주기
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        onBackPressedCallback.remove();
    }
}