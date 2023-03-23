package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class book 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String book;
	@OneToOne(cascade=CascadeType.ALL)
	private Auther auther;
	public book(int id, String title, String book, Auther auther) 
	{
		super();
		this.id = id;
		this.title = title;
		this.book = book;
		this.auther = auther;
	}
	public book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public Auther getAuther() {
		return auther;
	}
	public void setAuther(Auther auther) {
		this.auther = auther;
	}
	@Override
	public String toString() {
		return "book [id=" + id + ", title=" + title + ", book=" + book + ", auther=" + auther + "]";
	}
	
	
	
}
