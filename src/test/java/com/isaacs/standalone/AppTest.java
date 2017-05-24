package com.isaacs.standalone;

import org.junit.Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.isaacs.dao.MarketDao;
import com.isaacs.dao.impl.*;
import com.isaacs.model.*;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	private StockDaoELImpl stockDao;
	private MarketDao marketDao;
	private PriceDaoELImpl priceDao;

	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
		stockDao = new StockDaoELImpl();
		marketDao = new MarketDaoELImpl();
		priceDao = new PriceDaoELImpl();
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static junit.framework.Test suite() {
		return new TestSuite(AppTest.class);
	}

	@Test
	public void testStockCRUD() {

		Market market = new Market();
		market = marketDao.find(1);

		Stock stock = new Stock();
		stock.setCode("REP");
		stock.setName("REPSOL");
		stock.setMarket(market);
		stockDao.save(stock);

		assertEquals("REP", stockDao.findByCode("REP").getCode());
		assertEquals("REPSOL", stockDao.findByCode("REP").getName());

		stock.setCode("REP2");
		stock.setName("REPSOL2");
		stockDao.update(stock);

		assertEquals("REP2", stockDao.findByCode("REP2").getCode());
		assertEquals("REPSOL2", stockDao.findByCode("REP2").getName());

		stockDao.delete(stock);

		assertNull(stockDao.findByCode("REP2"));

		stockDao.CloseEntityManager();

	}

	@Test
	public void testPriceSave() {
					
		Stock stock = new Stock();
		stock = stockDao.findByCode("GOOG");
			
		Price price = new Price();
		price.setValue(612.56);
		price.setStock(stock);
		priceDao.save(price);
			
		assertEquals(612.56, priceDao.findByPriceId(price.getId()).getValue());
		
		priceDao.delete(price);

		assertNull(priceDao.findByPriceId(price.getId()));

		priceDao.CloseEntityManager();
 
	}
}
