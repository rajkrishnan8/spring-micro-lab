package com.tripura.licenses.repository;

import com.tripura.licenses.model.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseRepository extends CrudRepository<License, String>{
	public List<License> findByOrganizationId(String organizationId);
	public License findByOrganizationIdAndId(String organizationId, String licenseId);
}