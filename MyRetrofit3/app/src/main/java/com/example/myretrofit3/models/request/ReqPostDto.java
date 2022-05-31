package com.example.myretrofit3.models.request;
/*
    title: 'foo',
    body: 'bar',
    userId: 1,

    요청하는 쪽에서( 모바일에서 ) 객체를 생성해서 서비스로직 매개변수에 전달하는 코드를 사용하게 된다.
    그래서 요청하는 쪽에서 객체를 생성해서 보내줘야 한다.
 */
public class ReqPostDto {
    public String title;
    public String body;
    public Integer userId;

    public ReqPostDto(String title, String body, Integer userId) {
        this.title = title;
        this.body = body;
        this.userId = userId;
    }
}
