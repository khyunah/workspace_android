package com.example.movie_1_1.adapter;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.example.movie_1_1.R;
import com.example.movie_1_1.models.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private ArrayList<Movie> movieList = new ArrayList<>();
    private Context context;

    public void addList(ArrayList<Movie> addList){
        // 지금 무비리스트의 사이즈부터 addList 를 더하는 것.
        this.movieList.addAll(movieList.size(), addList);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // parent.getContext() : MyHolder 에서 RecyclerView 를 상속 받았기 때문에
        // 내부적으로 내가 그려넣은 fragment_movie.xml 파일을 알고 있다.
        // 그래서 parent 가 해당 뷰 그룹을 가르킨다.
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = movieList.get(position);

        Glide.with(context)
                .load(movie.getMedium_cover_image())
                .placeholder(R.drawable.image_loding)
                .transform(new FitCenter())
                .into(holder.movieImageView);

        holder.movieTitleTextView.setText(movie.getTitle());
        holder.ratingTextView.setText(String.valueOf(movie.getRating()));
        holder.ratingBar.setRating((float) movie.getRating());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView movieTitleTextView;
        private TextView ratingTextView;
        private RatingBar ratingBar;
        private ImageView movieImageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            movieTitleTextView = itemView.findViewById(R.id.movieTitleTextView);
            ratingTextView = itemView.findViewById(R.id.ratingTextView);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            movieImageView = itemView.findViewById(R.id.movieImageView);

        }
    }
}
