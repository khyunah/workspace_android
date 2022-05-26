package com.example.myplagment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class BottomIconActivity extends AppCompatActivity {

    private HomeFragment homeFragment;
    private PlaceFragment placeFragment;
    private ChatFragment chatFragment;

    private ImageView iconHome;
    private ImageView iconPlace;
    private ImageView iconChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_icon);

        iconHome = findViewById(R.id.iconHome);
        iconPlace = findViewById(R.id.iconPlace);
        iconChat = findViewById(R.id.iconChat);

        iconHome.setOnClickListener(view -> {
            homeFragment = new HomeFragment();

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            transaction.replace(R.id.viewContainer, homeFragment);
            transaction.commit();

            Toast.makeText(this, "홈 버튼이 눌러졌습니다.", Toast.LENGTH_SHORT).show();
        });

        iconPlace.setOnClickListener(view -> {
            placeFragment = new PlaceFragment();

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            transaction.replace(R.id.viewContainer, placeFragment);
            transaction.commit();

            Toast.makeText(this, "위치 버튼이 눌러졌습니다.", Toast.LENGTH_SHORT).show();
        });

        iconChat.setOnClickListener(view -> {
            chatFragment = new ChatFragment();

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            transaction.replace(R.id.viewContainer, chatFragment);
            transaction.commit();

            Toast.makeText(this, "채팅 버튼이 눌러졌습니다.", Toast.LENGTH_SHORT).show();
        });
    }
}