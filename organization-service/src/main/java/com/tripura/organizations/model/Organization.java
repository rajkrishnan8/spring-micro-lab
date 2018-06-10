package com.tripura.organizations.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="organizations")
public class Organization {
	@Id
	@Column(name = "id", nullable=false)
	private String id;

	@Column(name = "name", nullable=false)
	private String name;

	@Column(name = "contact_name", nullable=false)
	private String contactName;

	@Column(name = "contact_phone", nullable=false)
	private String contactPhone;

	@Column(name = "contact_email", nullable=false)
	private String contactEmail;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName() {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
}