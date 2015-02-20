package com.isaacs.dao;

import com.isaacs.model.Market;

public interface MarketDao extends GenericDao<Market, Integer>
{
	  Market findByCode(String code); 
}