package com.tripura.licenses.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tripura.licenses.model.Organization;

@FeignClient("organizationservice")
public interface OrganizationFeignClient {
	@RequestMapping(value="/v1/organizations/{organizationId}",
			method=RequestMethod.GET, consumes="application/json")
	public Organization getOrganization(
			@PathVariable("organizationId") String organizationId);
}
