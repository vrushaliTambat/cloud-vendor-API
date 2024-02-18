package com.firstproject.cloudvendorapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstproject.cloudvendorapi.model.CloudVendor;
import com.firstproject.cloudvendorapi.service.CloudVendorService;

@RequestMapping("/cloudvendor")
@RestController
public class CloudVendorController {
	
	CloudVendorService cloudVendorService;
	
	
	public CloudVendorController(CloudVendorService cloudVendorService) {
		super();
		this.cloudVendorService = cloudVendorService;
	}

	//Since it is request parameter that's why it is given like this in curly braces inside the get mapping
	@GetMapping("{vendorId}")
	public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
		
		return cloudVendorService.getCloudVendor(vendorId);
				//new CloudVendor("C1","Vendor 1","Address One","xxxx");
	}
	
	@GetMapping()
	public List<CloudVendor> getAllCloudVendorDetails() {
		return cloudVendorService.getAllCloudVendors();
	}
	
	@PostMapping
	public String createCloudVendorDetails(@RequestBody CloudVendor cloudvendor) {
		cloudVendorService.createCloudVendor(cloudvendor);
		return  "Vendor created Succesfully";
	}
	
	@PutMapping
	public String updateCloudVendorDetails(@RequestBody CloudVendor cloudvendor) {
		cloudVendorService.updateCloudVendor(cloudvendor);
		return  "Vendor updated Succesfully";
	}
	
	@DeleteMapping("{vendorId}")
	public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
		cloudVendorService.deleteCloudVendor(vendorId);
		return  "Cloud Vendor deleted Succesfully";
	}
	
}
