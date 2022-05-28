package com.example.mytablayout_pager;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class ShoppingItem {
    private Drawable itemImage;
    private String itemName;

    public ShoppingItem(Drawable itemImage, String itemName) {
        this.itemImage = itemImage;
        this.itemName = itemName;
    }

    public Drawable getItemImage(){
        return itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public static ArrayList<ShoppingItem> getData() {
        ArrayList<ShoppingItem> shoppingItems = new ArrayList<>();

//        shoppingItems.add(new ShoppingItem(R.drawable.item1,"아이템1"));
//        shoppingItems.add(new ShoppingItem(R.drawable.item1,"아이템1"));
//        shoppingItems.add(new ShoppingItem(R.drawable.item1,"아이템1"));
//        shoppingItems.add(new ShoppingItem(R.drawable.item1,"아이템1"));
//        shoppingItems.add(new ShoppingItem(R.drawable.item1,"아이템1"));
//        shoppingItems.add(new ShoppingItem(R.drawable.item1,"아이템1"));
//        shoppingItems.add(new ShoppingItem(R.drawable.item1,"아이템1"));

        return shoppingItems;
    }

}
