package com.revature.foollickerbarp1.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.foollickerbarp1.model.Bartender;

public class BartenderTest {
	Bartender bartender = new Bartender();
	
	@Test
	public void usernameTest() {
		bartender.setName("Jacob");
		assertEquals("Jacob",bartender.getName());
	}
	
	@Test
	public void tipTest() {
		bartender.setTipAmount(100.97);
		assert(bartender.getTipAmount()==100.97);
	}
	
	@Test
	public void tipTest2() {
		bartender.setTipAmount(100.97);
		assert(bartender.getTipAmount()!=100);
	}
}
