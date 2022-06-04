package com.example.movie_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.movie_1_1.databinding.ActivityDetailBinding;
import com.example.movie_1_1.models.Movie;

public class DetailActivity extends AppCompatActivity {

    private Movie movie;
    private ActivityDetailBinding activityDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailBinding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(activityDetailBinding.getRoot());

        if (getIntent() != null) {
            movie = (Movie) getIntent().getSerializableExtra("movie");
        }

        setData();
    }

    private void setData() {
        activityDetailBinding.detailMovieTitleTextView.setText(movie.getTitle());
        activityDetailBinding.detailMovieYearTextView.setText("개봉년도 : " + movie.getYear());
        activityDetailBinding.detailMovieRuntimeTextview.setText("상영시간 : " + movie.getRuntime());
        activityDetailBinding.detailMovieSynopsisTextView.setText("줄거리 \n" + movie.getSynopsis());

        Glide.with(this)
                .load(movie.getBackground_image())
                .transform(new CenterCrop())
                .into(activityDetailBinding.detailMovieBackgroundImageView);

        Glide.with(this)
                .load(movie.getMedium_cover_image())
                .transform(new CenterCrop())
                .into(activityDetailBinding.detailMovieImageView);
    }
}