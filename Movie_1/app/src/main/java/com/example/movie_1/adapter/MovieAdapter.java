package com.example.movie_1.adapter;

// 내부 클래스 먼저 만들기

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie_1.R;

public class MovieAdapter {


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
    } // end of inner class
}
