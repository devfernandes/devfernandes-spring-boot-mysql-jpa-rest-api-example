package com.phonebookapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phonebookapi.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
	
}
