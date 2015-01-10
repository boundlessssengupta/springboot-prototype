/**
 * 
 */
package com.boundlessgeo.ps.springbootprototype.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author ssengupta
 *
 */
@Entity
public class Organization {
	@Id
	@Column(name = "org_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private String type;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "organization")
	private List<OrgUser> orgUsers = new ArrayList<OrgUser>();

	protected Organization() {

	}

	public Organization(String name, String type) {
		this.name = name;
		this.type = type;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the orgUsers
	 */
	public List<OrgUser> getOrgUsers() {
		return orgUsers;
	}

	/**
	 * @param orgUsers
	 *            the orgUsers to set
	 */
	public void setOrgUsers(List<OrgUser> orgUsers) {
		this.orgUsers = orgUsers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new StringBuffer("Organization[id=").append(this.id)
				.append(", name=").append(this.name).append(", type=")
				.append(this.type).append("]").toString();
	}

}
