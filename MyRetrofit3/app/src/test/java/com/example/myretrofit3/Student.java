package com.example.myretrofit3;

// Builder 패턴
// this 키워드를 충분히 이해해야 함.
public class Student {

    private String name;
    private int grade;

    // 1. 기본생성자를 private 으로 정의하기
    private Student() {
}

    // 2. 내부 클래스를 생성한다. ( static 을 붙이면 내부정적 클래스 라고 한다.  ( public, default, private 가능) )
    public static class MyBuilder {

        // 2-1.
        // out class 의 멤버변수를 한번더 정의 해야 한다.
        // 단, private 으로만 해야함.
        private String name;
        private int grade;

        // 2-2.
        // setter 메서드를 만들어 준다. ( 하지만 리턴 타입은 자기자신이다. )
        public MyBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public MyBuilder setGrade(int grade) {
            this.grade = grade;
            return this;
        }

        // 핵심 ! ! ! !
        // 3. 리턴 타입을 out class 로 반환하는 메서드를 만들어 준다.
        public Student build() {
            Student student = new Student();
            student.name = name; // out class 의 name = inner class 의 name
            student.grade = grade;
            return student;
        }
    }

    public static void main(String[] args) {

        // 멤버 변수가 ( 수정해야 하는 값 ) 10개 이상이라고 했을 경우
        // 모든 값을 기본값이나 null 처리를 하며 모두 입력해주어야 하는데
        // 빌더 패턴은 원하는 값만 입력하는 것이 가능하다.
        Student student1 = new MyBuilder().setName("홍길동").build();
        Student student2 = new MyBuilder().setGrade(1).build();
        Student student3 = new MyBuilder().setName("이순신").setGrade(3).build();
    }
}
