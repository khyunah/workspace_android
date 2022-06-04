package com.example.movie_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.example.movie_1.databinding.ActivityMainBinding;
import com.example.movie_1.interfaces.OnChangeToolbarType;
import com.example.movie_1.interfaces.OnPassWebview;
import com.example.movie_1.utils.Define;
import com.example.movie_1.utils.FragmentType;

public class MainActivity extends AppCompatActivity implements OnChangeToolbarType, OnPassWebview {

    // 뷰 바인딩 생성 방법
    // 1. xml 파일의 컴포넌트들을 가지고만 오기
    ActivityMainBinding binding;
    WebView webView;    // InfoFragment 생성하는 웹뷰 객체 주소를 전달 받을 예정

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
            fragment = MovieFragment.getInstance(this);

        } else {
            // 생성
            fragment = InfoFragment.getInstance(this);
            if (fragment != null) {
                InfoFragment infoFragment = (InfoFragment) fragment;
                infoFragment.setOnPassWebview(this);
            }

        }

        // 문자열로 이름지어서 구분
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

    // 앱 뒤로가기 버튼 활성화 ( 원래 기본적으로 되어있음 )
    @Override
    public void onBackPressed() {
        // info 라면 한번은 movie 갔다가
        // movie 면 종료 해보기
        // mainContainer 에 올라와있는 녀석이 현재 movie 인지 info 인지 구분을해 야함
        String fragmentTag = getSupportFragmentManager().findFragmentByTag(FragmentType.INFO.toString()).getTag();
        if (fragmentTag.equals(FragmentType.INFO.toString())) {
            if (webView.canGoBack()) {
                webView.goBack();
            } else {
                //            replaceFragment(FragmentType.MOVIE);
                View view = binding.bottomNavigation.findViewById(R.id.page1);
                view.callOnClick();
            }
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onSetupType(String title) {
        // 플래그먼트에서 호출 하면 여기서 실행
        if (title.equals(Define.PAGE_TITLE_MOVIE)) {
            binding.topAppbar.setTitle(title);
            binding.topAppbar.setVisibility(View.VISIBLE);
        } else if (title.equals(Define.PAGE_TITLE_INFO)) {
            binding.topAppbar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPassWebviewObj(WebView webView) {
        this.webView = webView;
    }
}