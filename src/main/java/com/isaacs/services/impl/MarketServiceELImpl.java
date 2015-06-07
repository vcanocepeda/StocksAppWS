package com.isaacs.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaacs.dao.MarketDao;
import com.isaacs.model.Market;
import com.isaacs.services.MarketService;

@Service("MarketServiceELImpl")
public class MarketServiceELImpl implements MarketService
{
	@Autowired
	private MarketDao MarketDaoELImpl;

	@Override
	public String save(Market market) {
		String result = MarketDaoELImpl.save(market);
		return result;
	}

	@Override
	public String update(Market market) {
		String result = MarketDaoELImpl.update(market);
		return result;
	}

	@Override
	public String delete(Market market) {
		String result = MarketDaoELImpl.delete(market);
		return result;
	}

	@Override
	public Market find(Integer id) {
		Market market = MarketDaoELImpl.find(id);
		return market;
	}

	@Override
	public List<Market> list() {
		List<Market> list = MarketDaoELImpl.list();
		return list;
	}

	@Override
	public Market findByCode(String code) {
		Market market = MarketDaoELImpl.findByCode(code);
		return market;
	}	

	
}