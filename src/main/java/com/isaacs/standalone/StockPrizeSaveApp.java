package com.isaacs.standalone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import com.isaacs.dao.*;
import com.isaacs.model.*;
import com.isaacs.configuration.*;
import com.isaacs.webservices.impl.StocksWebServiceRestImpl;

public class StockPrizeSaveApp {

	private StockDao stockDao;
	private MarketDao marketDao;

	public StockPrizeSaveApp() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				WebConfig.class);

		setStockDao(ctx.getBean(StockDao.class));
		setMarketDao(ctx.getBean(MarketDao.class));

		JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
		sf.setResourceClasses(StocksWebServiceRestImpl.class);
		sf.setAddress("http://localhost:9000/");
		sf.create();
		
		//Resource leak: 'ctx' is never closed
	}


	public StockDao getStockDao() {
		return stockDao;
	}

	public void setStockDao(StockDao stockDao) {
		this.stockDao = stockDao;
	}

	public MarketDao getMarketDao() {
		return marketDao;
	}

	public void setMarketDao(MarketDao marketDao) {
		this.marketDao = marketDao;
	}
}
