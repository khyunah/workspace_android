package com.example.myshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myshop.interfaces.OnItemClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.itemRecycleViewContainer);
        recyclerView.setAdapter(new ItemAdapter(Item.getSampleData(), this, new OnItemClickListener() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent intent = new Intent(getApplication(), DetailActivity.class);
                intent.putExtra("image", Item.getSampleData().get(position).getImageUrl());
                startActivity(intent);
            }
        }));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}