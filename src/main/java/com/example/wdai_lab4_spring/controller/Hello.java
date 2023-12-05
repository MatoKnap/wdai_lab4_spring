package com.example.wdai_lab4_spring.controller;

import com.example.wdai_lab4_spring.dao.Person;
import com.example.wdai_lab4_spring.model.Greeting;
import com.example.wdai_lab4_spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Hello {

//    public record HelloResponse(String greeting) {}
//    public ResponseEntity<HelloResponse> sayHello(@RequestParam String name) {
//        HelloResponse helloResponse = new HelloResponse("Hello " + name);

    @GetMapping("/hello")
    public ResponseEntity<Greeting> sayHello(@RequestParam String name) {
        Greeting helloResponse = new Greeting("Hello " + name);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

        return new ResponseEntity<>(helloResponse, headers, HttpStatus.OK);
    }

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getPersons() {
        List<Person> persons = personService.getPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Person person = personService.getPerson(id);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/person/create")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person createdPerson = personService.create(person);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }
}
