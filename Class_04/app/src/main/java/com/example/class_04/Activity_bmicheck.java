package com.example.class_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_bmicheck extends AppCompatActivity {

    TextView heightResult;
    TextView weightResult;
    TextView bmiValue;
    TextView bmiResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicheck);

        heightResult = findViewById(R.id.heightResult);
        weightResult = findViewById(R.id.weightResult);
        bmiValue = findViewById(R.id.bmiValue);
        bmiResult = findViewById(R.id.bmiResult);

        if (getIntent() != null) {

            int height = getIntent().getIntExtra("height", 0);
            int weight = getIntent().getIntExtra("weight", 0);

            double bmiValue_double = weight / Math.pow(height / 100.0, 2) ;
            double round_bmlValue = Math.round(bmiValue_double) * 100 / 100.0;
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