package com.spring_baisic.week1.service;

import com.spring_baisic.week1.domain.Person;
import com.spring_baisic.week1.domain.PersonRepository;
import com.spring_baisic.week1.domain.PersonRequestDto;
import com.spring_baisic.week2.domain.Course;
import com.spring_baisic.week2.domain.CourseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, PersonRequestDto requestDto) {
        Person person1 = personRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        person1.update(requestDto);
        return person1.getId();
    }
}
