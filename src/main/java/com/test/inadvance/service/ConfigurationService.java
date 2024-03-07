package com.test.inadvance.service;

import org.springframework.stereotype.Service;

import com.test.inadvance.entities.Configuration;
import com.test.inadvance.repository.IConfigurationRepository;

@Service
public class ConfigurationService {

	private final IConfigurationRepository repository;

	public ConfigurationService(IConfigurationRepository repository) {
		super();
		this.repository = repository;
	}
	
	public Configuration editConfiguration(Configuration configuration) {
		return repository.save(configuration);
	}
	
	public Configuration findByProperty(String property) {
		return repository.findByProperty(property);
	}
	
}
