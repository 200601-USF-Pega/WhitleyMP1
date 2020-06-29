package com.revature.foollickerbarp1.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.foollickerbarp1.model.Guest;

public class GuestTest {

	Guest guest = new Guest();

	@Test
	public void testUsername() {
		guest.setUsername("Mustard");
		assertEquals("Mustard", guest.getUsername());
	}

	@Test
	public void testAccountType() {
		guest.setAccountType("Guest");
		assertEquals("Guest", guest.getAccountType());
	}

	@Test
	public void testName() {
		guest.setName("Max");
		assertEquals("Max", guest.getName());
	}

	@Test
	public void testPassword() {
		guest.setPassword("password");
		assertEquals("password", guest.getPassword());
	}
}
