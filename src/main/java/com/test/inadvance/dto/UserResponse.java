package com.test.inadvance.dto;

import java.util.Date;

public class UserResponse {

	private Long id; 
	
	private boolean isActive;
	
	private Date created;
	
	private Date modified;
	
	private Date lastLogin;
	
	private String token;

	public UserResponse(Long id, boolean isActive, Date created, Date modified, Date lastLogin, String token) {
		super();
		this.id = id;
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
