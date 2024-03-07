package com.test.inadvance.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.Preconditions;

import lombok.NonNull;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "user_sequence")
	@Column(name = "id")
	private Long id; 
	
	private String name;
	
	private String email;
	
	private String password;
	
	private boolean isActive;
	
	private Date created;
	
	private Date modified;
	
	private Date lastLogin;
	
	private String token;
	

	public User() {
		super();
	}

	public User(@NonNull final String name, @NonNull final String email, @NonNull final String password, 
			@NonNull final boolean isActive, @NonNull final Date created, @NonNull final Date modified,
			@NonNull final Date lastLogin, @NonNull final String token) {
		super();
		Preconditions.checkNotNull(name, "name must not be null.");
		Preconditions.checkNotNull(email, "email must not be null.");
		Preconditions.checkNotNull(password, "password must not be null.");
		Preconditions.checkNotNull(isActive, "isActive must not be null.");
		Preconditions.checkNotNull(created, "created must not be null.");
		Preconditions.checkNotNull(modified, "modified must not be null.");
		Preconditions.checkNotNull(lastLogin, "lastLogin must not be null.");
		Preconditions.checkNotNull(token, "token must not be null.");
		
		this.name = name;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
		this.created = created;
		this.modified = modified;
		this.lastLogin = lastLogin;
		this.token = token;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
