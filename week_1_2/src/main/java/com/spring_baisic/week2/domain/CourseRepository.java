package com.spring_baisic.week2.domain;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository를 상속받는다. 다이아몬드 연산자에는 <Entity class, id 타입>이 들어간다.
public interface CourseRepository extends JpaRepository<Course, Long> {
}
