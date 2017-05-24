package com.isaacs.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.isaacs.dao.GenericDao;
import com.isaacs.dao.StockDao;
import com.isaacs.model.Market;
import com.isaacs.model.Stock;
import com.isaacs.services.StockService;

@Service("StockServiceELImpl")
public class StockServiceELImpl extends GenericServiceImpl<Stock, Integer> implements StockService
{
	@Autowired
	private StockDao StockDaoELImpl;
	
    public StockServiceELImpl(){
    	 
    }
    @Autowired
    public StockServiceELImpl(
            @Qualifier("StockDaoELImpl") GenericDao<Stock, Integer> genericDao) {
        super(genericDao);
       // this.StockDaoELImpl = (StockDao) genericDao;
    } 

	@Override
	public Stock findByCode(String code) {
		Stock stock = StockDaoELImpl.findByCode(code);
		return stock;
	}


	@Override
	public Market getMarket(String code) {
		// TODO Auto-generated method stub
		return null;
	}	
}