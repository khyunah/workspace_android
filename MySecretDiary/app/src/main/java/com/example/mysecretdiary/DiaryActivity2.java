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

public class DiaryActivity2 extends AppCompatActivity {

    private EditText diaryEditText;
    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary2);

        diaryEditText = findViewById(R.id.diaryEditText);

        /* 3 - 1 */
        // 스레드 만들기
        Runnable runnable = () -> {
            SharedPreferences sharedPreferences = getSharedPreferences("diaryContent", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("content1", diaryEditText.getText().toString());
            editor.apply();

            Log.d("TAG", "글자저장했음");
            Log.d("TAG", "");
        };

        /* 2 */
        // 앱을 다시 실행했을때 사용자가 입력했던 다이어리 내용 불러오기
        SharedPreferences diaryContent = getSharedPreferences("diaryContent", Context.MODE_PRIVATE);
        diaryEditText.setText(diaryContent.getString("content1", ""));

        /* 1 */
        // diaryEditText 에 한글자라도 입력을 하게 되면 실행되는 리스너
        diaryEditText.addTextChangedListener(new TextWatcher() {    // TextWatcher : 텍스트를 지켜본다라는 느낌
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("TAG", "[ beforeTextChanged ]");
                Log.d("TAG", "charSequences : " + s);
                Log.d("TAG", "start : " + start);
                Log.d("TAG", "count : " + count);
                Log.d("TAG", "after : " + after);
                Log.d("TAG", "");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("TAG", "[ onTextChanged ]");
                Log.d("TAG", "charSequences : " + s);
                Log.d("TAG", "start : " + start);
                Log.d("TAG", "before : " + before);
                Log.d("TAG", "count : " + count);
                Log.d("TAG", "");

                /* 1 - 1*/
//                SharedPreferences diaryContent = getSharedPreferences("diaryContent", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = diaryContent.edit();
//                editor.putString("content1", diaryEditText.getText().toString());
//                editor.apply();

                /* 3 */
                // IO 는 메모리를 많이 잡아먹기 때문에 메인 스레드가 감당하기에는 예상치 못한 오류가 발생한다.
                // 서브 스레드를 따로 돌려주기

                /* 3 - 2 */
                // 이벤트가 들어올때마다 마다 실행하는 post
                handler.post(runnable);

                /* 3 - 3 */
                // 글자가 들어왔을때 콜백을 지워버리는 역할
//                handler.removeCallbacks(runnable);
//
//                handler.postDelayed(runnable, 2000);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("TAG", "[ afterTextChanged ]");
                Log.d("TAG", s.toString());
                Log.d("TAG", "");
            }
        });
    }
}