package com.qa.ims.persistence.domain;



import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class LoginTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Login.class).verify();
	}

}
