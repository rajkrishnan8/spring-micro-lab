package com.tripura.organizations.repository;

import com.tripura.organizations.model.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, String> {
	public Organization findById(String id);
}