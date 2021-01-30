package com.backend.technical.controllers;

import com.backend.technical.modals.Job;
import com.backend.technical.repos.JobRepository;
import com.backend.technical.repos.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Long.parseLong;

@RestController
@RequestMapping(value = "/api/jobs")
public class RestJobController {
    private JobRepository jobDao;
    private PersonRepository personDao;

    public RestJobController (JobRepository jobDao, PersonRepository personDao){
        this.jobDao = jobDao;
        this.personDao = personDao;
    }

    //Finding all jobs
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Job>> listAllJobs(){
        return new ResponseEntity<>(jobDao.findAll(), HttpStatus.OK);
    }

    //Adding 1 job
    @RequestMapping(value = "/jobs", method = RequestMethod.POST)
    public ResponseEntity<Object> addJob(@RequestBody Job job){
        jobDao.save(job);
        return new ResponseEntity<>("Job was created successfully", HttpStatus.CREATED);
    }

    //Find 1 job via id
    @RequestMapping(value = "/job/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> showJob(@PathVariable("id") String id){
        return new ResponseEntity<>(jobDao.findById(parseLong(id)), HttpStatus.OK);
    }

    //update Job
    @RequestMapping(value = "/job/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Object> updatePerson(@PathVariable("id") String id, @RequestBody Job job){
        job.setId(parseLong(id));
        jobDao.save(job);
        return new ResponseEntity<>("Job was updated successfully", HttpStatus.OK);
    }

    //delete job
    @RequestMapping(value = "/job/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePerson(@PathVariable("id") String id) {
        jobDao.deleteById(parseLong(id));
        return new ResponseEntity<>("Job has been deleted successfully", HttpStatus.OK);
    }

    //finding all employees under 1 job title
    @RequestMapping(value = "/job/{id}/employees", method = RequestMethod.GET)
    public ResponseEntity<Object> showEmployees(@PathVariable("id") String id){
        Job jobById = jobDao.findById(parseLong(id));
        return new ResponseEntity<>(personDao.findAllByJob(jobById), HttpStatus.OK);
    }
}
