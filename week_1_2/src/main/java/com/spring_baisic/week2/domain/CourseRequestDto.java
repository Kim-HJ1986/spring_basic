package com.spring_baisic.week2.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CourseRequestDto {
    // final로 지정 시 반드시 있어야하는 멤버변수가 되기 때문에 이를 넣은 생성자가 필수!
    // 따라서 @RequiredArgsConstructor를 붙여준다!
    private final String title;
    private final String tutor;

}
