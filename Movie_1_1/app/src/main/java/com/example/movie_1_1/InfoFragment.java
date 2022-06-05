package com.example.movie_1_1;

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

import com.example.movie_1_1.databinding.FragmentInfoBinding;
import com.example.movie_1_1.interfaces.OnPassWebView;

public class InfoFragment extends Fragment {

    private static InfoFragment infoFragment;
    private WebView webView;
    private FragmentInfoBinding fragmentInfoBinding;

    private OnPassWebView onPassWebView;
    private OnBackPressedCallback onBackPressedCallback;

    public void setOnPassWebView(OnPassWebView onPassWebView){
        this.onPassWebView = onPassWebView;
    }

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentInfoBinding = FragmentInfoBinding.inflate(inflater, container, false);

        webView = fragmentInfoBinding.webView;
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        onPassWebView.onSetPassWebView(webView);

        // 웹뷰에서 버튼이나 어떤링크 클릭시 웹사이트로 전환되는것을 웹뷰안에서 전환되도록 해줌
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
        webView.loadUrl("https://yts.mx/");

        return fragmentInfoBinding.getRoot();
    }
}