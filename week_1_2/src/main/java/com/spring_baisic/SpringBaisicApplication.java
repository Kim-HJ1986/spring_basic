package com.spring_baisic;

import com.spring_baisic.week2.domain.Course;
import com.spring_baisic.week2.domain.CourseRepository;
import com.spring_baisic.week2.domain.CourseRequestDto;
import com.spring_baisic.week2.service.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing //날짜를 자동으로 업데이트 해주기 위함.
@SpringBootApplication
public class SpringBaisicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBaisicApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(CourseRepository courseRepository, CourseService courseService) {
        return (args) -> {
            courseRepository.save(new Course("프론트엔드의 꽃, 리액트", "임민영"));

            System.out.println("데이터 인쇄");
            List<Course> courseList = courseRepository.findAll();
            for (int i=0; i<courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }

            //Course 클래스의 정보를 물고 다닐 DTO를 가져옴 이 후 Course로 만들었던 메서드 모두 DTO로 대체
            CourseRequestDto requestDto = new CourseRequestDto("웹개발의 봄, Spring", "임민영");
            courseService.update(1L, requestDto);
            courseList = courseRepository.findAll();
            for (int i=0; i<courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }
            System.out.println("깃허브에 같이 올리고 싶습니다!");

            //courseRepository.deleteAll();
        };


    }

}
