package com.backend.technical.controllers;

import com.backend.technical.modals.Person;
import com.backend.technical.repos.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestPersonController {
    private PersonRepository personDao;

    public RestPersonController (PersonRepository personDao){
        this.personDao = personDao;
    }

   @RequestMapping(value = "/person/{id}", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    public Person findPerson(@PathVariable long id){
        return personDao.getOne(id);
   }
}
