package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AuthRequest;
import com.example.demo.util.JwtUtil;

@RestController
public class HomeController 
{
	
	 @Autowired
	 private JwtUtil  jwtUtil;
	 
	 @Autowired
	 private AuthenticationManager authenticationmanager;
	 
	 @GetMapping("/welcome")
	 public String welcome() 
	 {
	        return "Welcome to javatechie !!";
	 }
	 
	 @PostMapping("/authenticate")
	 public String generatetocken(@RequestBody AuthRequest authRequest) throws Exception
	 {
		 try 
		 {
	            authenticationmanager.authenticate(
	                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
	            );
	     } 
		 catch (Exception ex) 
		 {
	            throw new Exception("inavalid username/password");
	     }
	     return jwtUtil.generateToken(authRequest.getUserName());
		 
	 }
}
