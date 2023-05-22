package com.example.demo.controller;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.entity.CloudVendor;
import com.example.demo.service.CloudVendorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@WebMvcTest(CloudVendorController.class)
class CloudVendorControllerTest 
{
	@Autowired
	private MockMvc mockMvc;
	
    @MockBean
	private CloudVendorService cloudVendorService; 
    
    CloudVendor cloudvendor1;
    CloudVendor cloudvendor2;
    List<CloudVendor> vendorlist = new ArrayList<CloudVendor>();
    

	@BeforeEach
	void setUp() throws Exception 
	{
		cloudvendor1 = new CloudVendor("1","aws","pune","xxxxx");
		cloudvendor2 = new CloudVendor("2","gcp","pune","xxxxx");
		vendorlist.add(cloudvendor1);
		vendorlist.add(cloudvendor2);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreatecloudvendor() throws Exception 
	{
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(cloudvendor1); 
        when(cloudVendorService.createCloudVendor(cloudvendor1)).thenReturn("Success");
        this.mockMvc.perform(post("/addcloudvendor")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
        .andDo(print()).andExpect(status().isOk());
	}

	@Test
	void testUpdatecloudvendor() throws Exception 
	{
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(cloudvendor1);
		when(cloudVendorService.createCloudVendor(cloudvendor1)).thenReturn("Success");
        this.mockMvc.perform(put("/updatecloudvendor")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
        .andDo(print()).andExpect(status().isOk());
	}
		

	@Test
	void testDeletecloudvendor() throws Exception 
	{
		when(cloudVendorService.deleteCloudVendor("2")).thenReturn("vendor deleted succesfully");
		this.mockMvc.perform(delete("/cloudvendor/" + "2")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	void testGetAllCloudVendorDetails() throws Exception 
	{
		when(cloudVendorService.getAllCloudVendors()).thenReturn(vendorlist);
		this.mockMvc.perform(get("/cloudvendors")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	void testGetCloudVendorById() throws Exception 
	{
		when(cloudVendorService.getCloudVendor("1")).thenReturn(cloudvendor1);
		this.mockMvc.perform(get("/cloudvendor/" + "1")).andDo(print()).andExpect(status().isOk());
	}

}
