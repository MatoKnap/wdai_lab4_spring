package com.example.wdai_lab4_spring.service;

import com.example.wdai_lab4_spring.dao.Person;

import java.util.List;

public interface PersonService {
    List<Person> getPersons();
    Person getPerson(String surname);
    Person create(Person person);
    Person getPerson(Long id);
}