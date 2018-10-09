package com.baumotte.dbconnector.endpoints;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.baumotte.dbconnector.entities.Ticket;

@Path("/queries/ticketing")
public class DbEP {

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQueryResults() {
		Ticket dummyTicket = new Ticket(1, "info@baumotte.com", "test ticket", "test ticket description");
		ArrayList<Ticket> tickets = new ArrayList<>();
		tickets.add(dummyTicket);
		return Response.status(Response.Status.OK).entity(tickets).build();
	}

}
