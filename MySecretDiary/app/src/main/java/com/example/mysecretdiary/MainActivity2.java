package com.example.mysecretdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.NumberPicker;

public class MainActivity2 extends AppCompatActivity {

    private static final String PASSWORD = "password";

    private NumberPicker numberPicker1;
    private NumberPicker numberPicker2;
    private NumberPicker numberPicker3;

    private Button openButton;
    private Button changePasswordButton;

    private SharedPreferences myPasswordDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initData();
        addEventListener();
    }

    private void initData() {
        numberPicker1 = findViewById(R.id.numberPicker1);
        numberPicker2 = findViewById(R.id.numberPicker2);
        numberPicker3 = findViewById(R.id.numberPicker3);

        openButton = findViewById(R.id.openButton);
        changePasswordButton = findViewById(R.id.changePasswordButton);

        myPasswordDB = getSharedPreferences(PASSWORD, MODE_PRIVATE);
    }

    private void addEventListener() {

        // 다이어리 들어가기를 눌렀을때
        openButton.setOnClickListener(v -> {

            // 내 비밀번호와 사용자가 선택한 번호가 같으면
            if (myPasswordDB.getString(PASSWORD, "000").equals(getNowNumberPickerData())) {

                // 화면 전환 해주기
                Intent intent = new Intent(this, DiaryActivity.class);
                startActivity(intent);

            }
        });

        changePasswordButton.setOnClickListener(v -> {

        });

    }

    private String getNowNumberPickerData() {
        String numberPicker = "" + numberPicker1.getValue()
                + numberPicker2.getValue()
                + numberPicker3.getValue();
        return numberPicker;
    }

}