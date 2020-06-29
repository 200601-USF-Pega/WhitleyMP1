package com.revature.foollickerbarp1.web;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.foollickerbarp1.dao.GuestRepoDB;
import com.revature.foollickerbarp1.dao.StockRepoDB;
import com.revature.foollickerbarp1.model.Guest;
import com.revature.foollickerbarp1.model.Stock;


@Path("/service")
public class Services {
	StockRepoDB stockRepo = new StockRepoDB();
	GuestRepoDB guestRepo = new GuestRepoDB();
	
	@GET
	@Path("/getallstock")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllItems() {
		return Response.ok((ArrayList<Stock>)stockRepo.getAllItems()).build();
	}
	
	@POST
	@Path("/addguest")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addGuest(Guest guest) {
		guestRepo.addGuest(guest);
		return Response.status(201).build();
	}
	
}