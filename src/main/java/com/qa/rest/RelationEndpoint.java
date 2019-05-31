package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qa.domain.Relation;
@Path("/relation")
public class RelationEndpoint {
	@Inject
	private Relation relation;

	
	@GET
	@Path("/getMessage")
	@Produces(MediaType.APPLICATION_JSON)
	public String getMessage() {
		return this.relation.getMessage();
	}
}
