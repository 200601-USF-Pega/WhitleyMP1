package com.revature.foollickerbarp1.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.foollickerbarp1.model.Guest;
import com.revature.foollickerbarp1.web.ConnectionService;

public class GuestRepoDB {

	public void addGuest(Guest guest) {
		
		try {
			/*
			 * Statement s = ConnectionService.getConnection().createStatement(); s.
			 * executeUpdate("INSERT INTO users (username, account_type, user_password, user_actual_name) VALUES ('"
			 * + guest.getUsername() + "', '" + guest.getAccountType() + "', '" +
			 * guest.getPassword() + "', '" + guest.getName() + "');"); return guest;
			 */
			PreparedStatement s = ConnectionService.getConnection().prepareStatement(
					"INSERT INTO users (username, account_type, user_password, user_actual_name) VALUES (?, ?, ?, ?);");
			s.setString(1, guest.getUsername());
			s.setString(2, guest.getAccountType());
			s.setString(3, guest.getPassword());
			s.setString(4, guest.getName());
			s.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	public List<Guest> getAllGuests() {
		
		List<Guest> allGuests = new ArrayList<Guest>();
		try {
			Statement s = ConnectionService.getConnection().createStatement();
			s.executeQuery("SELECT username FROM users ;");//WHERE users.account_type = 'Guest'

			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				Guest g = new Guest();
				g.setUsername(rs.getString("username"));
				//g.setName(rs.getString("user_actual_name"));
				allGuests.add(g);
			}
			
			return allGuests;
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean checkGuest(String username, String password) {
		try {
			Statement guestStatement = ConnectionService.getConnection().createStatement();
			guestStatement.executeQuery("SELECT * FROM users;");
			
			ResultSet rs = guestStatement.getResultSet();
			while (rs.next()) {
				if (rs.getString("username").equals(username)) { //commented out equalsIgnoreCase
					if (rs.getString("user_password").equals(password)) {
						return true;
					} else {
						System.out.println("Wrong password");
						return false;
					}
				}
			}
			System.out.println("Username not found.");
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean checkAdmin(String username) {
		try {
			Statement s = ConnectionService.getConnection().createStatement();
			s.executeQuery("SELECT * FROM users WHERE users.account_type ='Admin';");
			
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				if (rs.getString("username").equalsIgnoreCase(username)) {
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("User not found.");
		return false;
	}
	
	public boolean checkBartender(String username) {
		try {
			Statement s = ConnectionService.getConnection().createStatement();
			s.executeQuery("SELECT * FROM users WHERE users.account_type ='Bartender';");
			
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				if (rs.getString("username").equalsIgnoreCase(username)) {
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("User not found.");
		return false;
	}
}
