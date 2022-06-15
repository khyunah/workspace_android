package com.example.ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.ex.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEventListener();
    }

    public void addEventListener(){
        binding.buttonContainer.addOnButtonCheckedListener((group, checkedId, isChecked) -> {

            if(isChecked){
                switch (checkedId){
                    case 0:
                        Log.d("TAG", "1번 버튼 눌러짐");
                        break;
                    case 1:
                        Log.d("TAG", "2번 버튼 눌러짐");
                        break;
                    case 2:
                        Log.d("TAG", "3번 버튼 눌러짐");
                        break;
                    case 3:
                        Log.d("TAG", "4번 버튼 눌러짐");
                        break;
                    case 4:
                        Log.d("TAG", "5번 버튼 눌러짐");
                        break;
                    case 5:
                        Log.d("TAG", "6번 버튼 눌러짐");
                        break;
                    case 6:
                        Log.d("TAG", "7번 버튼 눌러짐");
                        break;
                }
            }

        });
    }
}