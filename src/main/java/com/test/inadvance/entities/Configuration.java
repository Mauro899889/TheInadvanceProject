package com.test.inadvance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Configuration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "configuration_sequence")
	@Column(name = "id")
	private Long id; 
	
	@Column(name = "property")
	private String property;
	
	@Column(name = "value")
	private String value;

	public Configuration() {
		super();
	}

	public Configuration(Long id, String property, String value) {
		super();
		this.id = id;
		this.property = property;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
