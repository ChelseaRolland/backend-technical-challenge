package com.backend.technical.controllers;

import com.backend.technical.modals.Person;
import com.backend.technical.repos.JobRepository;
import com.backend.technical.repos.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Long.parseLong;

@RestController
@RequestMapping(value = "/api/persons")
public class RestPersonController {
    private PersonRepository personDao;
    private JobRepository jobDao;

    public RestPersonController (PersonRepository personDao, JobRepository jobDao){
        this.personDao = personDao;
        this.jobDao = jobDao;
    }

    //Finding all people
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Person>> listAllPeople(){
        return new ResponseEntity<>(personDao.findAll(), HttpStatus.OK);
    }

    //add 1 person
    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public ResponseEntity<Object> addPerson(@RequestBody Person person){
        personDao.save(person);
        return new ResponseEntity<>("Person is created successfully", HttpStatus.CREATED);
    }

    //Find 1 person via id
    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> showPerson(@PathVariable("id") String id){
        return new ResponseEntity<>(personDao.findById(parseLong(id)), HttpStatus.OK);
    }

    //update person
    @RequestMapping(value = "/person/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Object> updatePerson(@PathVariable("id") String id, @RequestBody Person person){
        person.setId(parseLong(id));
        personDao.save(person);
        return new ResponseEntity<>("Person was updated successfully", HttpStatus.OK);
    }

    //delete person
    @RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePerson(@PathVariable("id") String id) {
        personDao.deleteById(parseLong(id));
        return new ResponseEntity<>("Person has been deleted successfully", HttpStatus.OK);
    }

}
