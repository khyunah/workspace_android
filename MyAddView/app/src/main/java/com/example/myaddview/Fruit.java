package com.example.myaddview;

import java.util.ArrayList;

public class Fruit {

    String imageUrl;
    String name;
    String price;
    String count;

    public Fruit(String imageUrl, String name, String price, String count) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    // 샘플 데이터 만들어 보기
    public static ArrayList<Fruit> getFruits() {
        ArrayList<Fruit> list = new ArrayList<>();
        list.add(new Fruit("https://cdn.pixabay.com/photo/2017/07/07/12/31/lime-2481346__340.jpg", "라임", "10000", "1"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2018/05/08/20/19/pomegranate-3383814__340.jpg", "석류", "7000", "2"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2016/07/22/09/59/fruits-1534494__340.jpg", "모과", "8000", "10"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2017/02/05/12/31/lemons-2039830__340.jpg", "레몬", "9000", "5"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2016/01/02/01/59/oranges-1117628__340.jpg", "오렌지", "11000", "2"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2018/06/07/16/38/blueberries-3460423__340.jpg", "블루베리", "20000", "50"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2016/01/03/17/59/bananas-1119790__340.jpg", "바나나", "10000", "2"));
        return list;
    }
}
