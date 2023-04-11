package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController 
{
	@GetMapping("/home")
	public String homepage()
	{
		return "this is home page";
	}
	//@PreAuthorize("hasRole('NORMAL')")
	@GetMapping("/register")
	public String register()
	{
		return "this is home page";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "this is home page";
	}
}
