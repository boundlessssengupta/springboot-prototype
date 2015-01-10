/**
 * 
 */
package com.boundlessgeo.ps.springbootprototype.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author ssengupta
 *
 */
@Entity
public class OrgUser {
	@Id
	@Column(name = "org_user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String email;

	private String password;

	private String firstName;

	private String lastName;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "org_id", referencedColumnName = "org_id")
	private Organization organization;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "role_id", referencedColumnName = "role_id")
	private Role role;

	protected OrgUser() {

	}

	/**
	 * @param email
	 * @param password
	 * @param firstName
	 * @param lastName
	 */
	public OrgUser(String email, String password, String firstName,
			String lastName) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the organization
	 */
	public Organization getOrganization() {
		return organization;
	}

	/**
	 * @param organization
	 *            the organization to set
	 */
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new StringBuffer().append("OrgUser[id=").append(this.id)
				.append(", email=").append(this.email).append(", firstName=")
				.append(this.firstName).append(", lastName=")
				.append(this.lastName).append("organization=")
				.append(this.organization).append(", role=").append(this.role)
				.append("]").toString();
	}
}
