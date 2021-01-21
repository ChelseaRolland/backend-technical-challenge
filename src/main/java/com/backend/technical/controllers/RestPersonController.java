package com.backend.technical.controllers;

import com.backend.technical.modals.Person;
import com.backend.technical.repos.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestPersonController {
    private PersonRepository personDao;

    public RestPersonController (PersonRepository personDao){
        this.personDao = personDao;
    }

    @PostMapping("/persons")
    public List<Person> viewPeople () {
        return personDao.findAll();
    }
}
