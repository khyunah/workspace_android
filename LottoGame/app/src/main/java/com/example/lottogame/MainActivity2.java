package com.example.lottogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;

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

            TextView textView = numberTextViewList.get(numberPickerList.size());
            textView.setVisibility(View.VISIBLE);
            textView.setText(String.valueOf(num));

            numberPickerList.add(num);
        });
    }
}