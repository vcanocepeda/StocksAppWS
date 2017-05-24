package com.isaacs.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.isaacs.dao.GenericDao;
import com.isaacs.dao.MarketDao;
import com.isaacs.model.Market;
import com.isaacs.services.MarketService;

@Service("MarketServiceELImpl")
public class MarketServiceELImpl extends GenericServiceImpl<Market, Integer> implements MarketService
{
	@Autowired
	private MarketDao MarketDaoELImpl;
	@Autowired
    public MarketServiceELImpl(
            @Qualifier("MarketDaoELImpl") GenericDao<Market, Integer> genericDao) {
        super(genericDao);
      //  this.MarketDaoELImpl = (MarketDao) genericDao;
    } 

	@Override
	public Market findByCode(String code) {
		Market market = MarketDaoELImpl.findByCode(code);
		return market;
	}	

	
}