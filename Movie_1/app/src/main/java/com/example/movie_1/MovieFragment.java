package com.example.movie_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movie_1.databinding.FragmentMovieBinding;

public class MovieFragment extends Fragment {

    // 안드로이드에서 자동으로 만들어준 클래스
    private FragmentMovieBinding binding;
    private static final String TAG =  MovieFragment.class.getName();

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // findViewById 를 대체하기 위해 ViewBinding 활용
        binding = FragmentMovieBinding.inflate(inflater, container, false); // 어느 레이아웃을 어디에
        return binding.getRoot();
    }
}