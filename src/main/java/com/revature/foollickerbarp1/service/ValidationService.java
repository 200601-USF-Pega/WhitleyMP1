package com.revature.foollickerbarp1.service;

import java.util.List;

import com.revature.foollickerbarp1.dao.GuestRepoDB;
import com.revature.foollickerbarp1.model.Guest;


public class ValidationService {
	public boolean usernameExistsValidation(String username) {
		GuestRepoDB guest = new GuestRepoDB();
		List<Guest> guests = guest.getAllGuests();
		
		for (int i = 0; i < guests.size(); i++) {
			String guest1 = guests.get(i).getUsername();
			if (guest1.equalsIgnoreCase(username)) {
				return true;
			}
		}
		return false;
	}
}
