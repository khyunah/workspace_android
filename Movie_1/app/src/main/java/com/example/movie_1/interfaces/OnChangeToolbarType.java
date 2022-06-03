package com.example.movie_1.interfaces;

// 1. 콜백 메서드 만들 때 인터페이스를 선언한다.
// 1-1. 추상메서드를 선언한다. ( 구분해야 될 부분 / 데이터를 전달해야 할 경우 매개변수를 만들어 준다. )
// 2. 호출자에 가서 인터페이스를 멤버변수로 선언한다.
// 2-1. 필요한 곳에서 인터페이스 안에 속해있는 추상메서드를 호출하면 된다.
// MOVIE Fragment, InFo Fragment 가 호출자임
public interface OnChangeToolbarType {
    // 확장성 있게, 유지 보수 편하게 설계하기
    void onSetupType(String title);
}
