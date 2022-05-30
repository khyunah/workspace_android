package com.example.myretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myretrofit.repository.models.RetrofitService;
import com.example.myretrofit.repository.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// 모델 분리
// 비즈니스 로직을 처리하는 부분을 분리했다.
public class MainActivity extends AppCompatActivity {

    Retrofit retrofit;
    RetrofitService service;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.temp);

        // 1. retrofit 객체 초기화
        retrofit = new Retrofit.Builder()   // Builder 패턴으로 설계되어 있음. ( Builder 패턴 : 생성자에 매개변수 순서상관없이 필요한것만 편하게 사용가능한 것 )
                .baseUrl("https://jsonplaceholder.typicode.com/")  // url 객체 만들어주는 것. base 라서 uri 는 생략하지만 마지막에 / 써주기
                .addConverterFactory(GsonConverterFactory.create()) // Gson 라이브러리로 파싱하는 작업을 자동으로 해주는 녀석
                .build();   // 객체를 리턴하는 마무리 필수

        // 2. 비즈니스 로직 만들어야함
        // todo 데이터를 들고 오는 것
        // post 데이터를 들고 오는 것
        // users 데이터를 들고 오는 것
        // 초기화된 레트로핏 오브젝트와 비지니스 로직인 인터페이스를 밑의 코드로 자동으로 연결
        service = retrofit.create(RetrofitService.class);    // create() : 메모리에 올리는 역할

        service.getTodos().enqueue(new Callback<ArrayList<Todo>>() {    // enqueue() : 비동기로 통신을 할거야
            @Override
            public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {

                Log.d("TAG", response.isSuccessful() + " : ");
                Log.d("TAG", response.message() + " : ");

                if (response.isSuccessful()) {

                    Todo todo = response.body().get(0); // List 로 받지만 Type 변환 안해도됨

                    Log.d("TAG", "userId : " + todo.userId);

                    textView.setText(todo.completed);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {
                Log.d("TAG", "실패 : " + t.getMessage());
            }
        });
    }
}