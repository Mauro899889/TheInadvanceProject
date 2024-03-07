package com.test.inadvance.service;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.test.inadvance.entities.User;
import com.test.inadvance.repository.IUserRepository;

import java.util.regex.Matcher;

@Service
public class UserService {

	private final IUserRepository repository;

	public UserService(IUserRepository repository) {
		this.repository = repository;
	}
	
	public User createUser(User user) {
		return repository.save(user);
	}
	
	public User findByMail(String mail) {
		return repository.findByEmail(mail);
	}
	
	public boolean validateMail(String mail) {
		String regex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(mail);
		return matcher.matches();
	}
	
	public boolean validatePassword(String password, String passwordRegex) {
		Pattern pattern = Pattern.compile(passwordRegex);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}
	
}
