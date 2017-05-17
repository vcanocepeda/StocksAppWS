package com.isaacs.dao;

import com.isaacs.model.Market;
import com.isaacs.model.Stock;

public interface StockDao extends GenericDao<Stock, Integer>
{
	  Stock findByCode(String code); 
	  Market getMarket(String code);
}