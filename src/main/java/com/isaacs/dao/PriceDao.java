package com.isaacs.dao;

import com.isaacs.model.Price;
import com.isaacs.model.Stock;

public interface PriceDao extends GenericDao<Price, Integer>
{
	  Price findByPriceId(Integer id); 
	  Stock getStock(Integer id);
}

