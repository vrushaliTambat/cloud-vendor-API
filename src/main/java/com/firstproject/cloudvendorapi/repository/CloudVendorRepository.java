package com.firstproject.cloudvendorapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstproject.cloudvendorapi.model.CloudVendor;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String>{

}
