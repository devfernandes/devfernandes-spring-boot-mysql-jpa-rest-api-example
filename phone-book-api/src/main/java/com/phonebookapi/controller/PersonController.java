package com.phonebookapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.phonebookapi.exception.ResourceNotFoundException;
import com.phonebookapi.model.Person;
import com.phonebookapi.repository.PersonRepository;

@RestController
@RequestMapping("/people")
public class PersonController {
	@Autowired
	PersonRepository personRepository;

	@GetMapping
	public List<Person> findAllPeople() {
		return personRepository.findAll();
	}

	@GetMapping("/{id}")
	public Person getPersonById(@PathVariable Long id) {
		return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
	}

	@PostMapping
	public ResponseEntity<Person> postPerson(@RequestBody Person person) {
		Person savedPerson = personRepository.save(person);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(person.getId()).toUri();
		return ResponseEntity.created(location).body(savedPerson);
	}
}
