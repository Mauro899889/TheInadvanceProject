package com.test.inadvance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.inadvance.entities.Phone;

public interface IPhoneRepository extends JpaRepository<Phone, Long>{

}
