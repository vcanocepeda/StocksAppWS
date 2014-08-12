package com.isaacs.standalone;

import org.springframework.context.annotation.*;

import com.isaacs.dao.impl.*;
import com.isaacs.dao.*;

@Configuration
public class SpringConfig {
	@Bean
	public StockDao stockDAO() {
		return new StockDaoJPAImpl();

	}

	@Bean
	public MarketDao marketDAO() {
		return new MarketDaoJPAImpl();

	}

	@Bean
	public PriceDao priceDAO() {
		return new PriceDaoJPAImpl();

	}
}
