/**
 * 
 */
package com.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Allianz3076
 *
 */

@Path("/ctof")
public class CToFService {
	
	@GET
	@Path("{c}")
	@Produces(MediaType.APPLICATION_XML)
	public String convertCToF(@PathParam("c") Double celsius) {
		Double farenheit = ((celsius * 9) / 5) + 32;

		String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + farenheit;
		return "<ctofservice> <celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput"
				+ "</ctofoutput></ctofservice>";
	}
}
