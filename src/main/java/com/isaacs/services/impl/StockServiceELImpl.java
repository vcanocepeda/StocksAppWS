package com.isaacs.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaacs.dao.StockDao;
import com.isaacs.model.Market;
import com.isaacs.model.Stock;
import com.isaacs.services.StockService;

@Service("StockServiceELImpl")
public class StockServiceELImpl implements StockService
{
	@Autowired
	private StockDao StockDaoELImpl;

	@Override
	public String save(Stock stock) {
		String result = StockDaoELImpl.save(stock);
		return result;
	}

	@Override
	public String update(Stock stock) {
		String result = StockDaoELImpl.update(stock);
		return result;
	}

	@Override
	public String delete(Stock stock) {
		String result = StockDaoELImpl.delete(stock);
		return result;
	}

	@Override
	public Stock find(Integer id) {
		Stock stock = StockDaoELImpl.find(id);
		return stock;
	}

	@Override
	public List<Stock> list() {
		List<Stock> list = StockDaoELImpl.list();
		return list;
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