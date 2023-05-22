package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CloudVendor;
import com.example.demo.repository.CloudVenderRepository;

@Service
public class CloudVendorServiceImpl  implements CloudVendorService
{
	@Autowired
	private CloudVenderRepository repository;



	@Override
	public String createCloudVendor(CloudVendor cloudVendor) 
	{
		// TODO Auto-generated method stub
		repository.save(cloudVendor);
	    return "Success";
	}

	@Override
	public String updateCloudVendor(CloudVendor cloudVendor) 
	{
		// TODO Auto-generated method stub
		 repository.save(cloudVendor);
	     return "Success";
	}

	@Override
	public String deleteCloudVendor(String cloudVendorId) 
	{
		// TODO Auto-generated method stub
		repository.deleteById(cloudVendorId);
		return "Success";
	}

	@Override
	public CloudVendor getCloudVendor(String cloudVendorId) 
	{
		// TODO Auto-generated method stub
		return repository.findById(cloudVendorId).get();
	}

	@Override
	public List<CloudVendor> getAllCloudVendors() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<CloudVendor> getByVendorName(String vendorName) 
	{
		// TODO Auto-generated method stub
		return repository.findByVendorName(vendorName);
	}

	

}
