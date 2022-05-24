package com.example.lottogame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    // 보통 클래스 이름으로 많이 사용한다.
    private static final String TAG = MainActivity.class.getName();

    private Button addBtn;
    private Button initBtn;
    private Button runBtn;

    private NumberPicker numberPicker;

    private ArrayList<TextView> numberTextViewList = new ArrayList<>();
    private Set<Integer> pickerNumberSet = new HashSet<>();

    private boolean didRun = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        addEventListener();
        getRandomNumber();
//        Log.d(TAG, "getRandomNumber() : " + getRandomNumber());
    }

    private void initData() {
        addBtn = findViewById(R.id.addButton);
        initBtn = findViewById(R.id.initButton);
        runBtn = findViewById(R.id.runButton);

        numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(45);

        numberTextViewList.add(findViewById(R.id.textView1));
        numberTextViewList.add(findViewById(R.id.textView2));
        numberTextViewList.add(findViewById(R.id.textView3));
        numberTextViewList.add(findViewById(R.id.textView4));
        numberTextViewList.add(findViewById(R.id.textView5));
        numberTextViewList.add(findViewById(R.id.textView6));
    }

    private void addEventListener() {
        runBtn.setOnClickListener(view -> {

            if (!didRun) {
                // 랜덤으로 list 넘어온 것 , set 계열의 사용자가 선택한 번호
                List<Integer> list = getRandomNumber();
                list.addAll(pickerNumberSet);
                Collections.sort(list);

                didRun = true;

                // xml 출력
                for (int i = 0; i < list.size(); i++) {
                    numberTextViewList.get(i).setText(String.valueOf(list.get(i)));
                    numberTextViewList.get(i).setVisibility(View.VISIBLE);

                    // 색상다르게 하기
                    numberTextViewList.get(i).setBackground(setTextViewBackground(list.get(i)));
                }
            } else {
                Toast.makeText(this, "초기화 후에 시도하세요.", Toast.LENGTH_SHORT).show();
            }

        });

        addBtn.setOnClickListener(view -> {
            if (didRun) {
                Toast.makeText(this, "초기화 후에 시도하세요.", Toast.LENGTH_SHORT).show();
                return;
            }
            // NumberPicker 현재 값을 불러온다.
            int selectedNumber = numberPicker.getValue();
            Log.d(TAG, selectedNumber + "");

            // 번호는 5개까지 선택 가능
            if (pickerNumberSet.size() >= 5) {
                Toast.makeText(this, "번호는 5개까지 선택가능 합니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            // 똑같은 번호 선택시 예외 처리
            if (pickerNumberSet.contains(selectedNumber)) {
                Toast.makeText(this, "이미 선택한 번호 입니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            TextView textView = numberTextViewList.get(pickerNumberSet.size());
            textView.setVisibility(View.VISIBLE);
            textView.setText(String.valueOf(selectedNumber));


            pickerNumberSet.add(selectedNumber);
            Log.d(TAG, "addBtn 클릭 ! ");

        });

        initBtn.setOnClickListener(view -> {
            didRun = false;
            pickerNumberSet.clear();
            for (TextView tv : numberTextViewList) {
                tv.setVisibility(View.GONE);
            }
            Log.d(TAG, "initBtn 클릭 ! ");
        });
    }

    private List<Integer> getRandomNumber() {
        ArrayList<Integer> list = new ArrayList<>();

        // 1 ~ 45 번 까지 미리 만들어 두기
        for (int i = 1; i < 46; i++) {
            // 사용자가 선택한거랑 중복 검사
            if (pickerNumberSet.contains(i)) {
                continue;
            }
            // 자료구조에 담기 !
            list.add(i);
        }

        Collections.shuffle(list);

        // 사용자가 추가한 객수만큼 빼주기
        return list.subList(0, 6 - pickerNumberSet.size());
    }

    // 숫자 크기에 따라서 배경을 다르게 만듬
    private Drawable setTextViewBackground(int number) {
        Drawable drawable = null;
        if (number >= 20) {
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background2);
        } else {
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background1);
        }

        return drawable;
    }
}