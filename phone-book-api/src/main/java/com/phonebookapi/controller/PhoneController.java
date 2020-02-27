package com.phonebookapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.phonebookapi.exception.ResourceNotFoundException;
import com.phonebookapi.model.Phone;
import com.phonebookapi.repository.PhoneRepository;

@RestController
@RequestMapping("/phones")
public class PhoneController {
	
	@Autowired
	PhoneRepository phoneRepository;
	
	@GetMapping
	public List<Phone> getAllPhones(){
		return phoneRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Phone getPhoneById(@PathVariable Long id){
		return phoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Phone", "id", id));
	}
	
	@PostMapping
	public ResponseEntity<Phone> postPhone(@Valid @RequestBody Phone phone){
		Phone createdPhone = phoneRepository.save(phone);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(phone.getId()).toUri();
		return ResponseEntity.created(uri).body(createdPhone);
	}
}
