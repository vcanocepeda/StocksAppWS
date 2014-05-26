package com.isaacs.webservices.impl;

import com.isaacs.model.Stock;
import com.isaacs.model.Price;
import com.isaacs.dao.PriceDao;
import com.isaacs.dao.impl.PriceDaoJPAImpl;

import com.isaacs.webservices.StocksWebServiceRest;

public class StocksWebServiceRestImpl implements StocksWebServiceRest {

	public Price getLastPriceFromStock(Stock stock) {
		PriceDao priceDao = new PriceDaoJPAImpl();
		Price price = new Price();
		return price;
	}

}
