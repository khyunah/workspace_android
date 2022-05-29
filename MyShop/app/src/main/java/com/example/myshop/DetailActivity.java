package com.example.myshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Item getItem = (Item)intent.getSerializableExtra("getItem");

        ImageView imageView = findViewById(R.id.imageView);
        Glide.with(this)
                .load(getItem.getImageUrl())
                .into(imageView);
    }
}