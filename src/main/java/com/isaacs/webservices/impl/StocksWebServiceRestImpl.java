package com.isaacs.webservices.impl;

//import com.isaacs.model.Stock; http://localhost:9000/getPrice/1
import com.isaacs.model.Price;
import com.isaacs.dao.PriceDao;
import com.isaacs.dao.impl.PriceDaoJPAImpl;

import com.isaacs.webservices.StocksWebServiceRest;

public class StocksWebServiceRestImpl implements StocksWebServiceRest {

	public Price getLastPriceFromStock(Integer id) {
		PriceDao priceDao = new PriceDaoJPAImpl();	
		Price price = priceDao.findByPriceId(id);
		return price;
	}

}
