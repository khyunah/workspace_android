package com.example.myretrofit3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.myretrofit3.service.JPHService;

import retrofit2.Retrofit;

/*
    버튼을 누르면 해당 서비스메소드가 호출되어 통신하는 방식임.
 */
public class MainActivity extends AppCompatActivity {

    private JPHService service;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        addEventListener();

    }

    private void initData(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
    }

    private void addEventListener(){
        btn1.setOnClickListener(view -> {
            Log.d("TAG", "btn1 click");
        });

        btn2.setOnClickListener(view -> {
            Log.d("TAG", "btn2 click");
        });

        btn3.setOnClickListener(view -> {
            Log.d("TAG", "btn3 click");
        });

        btn4.setOnClickListener(view -> {
            Log.d("TAG", "btn4 click");
        });

        btn5.setOnClickListener(view -> {
            Log.d("TAG", "btn5 click");
        });

        btn6.setOnClickListener(view -> {
            Log.d("TAG", "btn6 click");
        });
    }

}