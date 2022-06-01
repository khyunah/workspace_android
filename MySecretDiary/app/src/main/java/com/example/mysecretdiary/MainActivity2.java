package com.example.mysecretdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

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

        numberPicker1.setMaxValue(9);
        numberPicker1.setMinValue(0);
        numberPicker2.setMaxValue(9);
        numberPicker2.setMinValue(0);
        numberPicker3.setMaxValue(9);
        numberPicker3.setMinValue(0);

        openButton = findViewById(R.id.openButton1);
        changePasswordButton = findViewById(R.id.changePasswordButton);

        myPasswordDB = getSharedPreferences(PASSWORD, Context.MODE_PRIVATE);
    }

    private void addEventListener() {

        // 다이어리 들어가기를 눌렀을때
        openButton.setOnClickListener(v -> {
            Toast.makeText(this, "들어가기 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();

            String getNowNumberPickerData = getNowNumberPickerData();

            // 내 비밀번호와 사용자가 선택한 번호가 같으면
            if (myPasswordDB.getString(PASSWORD, "000").equals(getNowNumberPickerData)) {
                Toast.makeText(this, "비밀번호가 일치합니다.", Toast.LENGTH_SHORT).show();
                // 화면 전환 해주기
                Intent intent = new Intent(this, DiaryActivity2.class);
                startActivity(intent);

            }
        });

        changePasswordButton.setOnClickListener(v -> {
            SharedPreferences.Editor editor = myPasswordDB.edit();
            editor.putString(PASSWORD, getNowNumberPickerData());
            editor.apply();
        });

    }

    private String getNowNumberPickerData() {
        String numberPicker = "" + numberPicker1.getValue()
                + numberPicker2.getValue()
                + numberPicker3.getValue();
        return numberPicker;
    }

}