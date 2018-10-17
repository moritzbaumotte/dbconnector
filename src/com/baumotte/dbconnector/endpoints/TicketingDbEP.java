package com.baumotte.dbconnector.endpoints;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.baumotte.dbconnector.controller.DbCtrl;

@Path("/queries/ticketing")
public class TicketingDbEP {
	
	private final DbCtrl dbCtrl;
	
	public TicketingDbEP() {
		this.dbCtrl = new DbCtrl();
	}

	@GET
	@Path ("/tickets")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTickets(@QueryParam("user") String email) {
		Response r = null;
		try {
			r = Response
					.status(Response.Status.OK)
					.entity(dbCtrl.getTickets(email))
					.build();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	@GET
	@Path ("/tickets/{id}/responses")
	@Produces (MediaType.APPLICATION_JSON)
	public Response getResponses(@PathParam("id") int id) {
		Response r = null;
		try {
			r = Response
					.status(Response.Status.OK)
					.entity(dbCtrl.getResponses(id))
					.build();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return r;
	}

}
