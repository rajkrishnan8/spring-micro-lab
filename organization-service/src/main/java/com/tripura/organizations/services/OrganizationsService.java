package com.tripura.organizations.services;

import com.tripura.organizations.model.Organization;
import com.tripura.organizations.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrganizationsService {

	@Autowired
	private OrganizationRepository orgRepository;

	public Organization getOrg(String organizationId) {
		return orgRepository.findById(organizationId);
	}

	public void updateOrg(Organization org) {
		orgRepository.save(org);
	}

	public void saveOrg(Organization org) {
		org.setId(UUID.randomUUID().toString());

		orgRepository.save(org);
	}

	public void deleteOrg(Organization org) {
		orgRepository.delete(org);
	}
}