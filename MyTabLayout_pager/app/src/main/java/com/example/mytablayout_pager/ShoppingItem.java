package com.example.mytablayout_pager;

import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class ShoppingItem {
    private String itemImage;
    private String itemName;

    public ShoppingItem(String itemImage, String itemName) {
        this.itemImage = itemImage;
        this.itemName = itemName;
    }

    public String getItemImage(){
        return itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public static ArrayList<ShoppingItem> getData() {
        ArrayList<ShoppingItem> shoppingItems = new ArrayList<>();

        shoppingItems.add(new ShoppingItem("https://cdn.pixabay.com/photo/2022/05/09/17/08/mute-swan-7185076__480.jpg","아이템1"));
        shoppingItems.add(new ShoppingItem("https://cdn.pixabay.com/photo/2022/05/09/17/08/mute-swan-7185076__480.jpg","아이템1"));
        shoppingItems.add(new ShoppingItem("https://cdn.pixabay.com/photo/2022/05/09/17/08/mute-swan-7185076__480.jpg","아이템1"));
        shoppingItems.add(new ShoppingItem("https://cdn.pixabay.com/photo/2022/05/09/17/08/mute-swan-7185076__480.jpg","아이템1"));
        shoppingItems.add(new ShoppingItem("https://cdn.pixabay.com/photo/2022/05/09/17/08/mute-swan-7185076__480.jpg","아이템1"));
        shoppingItems.add(new ShoppingItem("https://cdn.pixabay.com/photo/2022/05/09/17/08/mute-swan-7185076__480.jpg","아이템1"));
        shoppingItems.add(new ShoppingItem("https://cdn.pixabay.com/photo/2022/05/09/17/08/mute-swan-7185076__480.jpg","아이템1"));
        shoppingItems.add(new ShoppingItem("https://cdn.pixabay.com/photo/2022/05/09/17/08/mute-swan-7185076__480.jpg","아이템1"));

        return shoppingItems;
    }

}
