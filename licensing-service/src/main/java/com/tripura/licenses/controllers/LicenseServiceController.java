package com.tripura.licenses.controllers;

import com.tripura.licenses.model.License;
import com.tripura.licenses.services.LicenseService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping(value="/v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

	@Autowired
	private LicenseService licenseService;

	@RequestMapping(value="/{licenseId}", method=RequestMethod.GET)
	public License getLicenses(
		@PathVariable("organizationId") String organizationId, 
		@PathVariable("licenseId") String licenseId) {
		return licenseService.getLicense(organizationId, licenseId, "");
	}

	@RequestMapping(value="/{licenseId}/{clientType}", method = RequestMethod.GET)
	public License getLicenseWithClient(
		@PathVariable("organizationId") String organizationId,
		@PathVariable("licenseId") String licenseId,
		@PathVariable("clientType") String clientType) {

		return licenseService.getLicense(organizationId, licenseId, clientType);
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<License> getLicenseByOrg(
			@PathVariable("organizationId") String organizationId) {
		
		return licenseService.getLicenseByOrg(organizationId);
	}
}