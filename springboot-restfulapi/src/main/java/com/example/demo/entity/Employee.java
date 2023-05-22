package com.example.demo.entity;


public class Employee 
{
	private int id;
	private String empname;
	private String empdept;
	public Employee(int id, String empname, String empdept) 
	{
		super();
		this.id = id;
		this.empname = empname;
		this.empdept = empdept;
	}
	public Employee() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpdept() {
		return empdept;
	}
	public void setEmpdept(String empdept) {
		this.empdept = empdept;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empname=" + empname + ", empdept=" + empdept + "]";
	}
	
	
	
	
	
}
