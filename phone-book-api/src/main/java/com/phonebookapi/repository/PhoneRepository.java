package com.phonebookapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phonebookapi.model.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
