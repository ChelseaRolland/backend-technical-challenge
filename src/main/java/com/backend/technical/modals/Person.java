package com.backend.technical.modals;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private short age;

    @Column(columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP) //This is needed since using the java.util.date
    private Date dateJoined;

    @Column(length = 25)
    private String updateTime;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "employee_jobs",
            joinColumns = {@JoinColumn(name = "emp_id")},
            inverseJoinColumns = {@JoinColumn(name = "job_id")}
    )
    private Set<Job> jobs;

    //Constructors
    public Person() {}

    //Insert/Create
    public Person(String name, short age) {
        this.name = name;
        this.age = age;
    }

    //Read
    public Person(long id, String name, short age, Date dateJoined, String updateTime, Set<Job> jobs) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dateJoined = dateJoined;
        this.updateTime = updateTime;
        this.jobs = jobs;
    }

    //Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Set<Job> getJobs() {return jobs;}

    public void setJobs(Set<Job> jobs){this.jobs = jobs;}

    //Many-To-Many Methods

    //Adding a Job to a Person
    public void addJobToPerson(Job job){
        this.jobs.add(job);
        job.getEmployees().add(this);
    }

    //Removing a Job from a Person
    public void removeJobFromPerson(Job job){
        this.jobs.remove(job);
        job.getEmployees().remove(this);
    }
}
