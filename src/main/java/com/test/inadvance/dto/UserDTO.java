package com.test.inadvance.dto;

import java.util.List;

import com.google.common.base.Preconditions;
import com.test.inadvance.entities.Phone;

import lombok.NonNull;

public class UserDTO {
	
	@NonNull
	private String name;
	
	@NonNull
	private String email;
	
	@NonNull
	private String password;
	
	private List<Phone> phones;
	
	@NonNull
	public String getName() {
		return name;
	}

	public void setName(@NonNull String name) {
		Preconditions.checkNotNull(name, "name must not be null.");
		
		this.name = name;
	}

	@NonNull
	public String getEmail() {
		return email;
	}

	public void setEmail(@NonNull String email) {
		Preconditions.checkNotNull(email, "email must not be null.");
		
		this.email = email;
	}

	@NonNull
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		Preconditions.checkNotNull(password, "password must not be null.");
		
		this.password = password;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

}
