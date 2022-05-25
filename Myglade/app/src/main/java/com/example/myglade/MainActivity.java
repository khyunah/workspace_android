package com.example.myglade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView imageView1 = findViewById(R.id.gImageView1);
        ImageView imageView2 = findViewById(R.id.gImageView2);
        ImageView imageView3 = findViewById(R.id.gImageView3);
        ImageView imageView4 = findViewById(R.id.gImageView4);
        ImageView imageView5 = findViewById(R.id.gImageView5);
        ImageView imageView6 = findViewById(R.id.gImageView6);

        Glide.with(this)
                .load("https://picsum.photos/seed/picsum/200/300")
                .circleCrop()
                .into(imageView1);

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2022/05/20/13/29/dogs-7209506__340.jpg")
                .circleCrop()
                .into(imageView2);

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2022/04/26/20/37/coffee-7159137__340.jpg")
                .circleCrop()
                .into(imageView3);

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2022/05/11/13/55/nature-7189418__340.jpg")
                .circleCrop()
                .into(imageView4);

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2022/02/08/06/18/bird-7000837__340.jpg")
                .circleCrop()
                .into(imageView5);

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2022/05/17/01/31/marriage-7201450__340.jpg")
                .circleCrop()
                .into(imageView6);

    }
}


// 피카소와 글라이드를 많이 쓴다. 기능은 글라이드가 좀 더 많음.

// View 를 넣어줘야 하는데, 메인액티비티가 뷰 이다.

// 프로젝트에 있는 이미지를 라운드 처리하는 라이브러리를 사용해서 circleCrop 처리를 한다면
// 이미지가 적용이 안됨.