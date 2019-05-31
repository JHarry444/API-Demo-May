package com.qa.rest;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.qa.domain.Account;
import com.qa.model.AccountRepo;

@Path("/account")
public class AccountEndpoint {
	
	@Inject
	private AccountRepo repo;

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createAccount(Account account, @Context UriInfo info) {
		Account returned = this.repo.addAccount(account);
		URI uri = info.getBaseUriBuilder().path(""+returned.getId()).build();
		return Response.accepted(uri).build();
	}
}
