package com.isaacs.services;
 
import com.isaacs.model.Market;
import com.isaacs.model.Stock;
 
public interface StockService extends GenericService<Stock, Integer>
{
	public Stock findByCode(String code);
	public Market getMarket(String code);
}