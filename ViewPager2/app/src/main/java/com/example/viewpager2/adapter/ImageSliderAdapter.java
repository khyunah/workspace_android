package com.example.viewpager2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.viewpager2.R;

import java.util.ArrayList;

// 1. 뷰 홀더 생성
public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> slideImage;

    public ImageSliderAdapter(Context context, ArrayList<String> slideImage) {
        this.context = context;
        this.slideImage = slideImage;
    }

    // ViewHolder 생성
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_image_slider, parent, false);
        return new ViewHolder(itemView);
    }

    // 화면에 들어갈 정보 입력
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 이미지 url 받아와서 적용 시키는 작업
        holder.bindSliderImage(slideImage.get(position));
    }

    // 몇개를 보일지
    @Override
    public int getItemCount() {
        return slideImage.size();
    }

    // RecyclerView : findViewById 를 줄이기 위해사용
    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageSlider);
        }

        public void bindSliderImage(String imageURL) {
            Glide.with(context)
                    .load(imageURL)
                    .centerCrop()
                    .into(imageView);
        }
    } // end of inner class
}
