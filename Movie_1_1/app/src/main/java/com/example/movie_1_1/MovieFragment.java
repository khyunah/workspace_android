package com.example.movie_1_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movie_1_1.network.MovieHttpsService;

public class MovieFragment extends Fragment {

    private MovieHttpsService movieHttpsService;

    public MovieFragment() {

    }

    public static MovieFragment newInstance() {
        MovieFragment fragment = new MovieFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieHttpsService =
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_movie, container, false);
    }
}