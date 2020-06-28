package com.revature.foollickerbarp1.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.foollickerbarp1.model.Guest;
import com.revature.foollickerbarp1.web.ConnectionService;



public class GuestRepoDB {
	
	public void addGuest(Guest guest) {
		try {
			PreparedStatement s = ConnectionService.getConnection().prepareStatement("INSERT INTO public.users (username, account_type, user_password, user_actual_name) VALUES (?, ?, ?, ?);");
			s.setString(1, guest.getUsername());
			s.setString(2, guest.getAccountType()); 
			s.setString(3, guest.getPassword());
			s.setString(4, guest.getName());
			s.execute();
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
}
