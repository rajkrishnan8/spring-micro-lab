package com.tripura.licenses.services;

import com.tripura.licenses.config.ServiceConfig;
import com.tripura.licenses.model.License;
import com.tripura.licenses.model.Organization;
import com.tripura.licenses.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tripura.licenses.clients.OrganizationDiscoveryClient;

import java.util.List;
import java.util.UUID;

@Service
public class LicenseService {

	@Autowired
	private LicenseRepository licenseRepository;

	@Autowired
	private ServiceConfig config;

	@Autowired
	private OrganizationDiscoveryClient organizationDiscoveryClient;

	public License getLicense(String organizationId, String licenseId, String clientType) {
		License license = licenseRepository.findByOrganizationIdAndId(organizationId, licenseId);

		Organization org = retrieveOrgInfo(organizationId, clientType);

		return license
			.withOrganizationName(org.getName())
			.withContactName(org.getContactName())
			.withContactEmail(org.getContactEmail())
			.withContactPhone(org.getContactPhone())
			.withComment(config.getExampleProperty());
	}

	public List<License> getLicenseByOrg(String organizationId) {
		return licenseRepository.findByOrganizationId(organizationId);
	}

	public Organization retrieveOrgInfo(String organizationId, String clientType) {
		Organization organization = null;

		switch (clientType) {
			case "feign":
				break;
			case "rest":
				break;
			case "discovery":
			default:
				System.out.println("I am using the dicovery client.");
				organization = organizationDiscoveryClient.getOrganization(organizationId);
		}

		return organization;
	}

	public void saveLicense(License license) {
		license.setId(UUID.randomUUID().toString());
		
		licenseRepository.save(license);
	}

	public void updateLicense(License license) {
		licenseRepository.save(license);
	}

	public void deleteLicense(License license) {
		licenseRepository.delete(license.getId());
	}
}