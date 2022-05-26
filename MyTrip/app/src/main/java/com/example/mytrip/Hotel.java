package com.example.mytrip;

import java.util.ArrayList;

public class Hotel {
    String image;
    String name;
    String price;
    String place;

    public Hotel(String image, String name, String price, String place){
        this.image = image;
        this.name = name;
        this.price = price;
        this.place = place;
    }

    // 샘플 데이터
    public static ArrayList<Hotel> getHotelData(){
        ArrayList<Hotel> list = new ArrayList<>();

        list.add(new Hotel("https://cdn.pixabay.com/photo/2013/04/18/14/39/ship-105596__340.jpg","파라다이스 호텔", "500,000 원", "해운대"));
        list.add(new Hotel("https://cdn.pixabay.com/photo/2021/12/11/07/59/hotel-6862159__340.jpg","웨스틴 조선 호텔", "300,000 원", "해운대"));
        list.add(new Hotel("https://cdn.pixabay.com/photo/2020/10/18/09/16/bedroom-5664221__340.jpg","부산 롯데 호텔", "400,000 원", "서면"));
        list.add(new Hotel("https://cdn.pixabay.com/photo/2021/06/01/12/39/beach-6301597__340.jpg","힐튼 호텔", "500,000 원", "기장"));
        list.add(new Hotel("https://cdn.pixabay.com/photo/2017/05/31/10/23/manor-house-2359884__340.jpg","엘시티", "1,000,000 원", "해운대"));
        list.add(new Hotel("https://cdn.pixabay.com/photo/2017/03/09/06/30/pool-2128578__340.jpg","농심 호텔", "300,000 원", "동래"));
        list.add(new Hotel("https://cdn.pixabay.com/photo/2015/11/06/11/45/interior-1026452__340.jpg","코모도 호텔", "200,000 원", "중구"));
        return list;
    }
}
