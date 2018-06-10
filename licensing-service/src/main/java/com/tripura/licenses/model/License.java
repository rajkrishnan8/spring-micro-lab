package com.tripura.licenses.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="licenses")
public class License {
	@Id
	@Column(name="id", nullable=false)
	private String id;

	@Column(name="license_type", nullable=false)
	private String licenseType;

	@Column(name="product_name", nullable=false)
	private String productName;

	@Column(name="organization_id", nullable=false)
	private String organizationId;

	@Column(name="comment")
	private String comment;

	@Transient
	private String organizationName;

	@Transient
	private String contactName;

	@Transient
	private String contactPhone;

	@Transient
	private String contactEmail;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public License withId(String id) {
		setId(id);
		return this;
	}

	public License withLicenseType(String licenseType) {
		setLicenseType(licenseType);
		return this;
	}

	public License withProductName(String productName) {
		setProductName(productName);
		return this;
	}

	public License withOrganizationId(String organizationId) {
		setOrganizationId(organizationId);
		return this;
	}

	public License withComment(String comment) {
		setComment(comment);
		return this;
	}

	public License withOrganizationName(String organizationName) {
		setOrganizationName(organizationName);
		return this;
	}

	public License withContactName(String contactName) {
		setContactName(contactName);
		return this;
	}

	public License withContactEmail(String contactEmail) {
		setContactEmail(contactEmail);
		return this;
	}

	public License withContactPhone(String contactPhone) {
		setContactPhone(contactPhone);
		return this;
	}
}