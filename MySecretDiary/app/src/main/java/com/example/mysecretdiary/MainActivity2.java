package com.example.mysecretdiary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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

    private boolean changePasswordMode = false;

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

            if(changePasswordMode){
                Toast.makeText(this, "비밀번호 변경중입니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            String getNowNumberPickerData = getNowNumberPickerData();

            // 내 비밀번호와 사용자가 선택한 번호가 같으면
            if (myPasswordDB.getString(PASSWORD, "000").equals(getNowNumberPickerData)) {
                Toast.makeText(this, "비밀번호가 일치합니다.", Toast.LENGTH_SHORT).show();
                // 화면 전환 해주기
                Intent intent = new Intent(this, DiaryActivity2.class);
                startActivity(intent);
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setTitle("실패")
                        .setMessage("비밀번호가 일치하지 않습니다.")
                        .setPositiveButton("확인", (dialog, which) -> {})
                        .show();
            }
        });

        changePasswordButton.setOnClickListener(v -> {

            String getNumberPicker = getNowNumberPickerData();

            if (changePasswordMode) {

                SharedPreferences.Editor editor = myPasswordDB.edit();
                editor.putString(PASSWORD, getNumberPicker);
                editor.apply();

                changePasswordMode = false;
                changePasswordButton.setBackgroundColor(Color.BLACK);

                Toast.makeText(this, "비밀번호가 변경되었습니다.", Toast.LENGTH_SHORT).show();

            } else {
                if (myPasswordDB.getString(PASSWORD, "000").equals(getNumberPicker)) {
                    changePasswordMode = true;
                    Toast.makeText(this, "변경할 비밀번호를 맞춰주세요.", Toast.LENGTH_SHORT).show();
                    changePasswordButton.setBackgroundColor(Color.RED);
                }
            }
        });
    }

    private String getNowNumberPickerData() {
        String numberPicker = "" + numberPicker1.getValue()
                + numberPicker2.getValue()
                + numberPicker3.getValue();
        return numberPicker;
    }
}