package com.phonebookapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phonebookapi.model.Person;
import com.phonebookapi.repository.PersonRepository;

@RestController
@RequestMapping("/people")
public class PersonController {
	@Autowired
	PersonRepository personRepository;
	
	@GetMapping
	public List<Person> findAllPeople(){
		return personRepository.findAll();
	}
}
