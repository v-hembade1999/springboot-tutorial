package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CloudVendor;

public interface CloudVenderRepository  extends JpaRepository<CloudVendor,String>
{
	 List<CloudVendor> findByVendorName(String vendorName);
} 
