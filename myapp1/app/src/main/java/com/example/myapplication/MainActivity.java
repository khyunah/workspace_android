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
    private TextView calculation;
    private TextView plus;
    private TextView minus;
    private TextView multi;
    private TextView division;
    private TextView dot;

    private TextView result;

    String oldValue = "";
    String newValue = "";

    boolean isPlus = false;
    boolean isMinus = false;
    boolean isMulti = false;
    boolean isDivision = false;
    boolean isZero = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_01);

        initData();
        addEventListener();
    }

    private void initData() {
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        ca = findViewById(R.id.ca);
        calculation = findViewById(R.id.calculation);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multi = findViewById(R.id.multi);
        division = findViewById(R.id.division);
        result = findViewById(R.id.result);
        dot = findViewById(R.id.dot);

        System.out.println("initData 메서드 호출");
    }

    private void addEventListener() {
        zero.setOnClickListener(view -> {
            int index_zero = newValue.indexOf("0");
            int index_dot = newValue.lastIndexOf(".");

            if (newValue.equals("") && oldValue.equals("")) {
                isZero = true;
            } else if (index_zero != 0) {
                clickNumber(zero);
            } else if (index_dot != -1){
                clickNumber(zero);
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newValue = newValue + "1";
                result.setText(newValue);
                Log.d("MYTAG", "one이 눌러졌어요.");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newValue = newValue + "2";
                result.setText(newValue);
                Log.d("MYTAG", "two가 눌러졌어요.");
            }
        });

        three.setOnClickListener(view -> {
            clickNumber(three);
        });

        four.setOnClickListener(view -> {
            clickNumber(four);
        });

        five.setOnClickListener(view -> {
            clickNumber(five);
        });

        six.setOnClickListener(view -> {
            clickNumber(six);
        });

        seven.setOnClickListener(view -> {
            clickNumber(seven);
        });

        eight.setOnClickListener(view -> {
            clickNumber(eight);
        });

        nine.setOnClickListener(view -> {
            clickNumber(nine);
        });

        ca.setOnClickListener(view -> {
            oldValue = "";
            newValue = "";
            result.setText("0");
            Log.d(TAG, "초기화 CA 클릭");
        });

        calculation.setOnClickListener(view -> {
            calc(calculation);
        });

        plus.setOnClickListener(view -> {
            isMinus = false;
            isMulti = false;
            isDivision = false;

            isPlus = true;
            calc(plus);
        });

        minus.setOnClickListener(view -> {
            isPlus = false;
            isMulti = false;
            isDivision = false;

            isMinus = true;
            calc(minus);
        });

        multi.setOnClickListener(view -> {
            isPlus = false;
            isMinus = false;
            isDivision = false;

            isMulti = true;
            calc(multi);
        });

        division.setOnClickListener(view -> {
            isPlus = false;
            isMinus = false;
            isMulti = false;

            isDivision = true;
            calc(division);
        });

        dot.setOnClickListener(view -> {
            Log.d(TAG, "소수점 " + dot.getText() + " 클릭");

            if (isZero) {
                if(newValue.equals("")){
                    newValue = newValue + "0.";
                    result.setText(newValue);
                }
            }

            if (!newValue.equals("")) {
                if (!newValue.contains(".")) {
                    newValue = newValue + ".";
                    result.setText(newValue);
                }
            }
            isZero = false;
        });
    }

    public void clickNumber(TextView number) {
        newValue = newValue + number.getText();
        result.setText(newValue);
        Log.d(TAG, "숫자 " + number.getText() + " 번 클릭");
    }

    public void calc(TextView sign) {
        Log.d(TAG, "부호 " + sign.getText() + " 클릭");

        if (!newValue.equals("")) {

            double number1 = Double.parseDouble(newValue);
            double number2 = 0;
            double sum = number1;

            if (!oldValue.equals("")) {
                number2 = Double.parseDouble(oldValue);
                if (isPlus) {
                    sum = number1 + number2;
                } else if (isMinus) {
                    sum = number2 - number1;
                } else if (isMulti) {
                    sum = number1 * number2;
                } else if (isDivision) {
                    sum = number2 / number1;
                }
            }

            if ((sum % 1) == 0) {
                oldValue = String.format("%.0f", sum);
            } else {
                oldValue = String.format("%.2f", sum);
            }

            result.setText(oldValue);
            newValue = "";
        }
    }

}