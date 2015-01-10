package com.boundlessgeo.ps.springbootprototype.domain.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.boundlessgeo.ps.springbootprototype.SpringBootPrototypeApplication;
import com.boundlessgeo.ps.springbootprototype.domain.OrgUser;
import com.boundlessgeo.ps.springbootprototype.domain.OrgUserRepository;
import com.boundlessgeo.ps.springbootprototype.domain.OrganizationRepository;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootPrototypeApplication.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup("/testdata/data.xml")
public class OrgUserRepositoryTests {

	@Autowired
	OrgUserRepository orgUserRepository;

	@Autowired
	OrganizationRepository organizationRepository;

	@Test
	public void testFindByEmail() {
		OrgUser orgUser = orgUserRepository.findByEmail("soumya@sengupta.name");

		assertThat(orgUser, notNullValue());
		assertThat(orgUser.getOrganization().getOrgUsers().size(), equalTo(2));
		assertThat(orgUser.getFirstName(), equalTo("Soumya"));
	}

	@Test
	public void testFindByOrganizationName() {
		List<OrgUser> orgUsers = orgUserRepository.findByOrganizationName("01");

		assertThat(orgUsers, notNullValue());
		assertThat(orgUsers.size(), equalTo(2));
	}

	@Test
	public void testFindByRoleNameAndOrganizationName() {
		List<OrgUser> orgUsers = orgUserRepository
				.findByRoleNameAndOrganizationName("ADMIN", "01");

		assertThat(orgUsers, notNullValue());
		assertThat(orgUsers.size(), equalTo(1));
		assertThat(orgUsers.get(0).getFirstName(), equalTo("Soumya"));
	}

}
