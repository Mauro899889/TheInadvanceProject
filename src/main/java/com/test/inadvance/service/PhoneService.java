package com.test.inadvance.service;

import org.springframework.stereotype.Service;

import com.test.inadvance.entities.Phone;
import com.test.inadvance.repository.IPhoneRepository;

@Service
public class PhoneService {
	
	private final IPhoneRepository repository;

	public PhoneService(IPhoneRepository repository) {
		super();
		this.repository = repository;
	}
	
	public Phone createPhone(Phone phone) {
		return repository.save(phone);
	}

}
