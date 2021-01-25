package com.backend.technical.repos;

import com.backend.technical.modals.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PersonRepository extends JpaRepository <Person, Long> {
    Person findById(long personId);
    List<Person> findAllByName(String personName);
    List<Person> findAllByAge(short age);
    List<Person> findAllByDateJoined(Date dateJoined);
    Person remove(String id);
}
