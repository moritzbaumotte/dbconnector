package com.baumotte.dbconnector.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.baumotte.dbconnector.entities.Response;
import com.baumotte.dbconnector.entities.Ticket;

public class DbCtrl {
	
	private final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String DB_CONNECTION = "jdbc:mysql://localhost:3306/com.baumotte?useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASSWORD = "Fussel01";
	
	/**
	 * Used to get tickets by email
	 * @param email
	 * @return ArrayList<Ticket>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Ticket> getTickets(String email) throws SQLException, ClassNotFoundException {
		ArrayList<Ticket> tickets = new ArrayList<>();
		String query = "select id, email, title, text, active from tickets where email = ?;";
		
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
						rs.getString("text"),
						rs.getInt("active")
					));
		}
		
		return tickets;
	}

	/**
	 * Used to get responses for a specific ticket
	 * @param ticketID
	 * @return ArrayList<Response>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Response> getResponses(int ticketID) throws SQLException, ClassNotFoundException {
		ArrayList<Response> responses = new ArrayList<>();
		String query = "select id, response_text, ticket_id, email from responses where ticket_id = ?;";
		
		Class.forName(DB_DRIVER);
		
		Connection dbConnection = getDBConnection();
		PreparedStatement prepStmt = dbConnection.prepareStatement(query);
		prepStmt.setInt(1, ticketID);
	
		ResultSet rs = prepStmt.executeQuery();
		
		while(rs.next()) {
			responses.add(new Response(
						rs.getInt("id"),
						rs.getString("response_text"),
						rs.getInt("ticket_id"),
						rs.getString("email")
					));
		}
		
		return responses;
	}
	
	/**
	 * create ticket
	 * @param email
	 * @param title
	 * @param text
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void submitTicket(String email, String title, String text) throws SQLException, ClassNotFoundException {
		String query = "insert into tickets (email, title, text) values (?, ?, ?)";
		
		Class.forName(DB_DRIVER);
		
		Connection dbConnection = getDBConnection();
		PreparedStatement prepStmt = dbConnection.prepareStatement(query);
		prepStmt.setString(1, email);
		prepStmt.setString(2, title);
		prepStmt.setString(3, text);
	
		prepStmt.executeUpdate();
	}
	
	/**
	 * used to add response
	 * @param response_text
	 * @param ticket_id
	 * @param email
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void submitResponse(String response_text, int ticket_id, String email) throws SQLException, ClassNotFoundException {
		String query = "insert into responses (response_text, ticket_id, email) values (?, ?, ?)";
		
		Class.forName(DB_DRIVER);
		
		Connection dbConnection = getDBConnection();
		PreparedStatement prepStmt = dbConnection.prepareStatement(query);
		prepStmt.setString(1, response_text);
		prepStmt.setInt(2, ticket_id);
		prepStmt.setString(3, email);
	
		prepStmt.executeUpdate();
	}
	
	public void deleteTicket(String email, int ticket_id) throws SQLException, ClassNotFoundException {
		//to-do
	}
	
	/**
	 * Used to get database connection instance
	 * @return DBconnection
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	private Connection getDBConnection() throws SQLException, ClassNotFoundException {
		Connection dbConnection = null;
		Class.forName(DB_DRIVER);
		
		dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
		
		return dbConnection;
	}

}
