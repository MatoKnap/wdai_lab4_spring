package com.example.wdai_lab4_spring.repository;

import com.example.wdai_lab4_spring.dao.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonsRepository extends CrudRepository<Person, Long> {
}
