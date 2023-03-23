package com.example.springboot.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.springboot.entity.users;

public interface usersrepo extends CrudRepository<users,Integer> 
{
	//custom finder methods
	public List<users> findByName(String name);
	public List<users> findByNameAndCity(String name, String city);
	public List<users> findByNameStartingWith(String prefix);
	public List<users> findByNameEndingWith(String suffix);
	public List<users> findByNameContaining(String words);

}
