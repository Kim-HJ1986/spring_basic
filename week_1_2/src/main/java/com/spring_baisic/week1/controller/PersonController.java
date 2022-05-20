package com.spring_baisic.week1.controller;

import com.spring_baisic.week1.domain.Person;
import com.spring_baisic.week1.domain.PersonRepository;
import com.spring_baisic.week1.domain.PersonRequestDto;
import com.spring_baisic.week1.service.PersonService;
import com.spring_baisic.week2.domain.CourseRepository;
import com.spring_baisic.week2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    private final PersonService personService;

    @GetMapping("/api/persons")
    public List<Person> getPerson(){
        return personRepository.findAll();
    }

    @PostMapping("/api/persons")
    public Person creratePerson(@RequestBody PersonRequestDto requestDto){
        Person person = new Person(requestDto);
        return personRepository.save(person);
    }

    @PutMapping("/api/persons/{id}")
    public Long updatePerson(@PathVariable Long id, @RequestBody PersonRequestDto requestDto){
        return personService.update(id, requestDto);
    }

    @DeleteMapping("/api/persons/{id}")
    public Long deletePerson(@PathVariable Long id){
        personRepository.deleteById(id);
        return id;
    }

}
