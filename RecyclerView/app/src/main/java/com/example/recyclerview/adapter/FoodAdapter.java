package com.example.recyclerview.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.recyclerview.R;
import com.example.recyclerview.interfaces.OnFoodItemClickListener;
import com.example.recyclerview.models.Food;

import java.util.ArrayList;

// 뷰 홀더 만들기
// 2. RecyclerView.Adapter<어떤 클래스> 상속받기
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    // 멤버변수
    ArrayList<Food> list;
    // 어느 뷰에서 쓸지 정보를 받을 context
    Context context;
    OnFoodItemClickListener onFoodItemClickListener;

    public FoodAdapter(ArrayList<Food> list, Context context, OnFoodItemClickListener onFoodItemClickListener) {
        this.list = list;
        this.context = context;
        this.onFoodItemClickListener = onFoodItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // new ViewHolder 생성해 라는 메소드

        View itemView = LayoutInflater
                .from(context)
                .inflate(R.layout.item_food, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // 화면과 연결
        // 데이터 맵핑을 하는 곳
        Log.d("TAG", "position : " + position);
        Food food = list.get(position);

        Glide.with(context)
                .load(food.getThumbnail())
                // 라운드 처리
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.thumbnail);

        holder.titleTextView.setText(food.getTitle());
        holder.subTitleTextView.setText(food.getSubTitle());
        holder.detailTextView.setText(food.getDetail());
    }

    @Override
    public int getItemCount() {
        // 몇개의 아이템이 있는지 알려줘야한다.
        // 그래야 알아서 스크롤뷰를 그릴지말지 하니깐
        return list.size();
    }

    // 1. 내부 클래스 만들기 ( RecyclerView.ViewHolder 상속 받기 )
    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView thumbnail;
        TextView titleTextView;
        TextView subTitleTextView;
        TextView detailTextView;

        // 부모클래스에 생성자가 있어서 강제적으로 생성자를 생성해야 한다.
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            thumbnail = itemView.findViewById(R.id.thumbnailImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            subTitleTextView = itemView.findViewById(R.id.subTitleTextView);
            detailTextView = itemView.findViewById(R.id.detailTextView);

            itemView.setOnClickListener(view -> {

                Toast.makeText(view.getContext(),
                        "TEST" + getLayoutPosition(),
                        Toast.LENGTH_SHORT).show();

                // 콜백 메서드 호출
                onFoodItemClickListener.onItemClicked(itemView, getLayoutPosition());
            });
        }
    } // end of inner class
}
