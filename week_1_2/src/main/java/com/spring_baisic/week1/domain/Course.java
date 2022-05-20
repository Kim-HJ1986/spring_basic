package com.spring_baisic.week1.domain;

public class Course {
    // private 접근제어자를 써줌으로써 클래스 외부에서 멤버변수에 직접 접근하지 못하도록 막음.
    private String title;
    private String tutor;
    private int days;

    // 기본 생성자
    public Course(){}
    // 생성자
    public Course(String title, String tutor, int days) {
        this.title = title;
        this.tutor = tutor;
        this.days = days;
    }

    //Setter 내부에 조건문 등을 추가하여 잘못된 값 입력 등의 잘못된 접근을 막을 수 있다.
    public void setTitle(String title){
        this.title = title;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public void setDays(int days) {
        this.days = days;
    }

    //Getter

    public String getTitle() {
        return this.title;
    }

    public String getTutor() {
        return this.tutor;
    }

    public int getDays() {
        return this.days;
    }
}
