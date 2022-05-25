package com.example.myplagment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    private FragmentBanner fragmentBanner;
    private Button btnCreate;
    private Button btnDelete;
    private LinearLayout container;

    private FragmentMyBanner fragmentMyBanner;
    private Button btnMyFragCreate;
    private Button btnMyFragDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnCreate = findViewById(R.id.btnCreate);
        btnDelete = findViewById(R.id.btnDelete);
        container = findViewById(R.id.container);

        btnMyFragCreate = findViewById(R.id.btnMyFragCreate);
        btnMyFragDelete = findViewById(R.id.btnMyFragDelete);

        btnCreate.setOnClickListener(view -> {
            fragmentBanner = new FragmentBanner();

            // 플래그먼트를 동적으로 만들기 위해서 필요한 준비물
            // 1. FragmentManager 클래스 필요.
            //      - 플래그먼트 트랜젝션 객체를 가져올수 있다.
            // 2. FragmentTransaction 필요.
            //      - 하나의 작업 단위이다.
            //      - Transaction : 시작과 끝이 있다.
            //      - 여러개의 부분 부분 작업을 한 단위로 만들어 준다.

            // 1. 객체 가져오기
            // new 를 해도되지만 미리 메모리에 떠있는 애가 있음 ㅡ> getSupportFragmentManager()
            FragmentManager manager = getSupportFragmentManager();
            // 하지만 new 를 해서 생성하게 되면 NullPointException 이나 오류가 날 경우가 많아서 미리 만들어준 개념

            // 2. 지금부터 트랜잭션 처리를 할거야.
            FragmentTransaction transaction = manager.beginTransaction();

            // 실행코드 xml 파일 만들어 둔 영영 ( view component ) 에 올려라
            transaction.replace(R.id.container, fragmentBanner);

            // 너가 시간이 될때 완료해
            transaction.commit();   // 반드시 호출 해야함

            // 지금 당장 해
//            transaction.commitNow();

            // 하긴할거지만 위험하다 커밋이 없어질 수 있다. ( 실무에서 거의 안씀. 99.9퍼 )
//            transaction.commitAllowingStateLoss();

        });

        // 플래그먼트 제거하는 방법
        btnDelete.setOnClickListener(view -> {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            transaction.remove(fragmentBanner);
            // detach 도 사용가능
//            transaction.detach(fragmentBanner);
            transaction.commit();
        });

        // 버튼 클릭시 생성 만들기
        btnMyFragCreate.setOnClickListener(view -> {
            fragmentMyBanner = new FragmentMyBanner();

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            transaction.replace(R.id.myContainer, fragmentMyBanner);
            transaction.commit();
        });

        btnMyFragDelete.setOnClickListener(view -> {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            transaction.remove(fragmentMyBanner);
            transaction.commit();
        });
    }
}