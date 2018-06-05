package com.tripura.licenses.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="licenses")
public class License {
	@Id
	@Column(name="license_id", nullable=false)
	private String licenseId;

	@Column(name="license_type", nullable=false)
	private String licenseType;

	@Column(name="product_name", nullable=false)
	private String productName;

	@Column(name="organization_id", nullable=false)
	private String organizationId;

	@Column(name="comment")
	private String comment;

	public String getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
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

	public License withLicenseId(String licenseId) {
		setLicenseId(licenseId);
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
}