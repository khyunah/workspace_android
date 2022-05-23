package com.example.mybmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class BmiResultActivity extends AppCompatActivity {

    TextView bmiCheckTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        bmiCheckTextView = findViewById(R.id.bmiCheckTextView);

        if (getIntent() != null) {

            int height = getIntent().getIntExtra("height", 0);
            int weight = getIntent().getIntExtra("weight", 0);

            // BMI 지수 계산하기 체중 / 신장 * 신장 ( 신장 단위는 m )
            // Math.pow() 제곱하는 메소드
            double bmiValue = weight / Math.pow(height / 100.0, 2); // 2번 제곱할거야, 나누기 할때는 소수점으로 적어주기

            Log.d("TAG", bmiValue + "");

            String resultText = "";

            if (bmiValue <= 18.5) {
                resultText = "저체중입니다.";
            } else if (bmiValue <= 23){
                resultText = "정상 체중입니다.";
            } else if (bmiValue <= 25){
                resultText = "과체중입니다.";
            } else if (bmiValue > 25 ){
                resultText = "비만입니다.";
            }

            bmiCheckTextView.setText(resultText);

        }
    }
}