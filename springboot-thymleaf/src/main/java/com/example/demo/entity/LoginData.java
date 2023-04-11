package com.example.demo.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginData 
{
	@NotBlank(message="username cannot be null")
	@Size(min= 3,max=10,message="username must be between 3 to 12 characters")
	private String username;
	@Email(regexp = "^[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*$",message="invalid mail")
	private String email;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "LoginData [username=" + username + ", email=" + email + "]";
	}
	
	
}
