package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnSave;
    private Button btnLoad;
    private Button btnDelete;
    private Button btnDeleteAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        addEventListener();

        // SharedPreference
        // 안드로이드 운영체제는 여러개의 앱을 동시에 처리한다.
        // MODE_PRIVATE : 다른앱이 데이터를 탈취하는 것을 못하게 하는 것.
        //                생성한 어플리케이션에서만 사용가능함.
        // MODE_WORLD_READABLE : 다른 앱에서 사용가능 하지만 읽을수만 있다.
        // MODE_WORLD_WRITEABLE : 다른 앱에서 사용가능하고 읽고, 기록 가능.
        SharedPreferences sp1 = getSharedPreferences("sp1", MODE_PRIVATE);

        // 데이터를 입력 해보기
        // 1. 데이터를 넣기 위해 수정모드로 먼저 만들어야 한다.
        SharedPreferences.Editor editor = sp1.edit();

        // 2. 글작성 단계
        editor.putString("name", "홍길동");

        // 3. 저장하기
        editor.apply();
        // editor.apply();

        // commit()과 apply()의 차이점
        // apply() : 스레드를 블록되지 않는다. ( 권장 )
        //           비동기 방식으로 움직인다. ( 저장을 하는동안 기다리는게 아니라 다른애보고 시킴 )
        //           저장의 성공여부 true, false 값을 반환하지 않는다.
        // commit(): 스레드가 블록된다.
        //           동기 방식으로 움직인다.
        //           commit 은 저장을 성공하면 true 값을 반환한다.
    }

    private void initData() {
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        btnDelete = findViewById(R.id.btnDelete);
        btnDeleteAll = findViewById(R.id.btnDeleteAll);
    }

    private void addEventListener() {
        btnSave.setOnClickListener(view -> {
            // name, age, isMarried
            // 1. SharedPreferences 객체 들고오기
            SharedPreferences preferences = getSharedPreferences("sp2", MODE_PRIVATE);

            // 2. 수정모드로 만들어 주기
            SharedPreferences.Editor editor = preferences.edit();

            // 3. 저장할 데이터 입력하기
            editor.putString("name", "김현아");
            editor.putInt("age", 20);
            editor.putBoolean("isMarried", true);

            // 4. 비동기 방식으로 저장하기
            editor.apply();
        });

        btnLoad.setOnClickListener(view -> {
            // sp1 객체 들고오기
            SharedPreferences preferences = getSharedPreferences("sp1", MODE_PRIVATE);

            // sp1 데이터 읽기
            String name = preferences.getString("name", "");
            Log.d("TAG", "name 값 확인 : " + name);

            // sp2 객체 들고오기
            SharedPreferences sharedPreferences = getSharedPreferences("sp2", MODE_PRIVATE);

            // sp2 데이터 읽기
            String myName = sharedPreferences.getString("name", "");
            int age = sharedPreferences.getInt("age", 0);
            boolean isMarried = sharedPreferences.getBoolean("isMarried", false);

            // Toast.makeText(this, "name : " + myName, Toast.LENGTH_SHORT).show();

            Log.d("TAG", "name : " + myName);
            Log.d("TAG", "age : " + age);
            Log.d("TAG", "isMarried : " + isMarried);
        });

        btnDelete.setOnClickListener(view -> {
            // 메서드 체이닝 방식으로 코드 작성하기
            // age 삭제하기

            // 객체 들고오기
            // 삭제모드 만들기
            // 데이터 삭제하고 저장하기
            getShared("sp2").edit().remove("age").apply();

            // 삭제 여부 확인
            // 코드로 버튼을 누른것과 같이 명령하기
            btnLoad.callOnClick();
        });

        btnDeleteAll.setOnClickListener(view -> {
            // 객체들고오기
            // 삭제모드 만들기
            // 전체 지우고 저장하기
            getShared("sp2").edit().clear().apply();

            btnLoad.callOnClick();
        });
    }

    private SharedPreferences getShared(String name){
        return getSharedPreferences(name, MODE_PRIVATE);
    }
}