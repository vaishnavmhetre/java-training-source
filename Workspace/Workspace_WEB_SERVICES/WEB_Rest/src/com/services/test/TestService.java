/**
 * 
 */
package com.services.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Allianz3076
 *
 */
@Path("class")
public class TestService {

	@GET
	@Path("function")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "OK";
	}
	
}
