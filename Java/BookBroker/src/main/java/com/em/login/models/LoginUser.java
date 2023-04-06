package com.em.login.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//This class has no entity because we are not saving this to DB 
//This class is to confirm login credenntials 
public class LoginUser {
	
	@NotEmpty(message="Email is required")
	@Email(message="Please enter a valid email")
	private String email;
	
	@NotEmpty(message="Password is required")
	@Size(min=3, max=128, message="Password must be at least 3 characters")
	private String password;
	
	public LoginUser() {
	}
	//Getters and Setters

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

}
	
