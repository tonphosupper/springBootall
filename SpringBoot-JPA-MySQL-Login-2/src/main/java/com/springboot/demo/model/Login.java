package com.springboot.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String emailId;
	private String username;
	private String password;
	private String roles;

	public Login() {

	}
	

	public Login( String emailId, String username, String password, String roles) {
		super();
		this.emailId = emailId;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getRoles() {
		return roles;
	}


	public void setRoles(String roles) {
		this.roles = roles;
	}

}
