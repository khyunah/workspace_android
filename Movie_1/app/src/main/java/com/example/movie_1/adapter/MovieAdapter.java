package com.example.movie_1.adapter;

// 내부 클래스 먼저 만들기

import android.nfc.Tag;
import android.util.Log;
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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.movie_1.R;
import com.example.movie_1.interfaces.OnMovieItemClicked;
import com.example.movie_1.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<Movie> list = new ArrayList<>();
    private OnMovieItemClicked onMovieItemClicked;

    public void setOnMovieItemClicked(OnMovieItemClicked onMovieItemClicked) {
        this.onMovieItemClicked = onMovieItemClicked;
    }

    // 통신을 배우기 전에 생성자에서 데이터를 전달 받아서 화면을 구성했었다.
    // 통신을 이용하면
    // 화면을 그리는 시점보다 데이터가 더 늦게 도달할 수도 있다.

    public void initItemList(List<Movie> list){
        this.list = list;
        notifyDataSetChanged();
        // notifyDataSetChanged() : 데이터가 변경되었을때 알려주는 그래서 다시 셋팅하는
    }

    public void addItem(List<Movie> addList){
        // list.size()부터 addList 를 넣어라
        this.list.addAll(list.size(), addList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_movie_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = list.get(position);
        // 여기에서 바로 세팅 할수도 있고
//        holder.titleTv.setText(movie.getTitle());
//        holder.ratingTv.setText(String.valueOf(movie.getRating())); // 소수점 자를때 Math.floor
//        holder.ratingBar.setRating((float) movie.getRating());
//
//        Glide.with(holder.posterIv.getContext())
//                .load(movie.getMediumCoverImage())
//                .placeholder(R.drawable.round_image)
//                .transform(new FitCenter(), new RoundedCorners(20))
//                .into(holder.posterIv);

        // 뷰홀더안에서 세팅 할수도 있음
        // 메서드 ( movie )

        holder.setItem(movie);
        holder.itemView.setOnClickListener(v -> {
            onMovieItemClicked.selectedItem(movie);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // inner static class
    // 뷰바인딩 : 뷰 결합이 되지 않음 ( 직접 해야한다. ) ㅡ> 단 방향
    // 데이터바인딩 : 양방향
    // 뷰 바인딩을 잘 쓰진 않고 이정도 양이면 데이터 바인딩을 사용하면 된다.
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        // itemView 에 선언한 데이터 타입들을 선언하고 생성 시점에 R.id.xxx 연결 해주면 된다.
        private View itemView;
        private ImageView posterIv;
        private TextView titleTv;
        private TextView ratingTv;
        private RatingBar ratingBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            posterIv = itemView.findViewById(R.id.posterIv);
            titleTv = itemView.findViewById(R.id.titleTv);
            ratingTv = itemView.findViewById(R.id.ratingTv);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }

        public void setItem(Movie movie){
            // 뷰홀더안에서 생성
            titleTv.setText(movie.getTitle());
            ratingTv.setText(String.valueOf(movie.getRating())); // 소수점 자를때 Math.floor
            ratingBar.setRating((float) movie.getRating());

            Glide.with(posterIv.getContext())
                    .load(movie.getMediumCoverImage())
                    .placeholder(R.drawable.round_image)
                    .transform(new FitCenter(), new RoundedCorners(20))
                    .into(posterIv);

            itemView.setOnClickListener(v -> {
                Log.d("TAG", " " + v.getContext());
            });
        }
    } // end of inner class
}
