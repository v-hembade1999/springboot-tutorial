package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.bookrepo;
import com.example.demo.entity.book;
@Service
public class bookservice 
{
	@Autowired
	private bookrepo repo;
	
	public List<book> getallbooks()
	{
		List<book> l1 = (List<book>) this.repo.findAll();
		return l1;
	}
	
	public book getbook(int id)
	{
		book b=null;
		try
		{
			b = this.repo.findById(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}
	
	public book addbook(book b)
	{
		book result = repo.save(b);
		return result;
	}
	
	public void deletebook(int id)
	{
		repo.deleteById(id);
	}
	
	public void updatebook(book b,int id)
	{
		b.setId(id);
		repo.save(b);
	}
}
