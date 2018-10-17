package com.baumotte.dbconnector.entities;

public class Response {
	
	private int id;
	private String responseText;
	private int ticketId;
	private String email;
	
	public Response(int id, String responseText, int ticketId, String email) {
		this.id = id;
		this.responseText = responseText;
		this.ticketId = ticketId;
		this.email = email;
	}

	public Response() {
		//used for parsing
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
