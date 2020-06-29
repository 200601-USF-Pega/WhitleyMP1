package com.revature.foollickerbarp1.web;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.revature.foollickerbarp1.dao.AdminRepoDB;
import com.revature.foollickerbarp1.dao.BartenderRepoDB;
import com.revature.foollickerbarp1.dao.GuestRepoDB;
import com.revature.foollickerbarp1.dao.StockRepoDB;
import com.revature.foollickerbarp1.model.Bartender;
import com.revature.foollickerbarp1.model.Guest;
import com.revature.foollickerbarp1.model.Stock;
import com.revature.foollickerbarp1.service.ValidationService;

@Path("/service")
public class Services {
	StockRepoDB stockRepo = new StockRepoDB();
	GuestRepoDB guestRepo = new GuestRepoDB();
	BartenderRepoDB bartenderRepo = new BartenderRepoDB();
	AdminRepoDB adminRepo = new AdminRepoDB();

	ValidationService validation = new ValidationService();
	private static final Logger log = Logger.getLogger(Services.class);

	@GET
	@Path("/getallstock")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllItems() {
		return Response.ok((ArrayList<Stock>) stockRepo.getAllItems()).build();
	}

	@POST
	@Path("/addguest")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addGuest(Guest guest) {
		guestRepo.addGuest(guest);
		log.info("Guest " + guest.getUsername() + " was successfully added.");
		return Response.status(201).build();
	}

	@POST
	@Path("/adddrink")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addDrink(Stock stock) {
		stockRepo.addDrink(stock);
		log.info("Your " + stock.getAlcoholName() + " was successfully created!");
		return Response.status(201).build();
	}

	@POST
	@Path("/newuser")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newUser(Guest guest) {
		String username = guest.getUsername();
		String password = guest.getPassword();
		String name = guest.getName();
		// UserTool tool = new UserTool();
		// user = tool.createNewUser(username, password, password);

		if (username != null && password != null && name != null) {
			guestRepo.addGuest(guest);
			 log.info("User " + guest.getUsername() + " successfully created.");
			System.out.println(username + " logged in successfully.");
			return Response.status(302).build();

		} else {
			System.out.println("User not created. Please try again.");
			// logger.warn("User " + user.getUsername() + " creation failed.");
			return Response.status(403).build();
		}
	}

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response logInVerification(Guest guest) {
		String username = guest.getUsername();
		String accountType = guest.getAccountType();
		String password = guest.getPassword();
		if (validation.usernameExistsValidation(username)) {
			if (guestRepo.checkGuest(username, password)) {
				if (this.adminCheck(username)) {
					return Response.status(303).build();
				}

				if (this.bartenderCheck(username)) {
					return Response.status(304).build();
				}
				
				return Response.status(302).build();
			}
		} else {
			System.out.println("Invalid user input.");
		}
		return null;

	}

	@POST
	@Path("/deletedrink")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteDrink(Stock stock) {
		stockRepo.deleteDrink(stock);
		log.info("The ever-disgusting " + stock.getAlcoholName() + " was successfully deleted!");
		return Response.status(201).build();
	}

	@GET
	@Path("/getbartenders")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBartenders() {
		return Response.ok((ArrayList<Bartender>) adminRepo.getAllBartenders()).build();
	}

	@PUT
	@Path("/addbartender")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBartender(Bartender bartender) {
		adminRepo.addBartender(bartender);
		log.info("Bartender" + bartender.getName() + " was successfully initiated!");
		return Response.status(201).build();
	}

	@GET
	@Path("/menu")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMenu() {
		return Response.ok((ArrayList<Stock>) stockRepo.getMenu()).build();
	}

	@POST
	@Path("/orderdrink")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response orderDrink(Stock stock) {
		stockRepo.orderDrink(stock);
		log.info("Your " + stock.getAlcoholName() + " was successfully orded!");
		return Response.status(201).build();
	}

	@POST
	@Path("/leaveatip")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response tipBartender(Bartender bartender) {
		bartenderRepo.tipBartender(bartender);
		log.info("Your tip was successfully left! How generous");
		return Response.status(201).build();
	}

	@GET
	@Path("/getallguests")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllGuests() {
		return Response.ok((ArrayList<Guest>) bartenderRepo.getAllGuests()).build();
	}

	public boolean adminCheck(String username) {
		if (guestRepo.checkAdmin(username)) {
			log.info("Welcome, your majesty");
			return true;
		}
		return false;
	}
	
	public boolean bartenderCheck(String username) {
		if (guestRepo.checkBartender(username)) {
			log.info("Hello bartender");
			return true;
		}
		return false;
	}

}
