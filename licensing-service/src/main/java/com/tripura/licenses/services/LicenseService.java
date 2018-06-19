package com.tripura.licenses.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tripura.licenses.clients.OrganizationDiscoveryClient;
import com.tripura.licenses.clients.OrganizationFeignClient;
import com.tripura.licenses.clients.OrganizationRestTemplateClient;
import com.tripura.licenses.config.ServiceConfig;
import com.tripura.licenses.model.License;
import com.tripura.licenses.model.Organization;
import com.tripura.licenses.repository.LicenseRepository;

@Service
public class LicenseService {

	@Autowired
	private LicenseRepository licenseRepository;

	@Autowired
	private ServiceConfig config;

	@Autowired
	private OrganizationDiscoveryClient organizationDiscoveryClient;
	
	@Autowired
	private OrganizationRestTemplateClient organizationRestTemplateClient;
	
	@Autowired
	private OrganizationFeignClient organizationFeignClient;

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

	private void randomlyRunLong() {
		Random rand = new Random();
		
		int randomNum = rand.nextInt(3) + 1;
		
		if (randomNum == 3) sleep();
	}
	
	private void sleep() {
		try {
			Thread.sleep(11000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@HystrixCommand(fallbackMethod = "buildFallbackLicenseList",
			threadPoolKey = "licenseByOrgThreadPool",
			threadPoolProperties = 
				{@HystrixProperty(name = "coreSize", value = "30"),
				@HystrixProperty(name = "maxQueueSize", value = "10")}
	)
	public List<License> getLicenseByOrg(String organizationId) {
		randomlyRunLong();
		return licenseRepository.findByOrganizationId(organizationId);
	}
	
	private List<License> buildFallbackLicenseList(String organizationId) {
		List<License> fallbackList = new ArrayList<>();
		License license = new License()
				.withId("00000000-00-00000000")
				.withOrganizationId(organizationId)
				.withProductName("Sorry no licensing information currently available.");
		fallbackList.add(license);
		return fallbackList;
	}

	public Organization retrieveOrgInfo(String organizationId, String clientType) {
		Organization organization = null;

		switch (clientType) {
			case "feign":
				organization = organizationFeignClient.getOrganization(organizationId);
				break;
			case "rest":
				System.out.println("I am using the rest template client.");
				organization = organizationRestTemplateClient.getOrganization(organizationId);
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