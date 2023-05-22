package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CloudVendor;

public interface CloudVendorService 
{
	 public String createCloudVendor(CloudVendor cloudVendor);
	 public String updateCloudVendor(CloudVendor cloudVendor);
	 public String deleteCloudVendor(String cloudVendorId);
	 public CloudVendor getCloudVendor(String cloudVendorId);
	 public List<CloudVendor> getAllCloudVendors();
	 public List<CloudVendor> getByVendorName(String vendorName);
}
