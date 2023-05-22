package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CloudVendor;
import com.example.demo.service.CloudVendorService;

@RestController
public class CloudVendorController 
{
	@Autowired
	private CloudVendorService service;
	
	@PostMapping("/addcloudvendor")
    public String createcloudvendor(@RequestBody CloudVendor cloudvendor)
    {
		service.createCloudVendor(cloudvendor);
		return "cloudvendor created successfully";
    	
    }
	
	@PutMapping("/updatecloudvendor")
	public String updatecloudvendor(@RequestBody CloudVendor cloudvendor)
	{
		service.updateCloudVendor(cloudvendor);
		return "cloudvendor updated successfully";
		
	}
	
	@DeleteMapping("/cloudvendor/{vendorId}")
	public String deletecloudvendor(@PathVariable("vendorId") String vendorId)
	{
		service.deleteCloudVendor(vendorId);
		return "cloudvendor deleted successfully";
	}
	
	@GetMapping("/cloudvendors")
    public List<CloudVendor> getAllCloudVendorDetails()
    {
        return service.getAllCloudVendors();
    }
	
	
	
	@GetMapping("/cloudvendor/{VendorId}")
    public CloudVendor getCloudVendorById(@PathVariable("VendorId") String VendorId)
    {
        return service.getCloudVendor(VendorId);
    }
	
	

	
}
