package com.isaacs.webservices.impl;

import com.isaacs.model.Stock;
import com.isaacs.model.Price;
import com.isaacs.dao.PriceDao;
import com.isaacs.dao.impl.PriceDaoJPAImpl;
import javax.jws.WebService;

import com.isaacs.webservices.StocksWebServiceSoap;

@WebService(endpointInterface = "com.isaacs.webservices.StocksWebService")
public class StocksWebServiceImpl implements StocksWebServiceSoap {

	public Price getLastPriceFromStock(Stock stock) {
		PriceDao priceDao = new PriceDaoJPAImpl();
		Price price = new Price();
		return price;
	}

}
