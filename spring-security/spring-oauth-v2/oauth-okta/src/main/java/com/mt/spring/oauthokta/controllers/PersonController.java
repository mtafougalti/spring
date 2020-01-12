package com.mt.spring.oauthokta.controllers;

import com.mt.spring.oauthokta.model.Person;
import com.mt.spring.oauthokta.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/persons")
@Api("Persons Management Feature")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    @ApiOperation(value = "Create or update a new person", response = Person.class)
    public ResponseEntity<Person> save(@RequestBody Person person) {
        personService.save(person.getId(), person);
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete the person with the given id", response = String.class)
    public ResponseEntity<String> delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.ok("Person deleted successfully");
    }

    @GetMapping
    @ApiOperation(value = "Get all persons", response = Collection.class)
    public ResponseEntity<Collection<Person>> findAll() {
        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get the person with the given id", response = Person.class)
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.findById(id));
    }
}
