package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview.adapter.FoodAdapter;
import com.example.recyclerview.models.Food;

import java.util.ArrayList;

/*
 * Recycler View
 *
 * 장점
 * ListView 의 개선판이다.
 *   - ViewHolder 를 포함한다. ( findViewById가 메모리 낭비가 심해서 그것을 줄이기 위한 방법 )
 *   - 쇼핑몰 사이트와 같이 모든 데이터를 한번에 로드하기엔 메모리 낭비가 심한데 필요한 만큼만 로드해줄수 있다.
 * 디자인 변경에 유연하다.
 * LayoutManager, Adapter 클래스 가 필요하다.
 *
 * */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 통신 JSON
        ArrayList<Food> listSample = Food.getSampleData();

        // 리사이클러뷰를 사용하는 방법
        // 1. Adapter 클래스를 직접 생성해야 한다.
        // 2. LayoutManager 를 생성해서 Adapter 클래스와 연결해야 한다.
        //      new LinearLayoutManager(this)

        // 어뎁터 디자인 패턴
        // 뷰와 데이터를 연결시키기 위한 방법 중 하나.

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new FoodAdapter(Food.getSampleData(), this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}