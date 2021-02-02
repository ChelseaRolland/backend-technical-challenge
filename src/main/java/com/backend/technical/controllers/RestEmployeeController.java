package com.backend.technical.controllers;

import com.backend.technical.modals.Job;
import com.backend.technical.modals.Person;
import com.backend.technical.repos.JobRepository;
import com.backend.technical.repos.PersonRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees/")
public class RestEmployeeController {
    private PersonRepository personDao;
    private JobRepository jobDao;

    public RestEmployeeController(PersonRepository personDao, JobRepository jobDao){
        this.personDao = personDao;
        this.jobDao = jobDao;
    }

    @GetMapping("/get")
    public String getEmployee(){
        return "Hello there";
    }

    @PostMapping("create")
    public void createEmployee(@RequestBody Person personToBeSaved){
        Person empDB = personDao.findById(personToBeSaved.getId());
        Job jobDB = jobDao.findByJobTitle(personToBeSaved.getJob().getJobTitle());
        if (empDB == null) {
            if (jobDB == null){
                jobDao.save(personToBeSaved.getJob());
            } else {
                jobDao.save(jobDB);
            }
            personDao.save(personToBeSaved);
        } else {
            System.out.println("empDB.getName() = " + empDB.getName());
            if (jobDB == null){
                jobDao.save(personToBeSaved.getJob());
            } else {
                jobDao.save(jobDB);
            }
            personDao.save(empDB);
        }
    }

    @DeleteMapping("delete")
    public String deleteEmployee(@RequestBody Person personToBeDeleted){
        Person empDB = personDao.findPersonByNameAndAge(personToBeDeleted.getName(), personToBeDeleted.getAge());
        if (empDB == null){
            return "This can't be deleted since it doesn't exists in the DB";
        } else {
            personDao.deleteById(empDB.getId());
            return "Employee has been deleted from DB";
        }
    }

}
