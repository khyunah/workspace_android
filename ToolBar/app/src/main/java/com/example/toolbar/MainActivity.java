package com.example.toolbar;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    // 값을 돌려받을때 미리 만들어 줘야한다.
    // 콜백 메서드
    ActivityResultLauncher<Intent> startActivityResult = registerForActivityResult(

            // StartActivityForResult() : 레거시에서 사용하던 메소드이며, 그것은 Deprecated 되었고
            // 그걸 토대로 다시 만들어낸 메소드이다.
            // startActivityResult() 메소드가 실행되었던 곳으로 돌아온다.
            // 돌아오며 결과값을 전달 받는다.
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                Log.d("TAG", "comeback");
                if (result.getResultCode() == Activity.RESULT_OK) {
                    // 정상 동작
                    Intent data = result.getData();
                    int returnValue = data.getIntExtra("result",0);
                    textView.setText(returnValue + "");
                } else {
                    // 실패
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolBar);

        // 이 툴바를 셋팅할거야 라고 선언하는 것.
        // 선언하지 않으면 효과 적용이 안됨.
        setSupportActionBar(toolbar);

        textView = findViewById(R.id.tempTextView);
    }

    // inflater : 메모리에 올려주는 역할
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        // inflate : 메모리에 올려주는 메소드
        inflater.inflate(R.menu.menu_toolbar, menu);  // R,리소스 . menu 패키지 . 파일이름 . 오브젝트 ( 뭔가 효과를 줄떄 사용하기 위해 )
        return true;
    }

    // 뭔가 눌러졌을때 동작 하는 메소드 ( 콜백 개념 )
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {  // 메뉴아이템이 전부 넘어온다

        switch (item.getItemId()) {
            case R.id.menuItem1:
                Intent intent = new Intent(this, SubActivity.class);

                // 값을 넘겨줄때
                intent.putExtra("value1", 10);

//                startActivity(intent);    // 값을 돌려받지 않을때 사용

                // 값을 돌려받아야 할때 사용
                startActivityResult.launch(intent);

                Log.d("TAG", "1 번 클릭");
                break;
            case R.id.menuItem2:
                Log.d("TAG", "2 번 클릭");
                break;
            case R.id.menuItem3:
                Log.d("TAG", "3 번 클릭");
                break;
        }

        return true;    // true 여야 이벤트 리스너가 동작한다.
    }
}