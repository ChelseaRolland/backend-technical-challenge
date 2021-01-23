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

    //Find 1 person via id
   @RequestMapping(value = "/person/{id}", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    public Person findPerson(@PathVariable long id){
        return personDao.getOne(id);
   }
    //Find all people
    @RequestMapping(value = "/person/all", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    public List<Person> findAllPeople(){
        return personDao.findAll();
    }

    //add person


    //update person

    //delete person
    @RequestMapping(value = "/person/delete/{id}", method = RequestMethod.DELETE, produces = {"application/json", "application/xml"})
    public void deletePerson(@PathVariable long id){
        personDao.deleteById(id);
    }
}
