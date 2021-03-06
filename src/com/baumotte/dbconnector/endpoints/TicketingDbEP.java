package com.baumotte.dbconnector.endpoints;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.baumotte.dbconnector.controller.DbCtrl;
import com.baumotte.dbconnector.entities.Ticket;

@Path("/queries/ticketing")
public class TicketingDbEP {
	
	private final DbCtrl dbCtrl;
	
	public TicketingDbEP() {
		this.dbCtrl = new DbCtrl();
	}

	@GET
	@Path ("/{user}/tickets")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTickets(@PathParam("user") String email) {
		Response r;
		try {
			r = Response
					.status(Response.Status.OK)
					.entity(dbCtrl.getTickets(email))
					.build();
		} catch (SQLException e) {
			e.printStackTrace();
			r = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			r = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		return r;
	}
	
	@GET
	@Path ("/{user}/tickets/{id}/responses")
	@Produces (MediaType.APPLICATION_JSON)
	public Response getResponses(@PathParam("user") String email, @PathParam("id") int id) {
		Response r;
		try {
			r = Response
					.status(Response.Status.OK)
					.entity(dbCtrl.getResponses(id))
					.build();
		} catch (SQLException e) {
			e.printStackTrace();
			r = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			r = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		return r;
	}
	
	@POST
	@Path ("/{user}/tickets")
	@Consumes (MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public Response createTicket(Ticket ticket, @PathParam("user") String email) {
		Response r;
		
		try {
			int id = dbCtrl.submitTicket(email, ticket.getTitle(), ticket.getDescription());
			r = Response
					.status(Response.Status.OK)
					.entity(id)
					.build();
		} catch (SQLException e) {
			e.printStackTrace();
			r = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			r = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
		return r;
	}
	
	@POST
	@Path ("/{user}/tickets/{id}/responses")
	@Consumes (MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public Response createResponse(com.baumotte.dbconnector.entities.Response response, @PathParam("user") String email, @PathParam("id") int id) {
		Response r;
		
		try {
			int respId = dbCtrl.submitResponse(response.getResponseText(), id, email);
			r = Response
					.status(Response.Status.OK)
					.entity(respId)
					.build();
		} catch (SQLException e) {
			e.printStackTrace();
			r = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			r = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
		return r;
	}
	
	@DELETE
	@Path ("/{user}/tickets/{id}")
	@Consumes (MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public void deleteTicket(@PathParam("user") String email, @PathParam("id") int id) {
		try {
			dbCtrl.deleteTicket(email, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
