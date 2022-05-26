package com.example.myglade;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ImageView myImageView1 = findViewById(R.id.myImageView1);
        ImageView myImageView2 = findViewById(R.id.myImageView2);
        ImageView myImageView3 = findViewById(R.id.myImageView3);
        ImageView myImageView4 = findViewById(R.id.myImageView4);
        ImageView myImageView5 = findViewById(R.id.myImageView5);
        ImageView myImageView6 = findViewById(R.id.myImageView6);
        ImageView myImageView7 = findViewById(R.id.myImageView7);
        ImageView myImageView8 = findViewById(R.id.myImageView8);
        ImageView myImageView9 = findViewById(R.id.myImageView9);
        ImageView myImageView10 = findViewById(R.id.myImageView10);

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2015/06/25/17/56/people-821624__340.jpg")
                .circleCrop()
                .into(myImageView1);

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2016/12/27/15/54/couple-1934204__340.jpg")
                .circleCrop()
                .into(myImageView2);

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2016/05/03/16/10/morning-1369446__340.jpg")
                .circleCrop()
                .into(myImageView3);

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2018/01/21/14/16/woman-3096664__340.jpg")
                .circleCrop()
                .into(myImageView4);

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2017/02/15/12/12/cat-2068462__340.jpg")
                .circleCrop()
                .into(myImageView5);

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2016/03/27/07/08/man-1282232__340.jpg")
                .circleCrop()
                .into(myImageView6);

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2016/11/23/17/25/woman-1853939__340.jpg")
                .circleCrop()
                .into(myImageView7);

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2016/11/29/13/14/attractive-1869761__340.jpg")
                .circleCrop()
                .into(myImageView8);

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2017/08/06/20/11/wedding-2595862__340.jpg")
                .circleCrop()
                .into(myImageView9);

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2014/07/11/22/05/baby-390555__340.jpg")
                .circleCrop()
                .into(myImageView10);

    }
}
