package com.spring_baisic.week2.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 해당 클레스는 도메인에 속하며 SQL문 중 생성(CREATE)을 Java로 구현한 것이다.

@Getter // Lombok Getter
@NoArgsConstructor // Lombok 기본생성자를 대신 생성해줍니다.
@Entity // 테이블임을 나타냅니다.
public class Course extends Timestamped{

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String title;

    @Column(nullable = false)
    private String tutor;

    //Getter만 설정해준다. Setter는 나중에 Repository에서 설정한다! -> 롬복 어노테이션으로 대체

    public Course(CourseRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }
    public Course(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }

    public void update(CourseRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }
}