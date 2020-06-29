package com.revature.foollickerbarp1.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.foollickerbarp1.model.Guest;
import com.revature.foollickerbarp1.model.Stock;
import com.revature.foollickerbarp1.web.ConnectionService;
//import com.revature.restdemobr3.model.Lesson;

public class StockRepoDB {
	/*
	 * ConnectionService connectionService;
	 * 
	 * public StockRepoDB(ConnectionService connectionService) {
	 * this.connectionService = connectionService; }
	 */
	public List<Stock> getAllItems() {
		try {
			List<Stock> result = new ArrayList<Stock>();

			try {
				Statement s = ConnectionService.getConnection().createStatement();
				s.executeQuery("SELECT * FROM stock;");

				ResultSet rs = s.getResultSet();
				while (rs.next()) {
					Stock stock = new Stock();
					stock.setAlcoholType(rs.getString("alcohol_type"));
					stock.setAlcoholName(rs.getString("alcohol_name"));
					stock.setAlcoholContent(rs.getInt("alcohol_content"));
					stock.setAlcoholPrice(rs.getInt("alcohol_price"));
					stock.setAlcoholAmount(rs.getInt("stockadmin"));
					result.add(stock);
				}

				return result;

			} catch (SQLException e) {
				System.out.println("Exception: " + e.getMessage());
				e.printStackTrace();
			}

			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addDrink(Stock stock) {
		try {
			PreparedStatement addDrink = ConnectionService.getConnection().prepareStatement(
					"INSERT INTO stock (alcohol_type, alcohol_name, alcohol_content, alcohol_price, stockadmin) VALUES (?, ?, ?, ?, ?);");
			addDrink.setString(1, stock.getAlcoholType());
			addDrink.setString(2, stock.getAlcoholName());
			addDrink.setInt(3, stock.getAlcoholContent());
			addDrink.setInt(4, stock.getAlcoholPrice());
			addDrink.setInt(5, stock.getAlcoholAmount());
			addDrink.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

	public void deleteDrink(Stock stock) {
		try {
			PreparedStatement deleteDrink = ConnectionService.getConnection()
					.prepareStatement("DELETE FROM stock WHERE stock.alcohol_name = ?;");

			deleteDrink.setString(1, stock.getAlcoholName());

			deleteDrink.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
}