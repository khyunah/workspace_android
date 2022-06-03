package com.example.movie_1_1.network;

import com.example.movie_1_1.models.Movie;
import com.example.movie_1_1.models.Yts;
import com.example.movie_1_1.utils.StaticCode;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieHttpsService {

    Retrofit RETROFIT = new Retrofit.Builder()
            .baseUrl(StaticCode.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("list_movies.json/")
    Call<Yts> getYtsInfo(
            @Query("sort_by") String sort_by,
            @Query("limit") int limit,
            @Query("page") int page
    );
}
