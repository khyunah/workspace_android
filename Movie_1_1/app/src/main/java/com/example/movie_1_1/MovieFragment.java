package com.example.movie_1_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.movie_1_1.adapter.MovieAdapter;
import com.example.movie_1_1.databinding.FragmentMovieBinding;
import com.example.movie_1_1.models.Movie;
import com.example.movie_1_1.models.Yts;
import com.example.movie_1_1.network.MovieHttpsService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieFragment extends Fragment {

    private MovieHttpsService movieHttpsService;
    private MovieAdapter movieAdapter;
    private FragmentMovieBinding fragmentMovieBinding;

    private int page = 1;

    public MovieFragment() {

    }

    public static MovieFragment newInstance() {
        MovieFragment fragment = new MovieFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 메모리에 올리는 과정임.
        movieHttpsService = MovieHttpsService.RETROFIT.create(MovieHttpsService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentMovieBinding = FragmentMovieBinding.inflate(inflater, container, false);

        setupRecyclerView();

        requestMovieData();

        return fragmentMovieBinding.getRoot();
    }

    // 통신
    private void requestMovieData() {
        movieHttpsService.getYtsInfo("rating", 10, page).enqueue(new Callback<Yts>() {
            @Override
            public void onResponse(Call<Yts> call, Response<Yts> response) {
                if (response.isSuccessful()) {
                    // 무비 데이터를 리스트에 담은 것.
                    ArrayList<Movie> list = response.body().getData().getMovies();

                    // 리스트를 어댑터에 전달 해줘야한다.
                    movieAdapter.addList(list);

                }
            }

            @Override
            public void onFailure(Call<Yts> call, Throwable t) {

            }
        });
    }

    private void setupRecyclerView() {
        movieAdapter = new MovieAdapter();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        fragmentMovieBinding.movieContainer.setAdapter(movieAdapter);
        fragmentMovieBinding.movieContainer.setLayoutManager(layoutManager);


    }

}