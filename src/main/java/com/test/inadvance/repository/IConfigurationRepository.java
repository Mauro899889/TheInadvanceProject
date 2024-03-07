package com.test.inadvance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.inadvance.entities.Configuration;

public interface IConfigurationRepository extends JpaRepository<Configuration, Long>{
	
	Configuration findByProperty(String property);

}
