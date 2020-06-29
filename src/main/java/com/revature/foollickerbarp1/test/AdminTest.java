package com.revature.foollickerbarp1.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.foollickerbarp1.model.Admin;

public class AdminTest {

	Admin admin = new Admin();

	@Test
	public void testCodeName() {
		admin.setCodeName("Ninja");
		assertEquals("Ninja",admin.getCodeName());
	}
	
	@Test
	public void testUsername() {
		admin.setUsername("Jay");
		assertEquals("Jay",admin.getUsername());
	}
	
	@Test
	public void testPassword() {
		admin.setPassword("password");
		assertEquals("password",admin.getPassword());
	}
}
