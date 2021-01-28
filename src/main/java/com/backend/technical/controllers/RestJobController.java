package com.backend.technical.controllers;

import com.backend.technical.modals.Job;
import com.backend.technical.repos.JobRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/jobs")
public class RestJobController {
    private JobRepository jobDao;

    public RestJobController (JobRepository jobDao){
        this.jobDao = jobDao;
    }

    //Finding all jobs
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Job>> listAllJobs(){
        return new ResponseEntity<>(jobDao.findAll(), HttpStatus.OK);
    }

    //Adding 1 job

    //Find 1 job via id

    //update Job

    //delete job
}
