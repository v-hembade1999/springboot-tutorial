package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.user;
import com.example.demo.service.userservice;

@RestController
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	userservice service;
	
	//get all users
	@GetMapping("/")
	public List<user> getallusers()
	{
		return this.service.getallusers();
	}
	
	//get user by name
	@GetMapping("/{username}")
	public user getuser(@PathVariable("username") String username)
	{
		return this.service.getuserbyname(username);
	}
	
	//add user
	@PostMapping("/")
	public user adduser(user u)
	{
		return this.service.adduser(u);
	}
	
}
