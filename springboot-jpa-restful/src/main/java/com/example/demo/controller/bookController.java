package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.bookservice;
import com.example.demo.entity.book;

@RestController
public class bookController 
{
	
	@Autowired
	private bookservice service;
	
	@GetMapping(path = "/books")
	public ResponseEntity<List<book>> getbooks() 
	{
		List<book> list = this.service.getallbooks();
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	@GetMapping(path="/books/{id}")
	public ResponseEntity<book> getbook(@PathVariable("id") int id)
	{
	   book b = this.service.getbook(id);
	   if(b==null)
	   {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	   }
	   return ResponseEntity.of(Optional.of(b));
	}
	
	
	@PostMapping(path="/books")
	public ResponseEntity<book> addbook(@Validated @RequestBody book b)
	{
		try
		{
			book k = this.service.addbook(b);
			return ResponseEntity.of(Optional.of(k));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}			
	}
	
	@DeleteMapping(path="/books/{id}")
	public ResponseEntity<Void> deletebook(@PathVariable("id") int id)
	{
		try
		{
			this.service.deletebook(id);
			return ResponseEntity.ok().build();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping(path="/books/{id}")
	public ResponseEntity<book> updatebook(@RequestBody book b,@PathVariable("id") int id)
	{
		try
		{
			this.service.updatebook(b,id);
			return ResponseEntity.ok().body(b);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}

}
