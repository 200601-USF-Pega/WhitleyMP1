package com.revature.foollickerbarp1.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.foollickerbarp1.model.Stock;
import com.revature.foollickerbarp1.web.ConnectionService;
//import com.revature.restdemobr3.model.Lesson;

public class StockRepoDB {
	ConnectionService connectionService;

	public StockRepoDB(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}

	public List<Stock> getAllItems() {
		try {
			List<Stock> result = new ArrayList<Stock>();
			
			try {
				Statement s = ConnectionService.getConnection().createStatement();
				s.executeQuery("SELECT * FROM stock;");
				
				ResultSet rs = s.getResultSet();
				while (rs.next()) {
					Stock stock = new Stock();
					stock.setAlcoholType(rs.getString("lessonid"));
					stock.setAlcoholName(rs.getString("topic"));
					stock.setAlcoholContent(rs.getInt("trainer"));
					stock.setAlcoholPrice(rs.getInt("boogie"));
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
}
