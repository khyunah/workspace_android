package com.example.myretrofit3;

public class Book {

    private String title;
    private String content;
    private String author;

    private Book() {}

    private static class MyBuilder {

        private String title;
        private String content;
        private String author;

        public MyBuilder setTitle(String title){
            this.title = title;
            return this;
        }

        public MyBuilder setContent(String content){
            this.content = content;
            return this;
        }

        public MyBuilder setAuthor(String author){
            this.author = author;
            return this;
        }

        public Book build(){
            Book book = new Book();
            book.title = title;
            book.content = content;
            book.author = author;
            return book;
        }
    }

    public static void main(String[] args) {
        Book book1 = new MyBuilder().setTitle("마음의 소리").build();
        Book book2 = new MyBuilder().setTitle("말의 온도").setContent("책내용").setAuthor("작가1").build();

    }
}
