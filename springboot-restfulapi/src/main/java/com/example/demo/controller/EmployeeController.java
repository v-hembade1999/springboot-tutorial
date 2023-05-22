package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.empservice;

@RestController
public class EmployeeController 
{
	@Autowired
	empservice service;
	
	//get all employee data
	@GetMapping("/employees")
	public List<Employee> allemp()
	{
		return service.getallemployee();
	}
	
	//get sepecific employee data
	@GetMapping("/employee/{id}")
	public Employee getemployee(@PathVariable  int id)
	{
		return service.getbyid(id);
	}
	
	//to add employee
	@PostMapping("/addemployee")
	public void addemp(@RequestBody Employee emp)
	{
	    service.addemployee(emp);
	}
	
	//to delete employee
	@DeleteMapping("/deletemployee/{id}")
	public void delete(@PathVariable int id)
	{
		service.deleteemp(id);
	}
	
	//to update
	@PutMapping("/updateemployee/{id}")
	public void update(@RequestBody Employee e,@PathVariable int id)
	{
		service.updatemployee(e, id);
	}
	
	
}
