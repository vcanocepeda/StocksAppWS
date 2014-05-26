package com.isaacs.dao;

import com.isaacs.model.Price;

public abstract interface PriceDao {
	public abstract void save(Price price);

//	public abstract void update(Stock stock, String code);

	public abstract void delete(Price price);

	public abstract Price findByPriceId(Integer id);

//	public abstract List<Stock> getStockList();
}
