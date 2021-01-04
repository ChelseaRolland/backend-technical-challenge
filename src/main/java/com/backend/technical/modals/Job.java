package com.backend.technical.modals;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany
    private List<Person> employees;

    //Constructor
    public Job(){}

    public Job(String jobTitle, int salary) {
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public Job(long id, String jobTitle, int salary, List<Person> employees) {
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

    public List<Person> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Person> employees) {
        this.employees = employees;
    }
}
