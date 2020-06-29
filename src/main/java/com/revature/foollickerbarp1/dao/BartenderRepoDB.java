package com.revature.foollickerbarp1.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.foollickerbarp1.model.Bartender;
import com.revature.foollickerbarp1.model.Guest;
import com.revature.foollickerbarp1.model.Stock;
import com.revature.foollickerbarp1.web.ConnectionService;

public class BartenderRepoDB {
	
	public void tipBartender(Bartender bartender) {
		try {
			PreparedStatement tip = ConnectionService.getConnection()
					.prepareStatement("UPDATE tips SET tip_amount = tip_amount + ? WHERE bartender = ?");

			tip.setDouble(1, bartender.getTipAmount());
			tip.setString(2, bartender.getUsername());
			tip.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	public List<Guest> getAllGuests() {

		List<Guest> allGuests = new ArrayList<Guest>();
		try {
			Statement s = ConnectionService.getConnection().createStatement();
			s.executeQuery("SELECT * FROM users WHERE users.account_type = 'Guest';");

			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				Guest g = new Guest();
				g.setName(rs.getString("user_actual_name"));
				g.setUsername(rs.getString("username"));
				allGuests.add(g);
			}

			return allGuests;
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

}
