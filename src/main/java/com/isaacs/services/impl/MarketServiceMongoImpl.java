package com.isaacs.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaacs.dao.MarketDaoMongo;
import com.isaacs.model.Market;
import com.isaacs.model.Stock;
import com.isaacs.services.MarketService;
import com.isaacs.services.StockService;

@Service("MarketServiceMongoImpl")
public class MarketServiceMongoImpl implements MarketService
{
	@Autowired
	private MarketDaoMongo MarketDaoMongo;
	
    public MarketServiceMongoImpl(){
    	 
    }
    
    @Override
	public Market find(Integer key) {
		//Market market = MarketDaoMongo.findOne(key);
		return null;
	}
	@Override
	public List<Market> list() {
		List<Market> marketList = MarketDaoMongo.findAll();
		return marketList;
	}

	@Override
	public Market findByCode(String code) {
		Market market = MarketDaoMongo.findByCode(code);
		return market;
	}

	@Override
	public String save(Market entity) {
		MarketDaoMongo.save(entity);
		return null;
	}
	@Override
	public String update(Market entity) {
		//MarketDaoMongo.update(entity);
		return null;
	}
	@Override
	public String delete(Market entity) {
		//MarketDaoMongo.update(entity);
		return null;
	}	
}