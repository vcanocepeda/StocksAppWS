package com.isaacs.services;
 
import com.isaacs.model.Market;
 
public interface MarketService extends GenericService<Market, Integer>
{
	public Market findByCode(String code);
}