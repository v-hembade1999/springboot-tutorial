package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.book;

public interface bookrepo extends CrudRepository <book , Integer>
{
	public book findById(int id);
}
