package com.tripura.licenses.controllers;

import com.tripura.licenses.model.License;
import com.tripura.licenses.services.LicenseService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(value="/v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

	@Autowired
	private LicenseService licenseService;

	@RequestMapping(value="/{licenseId}", method=RequestMethod.GET)
	public License getLicenses(
		@PathVariable("organizationId") String organizationId, 
		@PathVariable("licenseId") String licenseId) {
		return licenseService.getLicense(organizationId, licenseId);
	}
}