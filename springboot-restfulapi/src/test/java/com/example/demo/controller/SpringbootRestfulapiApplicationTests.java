package com.example.demo.controller;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.*;
import com.example.demo.entity.Employee;
import com.example.demo.service.empservice;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
class SpringbootRestfulapiApplicationTests 
{
	  
	  
	    @Autowired private MockMvc mockMvc;
	    @Autowired private ObjectMapper objectMapper;
	    @MockBean private empservice service;
	    
	    Employee e1;
	    Employee e2;
	    List<Employee> list = new ArrayList<Employee>(); 
	    
	    
	    @BeforeEach()
	    void setup()
	    {
	    	Employee e1 = new Employee(1,"rock1","jack1");
	    	Employee e2 = new Employee(2,"rock2","jack2");
	    	list.add(e1);
	    	list.add(e2);
	    }
    
    @Test
    public void testAddShouldReturn200Created() throws Exception 
    {
    	Employee e3 = new Employee(11,"rock1","jack1");
        Mockito.when(service.addemployee(e3)).thenReturn("added sucessfully");
     
        String requestBody = objectMapper.writeValueAsString(e3);
     
        mockMvc.perform(post("/addemployee").contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andDo(print()).andExpect(status().isOk());
      
    }
    
    
    @Test
    public void testgetallemployees() throws Exception
    {
        Mockito.when(service.getallemployee()).thenReturn(list);
        mockMvc.perform(get("/employees"))
        .andDo(print()).andExpect(status().isOk());
    }
    
    @Test
    public void testgetemployeebyid() throws Exception
    {
    	Employee e4 = new Employee(11,"rock1","jack1");
    	Mockito.when(service.getbyid(22)).thenReturn(e4);
    	 mockMvc.perform(get("/employee/" + 22))
                 .andDo(print()).andExpect(status().isOk());
    }
     

}
