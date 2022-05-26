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

        items.add(new Item("https://www.ggsing.com/web/product/medium/202204/b9ab88e93d801f1e6833f50215c7ad98.gif",
                "고고싱", "탐나는하이와이드팬츠", "14,900원"));
        items.add(new Item("https://m.finleu.com/web/product/small/202203/d12540859b2acf097a233770a5c75567.webp",
                "핀르", "마가렛 베이직셔츠", "29,900원"));
        items.add(new Item("https://cafe24img.poxo.com/sseoqkr7/web/product/big/202205/a8c8802310a0fb9618242fbfc6333c08.jpg",
                "멜로즈무드", "[made] 멜무롱시크슬랙스sl(5color) 22썸머ver.", "36,000원"));
        items.add(new Item("https://m.benito.co.kr/web/product/big/202011/a81e81a66e8db36e6e31d9d757c8e875.jpg",
                "프롬비기닝", "♥BEST♥트위스트 반팔카라니트 (4color)", "20,000원"));
        items.add(new Item("https://robinu.co.kr/web/product/big/202205/60de92fc1b1dd278e03fd39e30ce03ad.webp",
                "로빈유", "[honest,you] 시즌 핀턱 슬랙스", "32,400원"));
        items.add(new Item("https://cdn-naning9.bizhost.kr/files/goods/68107/1635230048_9.gif",
                "난닝구", "그라포 플라워 랩 원피스(C04)", "19,800원"));
        items.add(new Item("https://sappun.co.kr/shopimages/sappun/0360010008932.jpg?1620706662",
                "사뿐", "루아이 리본 플랫슈즈 (3cm)", "45,900원"));
        items.add(new Item("https://fine-thankyou.com/web/product/tiny/202204/57b28969ebb2ec205ba8dd36eeb9355c.webp",
                "파인땡큐", "메르린넨원피스_3color", "44,100원"));
        items.add(new Item("https://cdn-naning9.bizhost.kr/files/goods/70352/1628585037_9.gif",
                "난닝구", "오즈앤 플라워스퀘어넥원피스", "19,800원"));
        items.add(
                new Item("https://img.ssfshop.com/cmd/LB_500x660/src/https://img.ssfshop.com/goods/8SBR/22/05/19/GM0022051959671_1_ORGINL_20220520102223228.jpg",
                        "에잇세컨즈", "[에잇세컨즈] 아이보리 저지 칼라 반팔 카디건", "39,900원"));
        items.add(new Item("https://hotping.co.kr/web/product/medium/202202/7fb17d809fca1be1a1df166d21e93ef2.webp",
                "핫핑", "[MADE][LOVB] L-956 스퀘어넥 롱원피스", "34,800원"));
        items.add(new Item("https://www.shoemaru.com/shopimages/half1031/0290020003013.gif?1653357103",
                "슈마루", "Z리뷰만3천개 [제작] 마약스틸레토힐26(마리스TCver.upgrade)(5cm/7cm/9cm)", "29,500원"));
        items.add(new Item("https://www.uptownholic.com/shopimages/lovelybbb/0310030031773.gif?1652323243",
                "업타운홀릭", "셔링 라운드 블라우스 (*3color)", "39,000원"));
        items.add(new Item("https://image.wconcept.co.kr/productimg/image/img1/93/301726593.jpg",
                "아위", "Nellia A-line Dart Dress_Gray", "188,000원"));
        items.add(new Item("https://image.wconcept.co.kr/productimg/image/img1/03/301283503.jpg",
                "로로텐", "엘모아 스카시 반팔 니트", "41,400원"));
        items.add(new Item("https://image.wconcept.co.kr/productimg/image/img1/81/301280081.jpg",
                "에스블랑", "Reighlee / See-through Pleated Dress", "218,000원"));
        items.add(new Item("https://m.wingbling.co.kr/web/product/big/202012/2d80bcf18f2139dc525b30bece967ecb.jpg",
                "바이레이디즈", "[무배]진주 레이어드 투 라인 링 귀걸이/은침", "8,600원"));

        return items;
    }
}
