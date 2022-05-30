package com.example.myhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.myhttp.models.Photo;
import com.example.myhttp.models.Todo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnHttpConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHttpConnect = findViewById(R.id.btnHttpConnect);

        btnHttpConnect.setOnClickListener(view -> {
            // () -> : new Runnable
            new Thread(() -> {
                httpGetTest();
            }).start();
        });

//        try {
//            httpGetTest();
//        } catch(NetworkOnMainThreadException e){
//            Toast.makeText(this, "에러발생", Toast.LENGTH_SHORT).show();
//        }

        // 기본적으로 안드로이드는 메인스레드 (원 스레드) 만 작동을한다.
        // 메인스레드는 UI를 그리는데 집중하기때문에 예외가 발생한다.
        // 스레드를 만들어서 사용해줘야 한다.
    }

    private void httpGetTest() {
        // https://jsonplaceholder.typicode.com/todos/1
//        String urlString = "https://jsonplaceholder.typicode.com/todos";
        String urlString = "https://jsonplaceholder.typicode.com/photos";

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            // connection.connect(); // : 자바에서는 해줬지만 안드로이드는 안해줘도 알아서 전송됨

            // 참고 ( get 방식에는 안써도 됨 )
            // 헤더에 쓰는것
            // connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {    // 200
                // 통신 성공 코드

                // connection 에 읽어올때 encoding 을 설정할 수 있다.
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        connection.getInputStream(),
                        "UTF-8"
                ));

                /* 1 */
                // 한 라인씩 읽을수 있다.
                // 줄을 띄어주는 역할이 없기 때문에 + "\n" 처리
                String line = null;
                StringBuffer sb = new StringBuffer();
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                Log.d("TAG", sb.toString());

                /* 2 */
                // Gson 라이브러리 사용
                // 1. DTO 만들어야함.

                // 문자열을 하나의 오브젝트로 변환하기
//                Todo todo1 = new Gson().fromJson(reader, Todo.class);
//                Log.d("TAG", todo1.title);

                // 문자열을 배열타입으로 변환하기
                Todo[] todos = new Gson().fromJson(reader, Todo[].class);
//                Log.d("TAG", todos.toString());

                // 문자열을 리스트타입으로 변환하기
                Type todoListType = new TypeToken<ArrayList<Todo>>() {}.getType();
                ArrayList<Todo> todoList = new Gson().fromJson(reader, todoListType);

                for (Todo t : todoList) {
                    Log.d("TAG", t.userId + " : userId");
                    Log.d("TAG", t.title + " : title");
                }

                Type photoListType = new TypeToken<ArrayList<Photo>>() {
                }.getType();
                ArrayList<Photo> photoList = new Gson().fromJson(reader, photoListType);
                for (Photo p : photoList) {
                    Log.d("TAG", p.title + " : title");
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}