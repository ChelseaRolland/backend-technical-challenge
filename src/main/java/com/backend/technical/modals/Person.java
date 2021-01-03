package com.backend.technical.modals;

import javax.persistence.*;
import java.util.Date;

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

    //Constructors
    public Person() {}

    //Insert/Create
    public Person(String name, short age) {
        this.name = name;
        this.age = age;
    }

    //Read

    public Person(long id, String name, short age, Date dateJoined, String updateTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dateJoined = dateJoined;
        this.updateTime = updateTime;
    }
}
