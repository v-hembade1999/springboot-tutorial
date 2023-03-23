package com.example.demo.entity;

import java.awt.print.Book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="auther")
public class Auther 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int aid;
	public String authername;
	public String autherlang;
	@OneToOne(mappedBy="auther")
	@JsonBackReference
	public book book;
	
	public book getBook() {
		return book;
	}
	public void setBook(book book) {
		this.book = book;
	}
	public int getAid() 
	{
		return aid;
	}
	public void setAid(int aid) 
	{
		this.aid = aid;
	}
	public String getAuthername() 
	{
		return authername;
	}
	public void setAuthername(String authername) 
	{
		this.authername = authername;
	}
	public String getAutherlang() 
	{
		return autherlang;
	}
	public void setAutherlang(String autherlang) 
	{
		this.autherlang = autherlang;
	}
}
