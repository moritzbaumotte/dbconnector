package com.baumotte.dbconnector.entities;

public class Response {
	
	private int id;
	private String responseText;
	private int ticketId;
	
	public Response(int id, String responseText, int ticketId) {
		this.id = id;
		this.responseText = responseText;
		this.ticketId = ticketId;
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

}
