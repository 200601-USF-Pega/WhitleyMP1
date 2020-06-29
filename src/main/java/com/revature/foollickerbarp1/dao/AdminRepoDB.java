package com.revature.foollickerbarp1.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.foollickerbarp1.model.Bartender;
import com.revature.foollickerbarp1.web.ConnectionService;

public class AdminRepoDB {
	double tipAmount =0;
	
	public void addBartender(Bartender bartender) {
		try {
			PreparedStatement addBartender = ConnectionService.getConnection()
					.prepareStatement("INSERT INTO tips (bartender) VALUES (?);");
			addBartender.setString(1, bartender.getName());
			addBartender.setDouble(2, tipAmount);

			addBartender.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
	public List<Bartender> getAllBartenders() {

		List<Bartender> allBartenders = new ArrayList<Bartender>();
		try {
			Statement s = ConnectionService.getConnection().createStatement();
			s.executeQuery("SELECT * FROM tips;");

			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				Bartender b = new Bartender();
				b.setName(rs.getString("bartender"));
				b.setTipAmount(rs.getDouble("tip_amount"));
				allBartenders.add(b);
			}

			return allBartenders;
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
}
