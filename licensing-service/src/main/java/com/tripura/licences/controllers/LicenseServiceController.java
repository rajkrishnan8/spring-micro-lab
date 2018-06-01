package com.tripura.licenses.controllers;

import com.tripura.licenses.model.License;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value="/v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

	@RequestMapping(value="/{licenseId}", method=RequestMethod.GET)
	public License getLicenses(
		@PathVariable("organizationId") String organizationId, 
		@PathVariable("licenseId") String licenseId) {
		return new License()
		.withLicenseId(licenseId)
		.withProductName("Teleco")
		.withLicenseType("Seat")
		.withOrganizationId(organizationId);
	}
}