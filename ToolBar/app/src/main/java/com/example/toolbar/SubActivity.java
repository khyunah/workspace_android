package com.example.toolbar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Button button = findViewById(R.id.btnFinish);

        // 값을 꺼내는 방법
        int value1 = getIntent().getIntExtra("value1", 0);
        Log.d("TAG", "value1 : " + value1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 값을 메인 액티비티에 보내기
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", value1 + 10);

                // 값을 돌려보내기 위해서 해야하는 메소드 호출 setResult()
                setResult(Activity.RESULT_OK, resultIntent);

                // 뒤로가기 기능
                // 이 메소드를 사용해야 이전 화면으로 돌아간다.
                finish();
            }
        });
    }
}