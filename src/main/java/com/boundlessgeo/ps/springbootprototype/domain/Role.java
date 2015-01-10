/**
 * 
 */
package com.boundlessgeo.ps.springbootprototype.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ssengupta
 *
 */
@Entity
public class Role {
	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	protected Role() {

	}

	/**
	 * @param name
	 */
	public Role(String name) {
		super();
		this.name = name;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new StringBuffer("Role[id=").append(this.id).append(", name=")
				.append(this.name).append("]").toString();
	}

}
