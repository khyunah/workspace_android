package com.example.class_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_bmicheck extends AppCompatActivity {

    private TextView heightResult;
    private TextView weightResult;
    private TextView bmiValue;
    private TextView bmiResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicheck);

        // 화면에 텍스트를 셋팅하기 위해 컴포넌트 들고오기
        heightResult = findViewById(R.id.heightResult);
        weightResult = findViewById(R.id.weightResult);
        bmiValue = findViewById(R.id.bmiValue);
        bmiResult = findViewById(R.id.bmiResult);

        if (getIntent() != null) {

            int height = getIntent().getIntExtra("height", 0);
            int weight = getIntent().getIntExtra("weight", 0);

            // BMI 지수 공식
            // 체중 / 신장 * 신장
            double bmiValue_double = weight / Math.pow(height / 100.0, 2);

            // 소수점 자릿수 설정
            double round_bmlValue = Math.round(bmiValue_double) * 100 / 100.0;

            // BMI 결과값 담기
            String resultText = "";

            if (bmiValue_double <= 18.5) {
                resultText = "저체중입니다.";
            } else if (bmiValue_double <= 23) {
                resultText = "정상 체중입니다.";
            } else if (bmiValue_double <= 25) {
                resultText = "과체중입니다.";
            } else if (bmiValue_double > 25) {
                resultText = "비만입니다.";
            }

            heightResult.append(String.valueOf(height));
            weightResult.append(String.valueOf(weight));
            bmiValue.append(String.valueOf(round_bmlValue));
            bmiResult.setText(resultText);
        }
    }
}