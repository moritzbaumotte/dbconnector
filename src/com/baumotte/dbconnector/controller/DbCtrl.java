package com.baumotte.dbconnector.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.baumotte.dbconnector.entities.Ticket;

public class DbCtrl {
	
	private final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String DB_CONNECTION = "jdbc:mysql://localhost:3306/com.baumotte?useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASSWORD = "Fussel01";
		
	public ArrayList<Ticket> getTickets(String email) throws SQLException, ClassNotFoundException {
		ArrayList<Ticket> tickets = new ArrayList<>();
		String query = "select id, email, title, text from tickets where email = ?;";
		
		Class.forName(DB_DRIVER);

		Connection dbConnection = getDBConnection();
		PreparedStatement prepStmt = dbConnection.prepareStatement(query);
		prepStmt.setString(1, email);
	
		ResultSet rs = prepStmt.executeQuery();
		
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
	
	private Connection getDBConnection() throws SQLException, ClassNotFoundException {
		Connection dbConnection = null;
		Class.forName(DB_DRIVER);
		
		dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
		
		return dbConnection;
	}

}
