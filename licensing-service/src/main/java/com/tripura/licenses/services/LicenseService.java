package com.tripura.licenses.services;

import com.tripura.licenses.config.ServiceConfig;
import com.tripura.licenses.model.License;
import com.tripura.licenses.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LicenseService {

	@Autowired
	private LicenseRepository licenseRepository;

	@Autowired
	private ServiceConfig config;

	public License getLicense(String organizationId, String licenseId) {
		License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
		return license.withComment(config.getExampleProperty());
	}

	public List<License> getLicenseByOrg(String organizationId) {
		return licenseRepository.findByOrganizationId(organizationId);
	}

	public void saveLicense(License license) {
		license.withLicenseId(UUID.randomUUID().toString());
		licenseRepository.save(license);
	}
}