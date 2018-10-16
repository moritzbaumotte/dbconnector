package com.baumotte.dbconnector.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.baumotte.dbconnector.entities.Ticket;

public class DbCtrl {
		
	public ArrayList<Ticket> getTickets(String email) throws SQLException, ClassNotFoundException {
		ArrayList<Ticket> tickets = new ArrayList<>();
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/com.baumotte?useSSL=false", "root", "Fussel01");
		Statement stmt = conn.createStatement();
	
		String query = "select * from tickets;";
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			tickets.add(new Ticket(
						rs.getInt("id"),
						rs.getString("email"),
						rs.getString("title"),
						rs.getString("text")
					));
		}
		
		return tickets;
	}

}
