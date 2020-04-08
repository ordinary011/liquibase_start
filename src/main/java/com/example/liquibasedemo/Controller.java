package com.example.liquibasedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class Controller {
    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public String createPerson(@RequestParam String name){
        personRepository.save(new Person(name, "6.7"));
        return personRepository.findByName(name) + "Saved successfully";
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return (List<Person>) personRepository.findAll();
    }
}
