package com.example.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar calendarToolbar = findViewById(R.id.calendarToolbar);
        setSupportActionBar(calendarToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_calendar_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.calendar_today:
                Toast.makeText(this, "첫번째 아이콘이 눌러졌습니다.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.check:
                Toast.makeText(this, "두번째 아이콘이 눌러졌습니다.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.favorite:
                Toast.makeText(this, "세번째 아이콘이 눌러졌습니다.", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}