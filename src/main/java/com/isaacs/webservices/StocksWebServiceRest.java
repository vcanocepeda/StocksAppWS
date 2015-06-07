package com.isaacs.webservices;

import com.isaacs.model.Price;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes; 


public interface StocksWebServiceRest {
	@POST
	@Path("/getPrice/{id}")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public Price getLastPriceFromStock(@PathParam("id") Integer id);

}
