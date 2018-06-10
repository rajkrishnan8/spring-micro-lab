package com.tripura.organizations.controller;

import com.tripura.organizations.model.Organization;
import com.tripura.organizations.services.OrganizationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping(value="v1/organizations")
public class OrganizationServiceController {
	@Autowired
	private OrganizationsService orgService;

	@RequestMapping(value="/{organizationId}", method=RequestMethod.GET)
	public Organization getOrganization(@PathVariable("organizationId") String organizationId) {
		return orgService.getOrg(organizationId);
	}

	@RequestMapping(value="/{organizationId}", method=RequestMethod.PUT)
	public void updateOrganization(@PathVariable("organizationId") String organizationId, @RequestBody Organization org) {
		orgService.updateOrg(org);
	}

	@RequestMapping(value="/new", method=RequestMethod.POST)
	public void saveOrganization(@RequestBody Organization org) {
		orgService.saveOrg(org);
	}

	@RequestMapping(value="/{organizationId}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteOrganization(@PathVariable("organizationId") String organizationId, @RequestBody Organization org) {
		orgService.deleteOrg(org);
	}
}
