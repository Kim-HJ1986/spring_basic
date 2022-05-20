package com.spring_baisic.week1.controller;

import com.spring_baisic.week1.domain.Course;
import org.springframework.web.bind.annotation.GetMapping;

// Rest는 서버의 응답이 JSON 형식임을 나타낸다. Controller는 누군가 말을 걸면 응답하는 것
// 어노테이션으로 RestController임을 명시해준다. (JSON만을 돌려주는 자동응답기)
//@RestController // 메서드의 이름이 같은 상황에서 둘 다 RestController를 붙여주면 오류 발생!
public class CourseController {

    // 리턴 타입이 Course라는 자바 클래스지만, 이를 JSON타입으로 돌려보낸다. (스프링이!)
    @GetMapping("/courses")
    public Course getCourses() {
        Course course = new Course();
        course.setTitle("웹개발의 봄 스프링");
        course.setDays(35);
        course.setTutor("남병관");
        return course;
    }
}
