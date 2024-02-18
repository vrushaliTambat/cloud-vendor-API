package com.firstproject.cloudvendorapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.firstproject.cloudvendorapi.exception.CloudVendorNotFoundException;
import com.firstproject.cloudvendorapi.model.CloudVendor;
import com.firstproject.cloudvendorapi.repository.CloudVendorRepository;
import com.firstproject.cloudvendorapi.service.CloudVendorService;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {
	
	CloudVendorRepository cloudVendorRepo;
	

	public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepo) {
		super();
		this.cloudVendorRepo = cloudVendorRepo;
	}

	@Override
	public String createCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepo.save(cloudVendor);
		return "success- created";
	}

	@Override
	public String updateCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepo.save(cloudVendor);
		return "sucess- updated";
	}

	@Override
	public String deleteCloudVendor(String cloudVendorId) {
		cloudVendorRepo.deleteById(cloudVendorId);
		return "deleted";
	}

	@Override
	public CloudVendor getCloudVendor(String cloudVendorId) {
		if(cloudVendorRepo.findById(cloudVendorId).isEmpty())
			throw new CloudVendorNotFoundException("Requested cloud Vendor does not exists");
			
		return cloudVendorRepo.findById(cloudVendorId).get();
		
	}

	@Override
	public List<CloudVendor> getAllCloudVendors() {
		return cloudVendorRepo.findAll();
	}

}
