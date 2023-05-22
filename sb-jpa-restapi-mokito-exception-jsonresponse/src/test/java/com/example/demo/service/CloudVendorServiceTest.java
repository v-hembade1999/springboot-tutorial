package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entity.CloudVendor;
import com.example.demo.repository.CloudVenderRepository;

@ExtendWith(MockitoExtension.class)
class CloudVendorServiceTest 
{
	@Mock
	private CloudVenderRepository cloudvendorrepository;
	
	@InjectMocks
	private  CloudVendorServiceImpl cloudvendorservice;
	
	CloudVendor cloudvendor;
	
    @BeforeEach
    public void setUp()
    {
    	cloudvendor = new CloudVendor("1","amazon","usa","xxxxx");			
    }
	
	@Test
	void testCreateCloudVendor() 
	{
		when(cloudvendorrepository.save(cloudvendor)).thenReturn(cloudvendor);
		assertThat(cloudvendorservice.createCloudVendor(cloudvendor)).isEqualTo("Success");
	}

	@Test
	void testUpdateCloudVendor() 
	{
		when(cloudvendorrepository.save(cloudvendor)).thenReturn(cloudvendor);
		assertThat(cloudvendorservice.updateCloudVendor(cloudvendor)).isEqualTo("Success");
	}

	@Test
	void testDeleteCloudVendor() 
	{
		doNothing().when(cloudvendorrepository).deleteById(cloudvendor.getVendorId());
		cloudvendorservice.deleteCloudVendor(cloudvendor.getVendorId());
		verify(cloudvendorrepository,times(1)).deleteById(cloudvendor.getVendorId());
	}

	@Test
	void testGetCloudVendor() 
	{
		  when(cloudvendorrepository.findById("1")).thenReturn(Optional.ofNullable(cloudvendor));
          assertThat(cloudvendorservice.getCloudVendor("1").getVendorName())
	                .isEqualTo(cloudvendor.getVendorName());
	}

	@Test
	void testGetAllCloudVendors() 
	{
		when(cloudvendorrepository.findAll()).thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudvendor)));
		assertThat(cloudvendorservice.getAllCloudVendors().get(0).getVendorPhoneNumber()).
        isEqualTo(cloudvendor.getVendorPhoneNumber());
	}

	@Test
	void testGetByVendorName() 
	{
		when(cloudvendorrepository.findByVendorName("amazon")).thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudvendor)));
		assertThat(cloudvendorservice.getByVendorName("amazon").get(0).getVendorId()).
        isEqualTo(cloudvendor.getVendorId());
	}

}
