package com.spring_baisic.week2.controller;

import com.spring_baisic.week2.domain.Course;
import com.spring_baisic.week2.domain.CourseRepository;
import com.spring_baisic.week2.domain.CourseRequestDto;
import com.spring_baisic.week2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // final로 생성한 필수 멤버변수를 담은 생성자를 만들자
@RestController // JSON으로 응답을 하자
public class CourseController {

    // CourseRepository는 JPA를 사용하기 위해 final로 만들어준다. (필수값이기 때문)
    private final CourseRepository courseRepository;

    private final CourseService courseService;

    //GetMapping을 통해 조회하기
    @GetMapping("/api/courses")
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    // PostMapping을 통해서, 같은 주소라도 방식이 다름을 구분합니다.
    @PostMapping("/api/courses")
    public Course createCourse(@RequestBody CourseRequestDto requestDto) {
        // @RequestBody 는, 해당 파라미터가 웹 request에 바인딩되어야 함을 명시함

        // 저장하는 것은 Dto가 아니라 Course이니, Dto의 정보를 course에 담아야 합니다.
        // Course에 새로운 생성자를 만들어줌
        Course course = new Course(requestDto);

        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return courseRepository.save(course);
    }

    // @PathVariable이 붙은 변수에 url에 넘어온 변수임을 명시하여 사용할 수 있다.
    @PutMapping("/api/courses/{id}")
    public Long updateCourse(@PathVariable Long id, @RequestBody CourseRequestDto requestDto) {
        return courseService.update(id, requestDto);
    }
    
    @DeleteMapping("/api/courses/{id}")
    public Long deleteCourse(@PathVariable Long id){
        courseRepository.deleteById(id);
        return id;
    }
}