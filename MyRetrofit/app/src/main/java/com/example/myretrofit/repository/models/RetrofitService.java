package com.example.myretrofit.repository.models;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    // 주소 : https://jsonplaceholder.typicode.com/todos
    @GET("todos")
    Call<ArrayList<Todo>> getTodos();
}
