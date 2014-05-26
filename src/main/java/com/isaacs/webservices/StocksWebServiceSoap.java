package com.isaacs.webservices;

import com.isaacs.model.Stock;
import com.isaacs.model.Price;

public interface StocksWebServiceSoap {
	
	public Price getLastPriceFromStock(Stock stock);

}
