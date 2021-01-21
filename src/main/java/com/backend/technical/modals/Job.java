package com.backend.technical.modals;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String jobTitle;

    @Column(nullable = false)
    private int salary;

    @ManyToMany
    private Set<Person> employees;

    //Constructor
    public Job(){}

    public Job(String jobTitle, int salary) {
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public Job(long id, String jobTitle, int salary, Set<Person> employees) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.employees = employees;
    }

    //Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Set<Person> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Person> employees) {
        this.employees = employees;
    }

    //Many-To-Many Relationship Methods

    //Adding Person to Job
    public void addPersonToJob(Person person){
        this.employees.add(person);
        person.getJobs().add(this);
    }

    //Removing Person from Job
    public void removePersonFromJob(Person person){
        this.employees.remove(person);
        person.getJobs().remove(this);
    }
}
