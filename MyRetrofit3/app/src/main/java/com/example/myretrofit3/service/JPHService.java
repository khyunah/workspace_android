package com.example.myretrofit3.service;

import com.example.myretrofit3.models.request.ReqPostDto;
import com.example.myretrofit3.models.response.ResponsePostDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

// https://jsonplaceholder.typicode.com/posts
public interface JPHService {
    /* 1 */
    // 레트로핏 초기화
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    /* 2 */
    // https://jsonplaceholder.typicode.com/posts/{id}
    @GET("posts/{id}")
    Call<ResponsePostDto> post(@Path("id") int id);

    /* 3 */
    // https://jsonplaceholder.typicode.com/posts
    @GET("posts")
    Call<List<ResponsePostDto>> postList();

    /* 4 */
    // https://jsonplaceholder.typicode.com/posts
    // HTTP 메세지 바디 부분에 데이터를 넣어서 서버에 전달한다. ( MIME TYPE : JSON )
    // 우리의 데이터가 잘 전달 되었다면 서버측에서는 응답값을 보내준다.
    // 값을 보낼때 어떻게 데이터를 보낼지 설계 해야 한다.
    @POST("posts")
    Call<ResponsePostDto> createPost(@Body ReqPostDto reqPostDto);

    /* 5 */
    // https://jsonplaceholder.typicode.com/posts/{postId}
    // 수정하기
    @PUT("posts/{postId}")
    Call<ResponsePostDto> updatePost(@Path("postId") int postId, @Body ReqPostDto reqPostDto);

    /* 6 */
    // https://jsonplaceholder.typicode.com/posts/{postId}
    // Delete 는 응답을 받지않을때도 있다. 그때는 <Void> 써주기 ( 보통 응답을 받기는 하지만 한번 써보는 것 )
    @DELETE("posts/{postId}")
    Call<Void> deletePost(@Path("postId") int postId);

    /* 7 */
    // https://jsonplaceholder.typicode.com/posts/{userId}
    @GET("posts/{userId}")
    Call<List<ResponsePostDto>> searchByUserId(@Path("userId") int userId);
}
