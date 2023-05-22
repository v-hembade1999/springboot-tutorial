package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface empservice 
{
	List<Employee> getallemployee();
	Employee getbyid(int id);
	String addemployee(Employee emp);
	void deleteemp(int id);
	void updatemployee(Employee emp,int id);
	
}
