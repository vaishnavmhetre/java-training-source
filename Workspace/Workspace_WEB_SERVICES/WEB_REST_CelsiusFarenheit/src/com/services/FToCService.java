/**
 * 
 */
package com.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Allianz3076
 *
 */

@Path("/ftoc")
public class FToCService {

	@Path("{f}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response convertFToC(@PathParam("f") Double farenheit) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		Double celsius = ((farenheit - 32) * 5 / 9);
		jsonObject.put("F Value", farenheit);
		jsonObject.put("C Value", celsius);
		
		String result = "@Produces(\"application/json\") Output: \n\nC to F Converter Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	}

}
