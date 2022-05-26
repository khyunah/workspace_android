package com.example.lottogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    Button btnAdd;
    Button btnInit;
    Button btnCreate;

    NumberPicker numberPicker;

    ArrayList<TextView> numberTextViewList = new ArrayList<>();
    ArrayList<Integer> numberPickerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initData();
        addEventListener();
    }

    private void initData() {
        btnAdd = findViewById(R.id.btnAdd);
        btnInit = findViewById(R.id.btnInit);
        btnCreate = findViewById(R.id.btnCreate);

        numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(45);

        // xml 파일에 등록된 TextView 를 리스트에 담아준다.
        numberTextViewList.add(findViewById(R.id.number1));
        numberTextViewList.add(findViewById(R.id.number2));
        numberTextViewList.add(findViewById(R.id.number3));
        numberTextViewList.add(findViewById(R.id.number4));
        numberTextViewList.add(findViewById(R.id.number5));
        numberTextViewList.add(findViewById(R.id.number6));
    }

    private void addEventListener() {
        btnAdd.setOnClickListener(view -> {
            int num = numberPicker.getValue();

            // 숫자하나를 선택했다면 TextView 하나를 사용한 것으로
            // numberPickerList 의 사이즈 == numberTextViewList 의 사이즈
            TextView textView = numberTextViewList.get(numberPickerList.size());
            textView.setVisibility(View.VISIBLE);
            textView.setText(String.valueOf(num));

            numberPickerList.add(num);
        });

        btnCreate.setOnClickListener(view -> {
            List<Integer> numberList = getRandomNumber();
            numberList.addAll(numberPickerList);

            for (int i = 0; i < numberList.size(); i++) {
                // 반환하는 객체가 Integer 이기때문에 String 으로 변환
                numberTextViewList.get(i).setText(String.valueOf(numberList.get(i)));
                numberTextViewList.get(i).setVisibility(View.VISIBLE);
            }
        });
    }

    // subList 는 List 로 리턴한다.
    private List<Integer> getRandomNumber() {
        ArrayList<Integer> randomNumberList = new ArrayList<>();

        for (int i = 1; i < 46; i++) {
            if (numberPickerList.contains(i)) {
                continue;
            }
            randomNumberList.add(i);
        }

        Collections.shuffle(randomNumberList);

        return randomNumberList.subList(0, 6 - numberPickerList.size());
    }
}