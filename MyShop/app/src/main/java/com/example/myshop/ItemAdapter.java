package com.example.myshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    ArrayList<Item> items = new ArrayList<>();
    Context context;

    public ItemAdapter(ArrayList<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // item_closet 이라는 xml 파일의 객체를 들고와서 설정 해준것.
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_closet, parent, false);
        return new MyViewHolder(itemView);
    }

    // 위 메소드에서 리턴된 값이 이 메소드의 holder 로 들어가게 된다.
    // 콜백으로 알아서 호출 되는 것.
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = items.get(position);

        Glide.with(context)
                .load(item.getImageUrl())
                .into(holder.itemImage);

        holder.storeName.setText(item.getStoreName());
        holder.name.setText(item.getName());
        holder.price.setText(item.getPrice());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        // 세팅을 해야하는 컴포넌트 타입으로 변수 선언
        ImageView itemImage;
        TextView storeName;
        TextView name;
        TextView price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.itemImageView);
            storeName = itemView.findViewById(R.id.storeNameTextView);
            name = itemView.findViewById(R.id.nameTextView);
            price = itemView.findViewById(R.id.priceTextView);

            itemView.setOnClickListener(view -> {
                Toast.makeText(view.getContext(), name + ", 품절", Toast.LENGTH_SHORT).show();
            });

        }
    }
}
