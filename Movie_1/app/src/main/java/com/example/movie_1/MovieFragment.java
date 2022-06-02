package com.example.movie_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movie_1.databinding.FragmentMovieBinding;
import com.example.movie_1.models.Movie;
import com.example.movie_1.repository.MovieService;

import java.util.List;

public class MovieFragment extends Fragment {

    // 안드로이드에서 자동으로 만들어준 클래스
    private FragmentMovieBinding binding;
    private static final String TAG =  MovieFragment.class.getName();

    // 플래그먼트가 메모리에 올라가면 여기서 통신을 요청
    private MovieService movieService;

    public MovieFragment() {
        // Required empty public constructor
    }

    public static MovieFragment newInstance() {
        MovieFragment fragment = new MovieFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieService = MovieService.retrofit.create(MovieService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // findViewById 를 대체하기 위해 ViewBinding 활용
        binding = FragmentMovieBinding.inflate(inflater, container, false); // 어느 레이아웃을 어디에

        // 리사이클러뷰 만들어주기

        return binding.getRoot();
    }

    // 통신해서 JSON 받은 다음에 매개변수로 데이터를 넘길 예정
    private void setupRecyclerView(List<Movie> movieList){
        // 1. 어댑터

        // 2. 매니저

        // 3. xml 파일에 선언한 리사이클러뷰에 세팅
    }
}