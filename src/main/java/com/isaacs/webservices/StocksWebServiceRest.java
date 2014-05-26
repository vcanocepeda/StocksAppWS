package com.isaacs.webservices;

import com.isaacs.model.Stock;
import com.isaacs.model.Price;
/* import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes; 

@Consumes("application/json")
@Produces("application/json") */
public interface StocksWebServiceRest {
/*	@POST
	@Path("/GetPriceByStock/")*/
	public Price getLastPriceFromStock(Stock stock);

}
