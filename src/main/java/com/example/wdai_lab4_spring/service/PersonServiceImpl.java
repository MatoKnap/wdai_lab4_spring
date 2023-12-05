package com.example.wdai_lab4_spring.service;

import com.example.wdai_lab4_spring.dao.Person;
import com.example.wdai_lab4_spring.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonsRepository personsRepository;

    @Override
    public List<Person> getPersons() {
        return (List<Person>) personsRepository.findAll();
    }

    @Override
    public Person getPerson(String surname) {
        // Implement logic to find person by surname
        return null;
    }

    @Override
    public Person create(Person person) {
        return personsRepository.save(person);
    }

    @Override
    public Person getPerson(Long id) {
        return personsRepository.findById(id).orElse(null);
    }
}