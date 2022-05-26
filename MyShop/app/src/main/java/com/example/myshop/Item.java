package com.example.myshop;

import java.util.ArrayList;

public class Item {
    private String imageUrl;
    private String storeName;
    private String name;
    private String price;

    public Item(String imageUrl, String storeName, String name, String price) {
        this.imageUrl = imageUrl;
        this.storeName = storeName;
        this.name = name;
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    // 샘플 데이터
    public static ArrayList<Item> getSampleData() {
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item("https://cdn.pixabay.com/photo/2020/11/16/17/04/girl-5749591__340.png","고고싱", "탐나는하이와이드팬츠", "14,900원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2020/11/16/17/04/girl-5749591__340.png","고고싱", "탐나는하이와이드팬츠", "14,900원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2020/11/16/17/04/girl-5749591__340.png","고고싱", "탐나는하이와이드팬츠", "14,900원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2020/11/16/17/04/girl-5749591__340.png","고고싱", "탐나는하이와이드팬츠", "14,900원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2020/11/16/17/04/girl-5749591__340.png","고고싱", "탐나는하이와이드팬츠", "14,900원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2020/11/16/17/04/girl-5749591__340.png","고고싱", "탐나는하이와이드팬츠", "14,900원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2020/11/16/17/04/girl-5749591__340.png","고고싱", "탐나는하이와이드팬츠", "14,900원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2020/11/16/17/04/girl-5749591__340.png","고고싱", "탐나는하이와이드팬츠", "14,900원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2020/11/16/17/04/girl-5749591__340.png","고고싱", "탐나는하이와이드팬츠", "14,900원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2020/11/16/17/04/girl-5749591__340.png","고고싱", "탐나는하이와이드팬츠", "14,900원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2020/11/16/17/04/girl-5749591__340.png","고고싱", "탐나는하이와이드팬츠", "14,900원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2020/11/16/17/04/girl-5749591__340.png","고고싱", "탐나는하이와이드팬츠", "14,900원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2020/11/16/17/04/girl-5749591__340.png","고고싱", "탐나는하이와이드팬츠", "14,900원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2020/11/16/17/04/girl-5749591__340.png","고고싱", "탐나는하이와이드팬츠", "14,900원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2020/11/16/17/04/girl-5749591__340.png","고고싱", "탐나는하이와이드팬츠", "14,900원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2020/11/16/17/04/girl-5749591__340.png","고고싱", "탐나는하이와이드팬츠", "14,900원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2020/11/16/17/04/girl-5749591__340.png","고고싱", "탐나는하이와이드팬츠", "14,900원"));

        return items;
    }
}
