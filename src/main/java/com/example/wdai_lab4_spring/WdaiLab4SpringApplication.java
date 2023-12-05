package com.example.wdai_lab4_spring;

import com.example.wdai_lab4_spring.dao.Person;
import com.example.wdai_lab4_spring.repository.PersonsRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class WdaiLab4SpringApplication {
    private static final Logger log = LoggerFactory.getLogger(WdaiLab4SpringApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WdaiLab4SpringApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonsRepository repository) {
        return (args) -> {
            // save a few persons
            repository.save(new Person("John", "Doe", "IT"));
            repository.save(new Person("John", "Smith", "tester"));

            // fetch all persons
            log.info("Persons found with findAll():");
            log.info("-------------------------------");
            repository.findAll().forEach(person -> {
                log.info(person.toString());
            });
        };
    }

}
