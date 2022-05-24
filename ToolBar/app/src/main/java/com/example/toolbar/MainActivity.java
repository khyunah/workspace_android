package com.example.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolBar);

        // 이 툴바를 셋팅할거야 라고 선언하는 것.
        // 선언하지 않으면 효과 적용이 안됨.
        setSupportActionBar(toolbar);

    }

    // inflater : 메모리에 올려주는 역할
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        // inflate : 메모리에 올려주는 메소드
        inflater.inflate(R.menu.menu_toolbar, menu);  // R,리소스 . menu 패키지 . 파일이름 . 오브젝트 ( 뭔가 효과를 줄떄 사용하기 위해 )
        return true;
    }

    // 뭔가 눌러졌을때 동작 하는 메소드 ( 콜백 개념 )
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {  // 메뉴아이템이 전부 넘어온다

        switch (item.getItemId()){
            case R.id.menuItem1:
                Log.d("TAG", "1 번 클릭");
                break;
            case R.id.menuItem2:
                Log.d("TAG", "2 번 클릭");
                break;
            case R.id.menuItem3:
                Log.d("TAG", "3 번 클릭");
                break;
        }

        return true;    // true 여야 이벤트 리스너가 동작한다.
    }
}