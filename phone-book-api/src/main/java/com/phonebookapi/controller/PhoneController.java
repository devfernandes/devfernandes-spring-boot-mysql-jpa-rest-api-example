package com.phonebookapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
}
