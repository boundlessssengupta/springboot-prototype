/**
 * 
 */
package com.boundlessgeo.ps.springbootprototype.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ssengupta
 *
 */
public interface OrgUserRepository extends JpaRepository<OrgUser, Long> {
	OrgUser findByEmail(String email);

	List<OrgUser> findByOrganizationName(String name);

	List<OrgUser> findByRoleNameAndOrganizationName(String roleName,
			String organizationName);
}
