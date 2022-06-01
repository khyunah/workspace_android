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
    // Looper 는 메세지 큐에 쌓이는 메세지들을 핸들러에게 보내주는 역할을 한다.
    /*
    * Looper 객체가 메세지 큐에서 메세지를 하나 딱 까봤을 때,
    * Runnable 객체가 담겨져있으면 Handler 에 메세지를 전달하지 않고, run() 을 수행하여 해당 Runnable 작업을 바로 시작하고,
    * Runnable 객체가 없을 경우 Message 객체 내부에 명시돼있는 Handler 의 handleMessage() 를 수행하여 처리한다.
    *
    * */
    private Handler handler = new Handler(Looper.getMainLooper());  // Looper.getMainLooper() : 메인 스레드의 메인 루퍼를 반환

    /*
    * Handler
    *
    * 특정 메세지를 Looper 의 MessageQueue 에 넣거나,
    * Looper 가 MessageQueue 에서 특정 메세지를 꺼내어 전달하면 이를 처리하는 기능을 수행한다.
    * 중간 다리 역할을 수행한다.
    * post 로 시작하는 메소드들을 통해 Runnable 객체를 직접 적재할 수 있다.
    * */

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