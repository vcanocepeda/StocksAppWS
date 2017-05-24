package com.isaacs.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaacs.dao.StockDaoMongo;
import com.isaacs.model.Market;
import com.isaacs.model.Stock;
import com.isaacs.services.StockService;

@Service("StockServiceMongoImpl")
public class StockServiceMongoImpl implements StockService
{
	@Autowired
	private StockDaoMongo StockDaoMongo;
	
    public StockServiceMongoImpl(){
    	 
    }
    
    @Override
	public Stock find(Integer key) {
		// Stock stock = StockDaoMongo.findOne(key))
		return null;
	}
	@Override
	public List<Stock> list() {
		List<Stock> stockList = StockDaoMongo.findAll();
		return stockList;
	}

	@Override
	public Stock findByCode(String code) {
		Stock stock = StockDaoMongo.findByCode(code);
		return stock;
	}


	@Override
	public Market getMarket(String code) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String save(Stock entity) {
		StockDaoMongo.save(entity);
		return null;
	}
	@Override
	public String update(Stock entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String delete(Stock entity) {
		// TODO Auto-generated method stub
		return null;
	}	
}