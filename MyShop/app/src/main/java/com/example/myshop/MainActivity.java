package com.example.myshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.itemRecycleViewContainer);
        recyclerView.setAdapter(new ItemAdapter(Item.getSampleData(), this));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}