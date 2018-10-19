package com.baumotte.dbconnector.entities;

public class Ticket {
	
	private int ticketId;
	private String userEmail;
	private String title;
	private String description;
	private int active;
	
	public Ticket(int ticketId, String userEmail, String title, String description, int active) {
		this.ticketId = ticketId;
		this.userEmail = userEmail;
		this.title = title;
		this.description = description;
		this.active = active;
	}
	
	public Ticket(int ticketId, String userEmail) {
		this.ticketId = ticketId;
		this.userEmail = userEmail;
	}
	
	public Ticket() {
		//only used for parsing
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

}
