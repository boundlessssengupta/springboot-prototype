/**
 * 
 */
package com.boundlessgeo.ps.springbootprototype.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ssengupta
 *
 */
public interface OrganizationRepository extends
		JpaRepository<Organization, Long> {
	Organization findByName(String name);
}
