package com.example.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_tb")
public class users 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String city;
	public users(int id, String name, String city) 
	{
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	public users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "users [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	
	
}
