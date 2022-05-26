package com.example.mytrip;

import androidx.appcompat.app.AppCompatActivity;

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

        LayoutInflater inflater = LayoutInflater.from(this);

        LinearLayout container = findViewById(R.id.container);

        ArrayList<Hotel> hotelSampleData = Hotel.getHotelData();

        hotelSampleData.forEach(hotel -> {

            View itemView = inflater.inflate(R.layout.item_hotel, container, false);

            ImageView hotelImageView = itemView.findViewById(R.id.hotelImageView);
            TextView hotelNameTextView = itemView.findViewById(R.id.hotelNameTextView);
            TextView hotelPriceTextView = itemView.findViewById(R.id.hotelPriceTextView);
            TextView hotelPlaceTextView = itemView.findViewById(R.id.hotelPlaceTextView);

            hotelNameTextView.setText(hotel.name);
            hotelPriceTextView.setText(hotel.price);
            hotelPlaceTextView.setText(hotel.place);

            Glide.with(this)
                    .load(hotel.image)
                    .centerCrop()
                    .into(hotelImageView);

            container.addView(itemView);

        });
    }
}