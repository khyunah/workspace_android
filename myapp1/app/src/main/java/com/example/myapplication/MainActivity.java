package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";

    private TextView zero;
    private TextView one;
    private TextView two;
    private TextView three;
    private TextView four;
    private TextView five;
    private TextView six;
    private TextView seven;
    private TextView eight;
    private TextView nine;
    private TextView ca;
    private TextView plus;

    private TextView result;

//    int sum = 0;
    String oldValue = "0";
    String newValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * 아래의 코드에서 id를 들고올때 여기 적어준 액티비티에 속하는 id만 가져올 수 있다.
         * 다른 액티비티의 id를 가져오면 NullPointException 발생함
         *
         * 코드의 오류가 발생하면 앱 실행할때 죽여버림. ㅡ> 크러쉬 났다 라고 말함
         *
         * ctrl + d : 라인 복사
         * alt + shift : 마우스로 단어 앞 누르고 ctrl + shift 하면 단어만큼 선택됨
         */
        setContentView(R.layout.calc_01);

        initData();
        addEventListener();
    }

    private void initData(){
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);   // (1000004) 주소
        two = findViewById(R.id.two);   // R : 리소스
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        ca = findViewById(R.id.ca);
        plus = findViewById(R.id.plus);
        result = findViewById(R.id.result);

        System.out.println("initData 메서드 호출");
    }

    private void addEventListener(){
        zero.setOnClickListener(view -> {
            newValue = newValue + "0";
            result.setText(newValue);
            Log.d(TAG, "zero가 눌러졌어요.");
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newValue = newValue + "1";
                result.setText(newValue);
                Log.d("MYTAG", "one이 눌러졌어요.");    // 안드로이드에서는 sysout 보다 로그 많이 씀
                // tag 저거는 쓰는거 아니고 문자열 작성하면 자동으로 나옴
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newValue = newValue + "2";
                result.setText(newValue);
                Log.d("MYTAG", "two가 눌러졌어요.");      // d는 태그별로 보고 싶은 것만 보고싶은 Log 일때 사용
            }
        });

        three.setOnClickListener(view -> {
            newValue = newValue + "3";
            result.setText(newValue);
            Log.d(TAG, "three가 눌러졌어요.");    // 안드로이드에서는 익명구현객체보다 람다식을 많이 사용한다.
        });

        four.setOnClickListener(view -> {
            newValue = newValue + "4";
            result.setText(newValue);
            Log.d(TAG, "four가 눌러졌어요.");
        });

        five.setOnClickListener(view -> {
            newValue = newValue + "5";
            result.setText(newValue);
            Log.d(TAG, "five가 눌러졌어요.");
        });

        six.setOnClickListener(view -> {
            newValue = newValue + "6";
            result.setText(newValue);
            Log.d(TAG, "six가 눌러졌어요.");
        });

        seven.setOnClickListener(view -> {
            newValue = newValue + "7";
            result.setText(newValue);
            Log.d(TAG, "seven이 눌러졌어요.");
        });

        eight.setOnClickListener(view -> {
            newValue = newValue + "8";
            result.setText(newValue);
            Log.d(TAG, "eight가 눌러졌어요.");
        });

        nine.setOnClickListener(view -> {
            newValue = newValue + "9";
            result.setText(newValue);
//            sum = oldValue + Integer.parseInt(newValue);
//            result.setText(sum + "");
            Log.d(TAG, "nine이 눌러졌어요.");
        });

        ca.setOnClickListener(view -> {
            oldValue = "0";
            newValue = "0";
            result.setText("0");
            Log.d(TAG, "ca가 눌러졌어요.");
        });

        plus.setOnClickListener(view -> {
            int number1 = Integer.parseInt(newValue);
            int number2 = Integer.parseInt(oldValue);
            int sum = (number1 + number2);

            Log.d(TAG, "number1 : " + number1);
            Log.d(TAG, "number2 : " + number2);
            Log.d(TAG, "sum : " + sum);

            oldValue = String.valueOf(sum);
            result.setText(oldValue);
            newValue = "0";
            Log.d(TAG, "+가 눌러졌어요.");
        });
    }

}