package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Employee;
@Service
public class empserviceimpl implements empservice 
{
	List<Employee> emplist = new ArrayList<>(Arrays.asList(new Employee(1,"sam","cse"),
	                                       new Employee(2,"jack","etc"),
	                                       new Employee(3,"rock","civil")));

	@Override
	public List<Employee> getallemployee() 
	{
		// TODO Auto-generated method stub
		return emplist;
	}

	@Override
	public Employee getbyid(int id) 
	{
		// TODO Auto-generated method stub
		return emplist.stream().filter(e -> e.getId()==id).findFirst().get();
	}

	@Override
	public String addemployee(Employee emp) 
	{
		// TODO Auto-generated method stub
		emplist.add(emp);
		return "sucess";
		
	}

	@Override
	public void deleteemp(int id) 
	{
		// TODO Auto-generated method stub
		emplist.remove(id);
		
	}

	@Override
	public void updatemployee(Employee emp , int id) 
	{
		// TODO Auto-generated method stub4
		for(int i=0;i<emplist.size();i++)
		{
			Employee e = emplist.get(i);
			if(e.getId()==id)
			{
				emplist.set(i, emp);
				return ;
			}
		}
		
	}
}
