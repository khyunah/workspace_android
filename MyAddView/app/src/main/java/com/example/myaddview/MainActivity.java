package com.example.myaddview;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 각 컴포넌트 들을 한번에 들고올수 있게 xml 파일 들고올수 있는 LayoutInflater
        LayoutInflater inflater = LayoutInflater.from(this);    // 초기화 작업 ( new )와 같은 작업이다.

        // 뷰를 위치 시킬 컨테이너 가져오기
        LinearLayout container = findViewById(R.id.fruitContainer);

        // 샘플 데이터 가져오기
        ArrayList<Fruit> sampleData = Fruit.getFruits();

        // 샘플 데이터 넣기
        sampleData.forEach(fruit -> {

            // inflater 객체를 이용해서 xml 파일을 올리고 어디에 올릴지 설정.
            View itemView = inflater.inflate(R.layout.item_food, container, false);

            ImageView fruitImageView = itemView.findViewById(R.id.fruitImageView);
            TextView fruitNameTextView = itemView.findViewById(R.id.fruitNameTextView);
            TextView fruitPriceTextView = itemView.findViewById(R.id.fruitPriceTextView);
            TextView fruitCountTextView = itemView.findViewById(R.id.fruitCountTextView);

            fruitNameTextView.setText(fruit.name);
            fruitPriceTextView.setText(fruit.price);
            fruitCountTextView.setText(fruit.count);

            // 이미지 세팅
            Glide.with(this)
                    .load(fruit.imageUrl)
                    .centerCrop()
                    .into(fruitImageView);

            container.addView(itemView);

        });
    }
}