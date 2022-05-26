package com.example.recyclerview.models;

import java.util.ArrayList;

public class Food {
    private String thumbnail;
    private String title;
    private String subTitle;
    private String detail;

    //    alt + insert  =  생성자 만들수 있는 창
    public Food(String thumbnail, String title, String subTitle, String detail) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.subTitle = subTitle;
        this.detail = detail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getDetail() {
        return detail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public static ArrayList<Food> getSampleData() {
        ArrayList<Food> foods = new ArrayList<>();

        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__480.jpg", "Food1", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__480.jpg", "Food2", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__480.jpg", "Food3", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__480.jpg", "Food4", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__480.jpg", "Food5", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__480.jpg", "Food6", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__480.jpg", "Food7", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__480.jpg", "Food8", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__480.jpg", "Food9", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__480.jpg", "Food10", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__480.jpg", "Food11", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__480.jpg", "Food12", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__480.jpg", "Food13", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__480.jpg", "Food14", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__480.jpg", "Food15", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__480.jpg", "Food16", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__480.jpg", "Food17", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__480.jpg", "Food18", "SubTitle1", "detail"));

        return foods;
    }
}
