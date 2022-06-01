package com.example.mysecretdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class DiaryActivity extends AppCompatActivity {

    private EditText diaryEditText;

    // 핸들러는 메세지 큐한테 어떤일을 해달라고 던져줌.
    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        diaryEditText = findViewById(R.id.diaryEditText);

        // 사용자가 이전에 적었던 다이어리를 불러와야 한다.
        SharedPreferences notePreference = getSharedPreferences("diary", Context.MODE_PRIVATE);
        diaryEditText.setText(notePreference.getString("detail", ""));

        // 스레드 기능 구현 하기
        Runnable runnable = () -> {
            SharedPreferences preference = getSharedPreferences("diary", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preference.edit();
            editor.putString("detail", diaryEditText.getText().toString());
            editor.apply();
        };

        // 사용자가 한글자 한글자 입력할 때 마다 이벤트 리스너를 등록해서 변경사항을 가지고 오기
        diaryEditText.addTextChangedListener(new TextWatcher() {    // text 를 지켜본다
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("TAG", "char : " + s);
                Log.d("TAG", "start : " + start);
                Log.d("TAG", "after : " + after);
                Log.d("TAG", "count : " + count);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 한글자 한글자 입력이 들어올때 마다 저장 시킬 것이다.
//                Log.d("TAG", "char : " + s);
//                Log.d("TAG", "start : " + start);
//                Log.d("TAG", "before : " + before);
//                Log.d("TAG", "count : " + count);

                // IO는 메모리를 많이 잡아먹기 때문에 다른 스레드를 만들어서 ( 핸들러 ) 처리해주기
//                SharedPreferences notePreference = getSharedPreferences("diary", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = notePreference.edit();
//                editor.putString("detail", diaryEditText.getText().toString());
//                editor.apply();
                // ㅡ> 새로운 스레드를 만들어서 비동기 저장하기

                // 다른 스레드한테 일해달라고 요청하기

                // 2번 구현
                // 한글자 쓸때마다 0.5초 딜레이되는데 처음 글자썼을때와 마지막 글자썻을때만 저장되는 느낌의 메소드
                handler.removeCallbacks(runnable);

                // 핸들러야 러너블을 실행해줘
                // 1번 구현
//                handler.post(runnable);

                // 3번 구현
                handler.postDelayed(runnable, 500);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}