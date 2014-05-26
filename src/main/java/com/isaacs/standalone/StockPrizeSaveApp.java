package com.isaacs.standalone;

import com.isaacs.dao.impl.*;
import com.isaacs.model.*;

//import javax.persistence.PersistenceUnit;
//import org.eclipse.persistence.config.PersistenceUnitProperties;
//import org.apache.openjpa.persistence.PersistenceProviderImpl;
//import oracle.toplink.essentials.ejb.cmp3.EntityManager;

public class StockPrizeSaveApp {

	// @PersistenceUnit(unitName = "stocksApp")
	//private EntityManagerFactory factory;

	public static void main(String... args) {
		StockPrizeSaveApp app = new StockPrizeSaveApp();
		app.createMarket();

	}

	private void createMarket() {
		// props.put(PersistenceUnitProperties.JDBC_USER, "user-name");
		// props.put(PersistenceUnitProperties.JDBC_PASSWORD, "password");
		StockDaoJPAImpl stockDao = new StockDaoJPAImpl();
		MarketDaoJPAImpl marketDao = new MarketDaoJPAImpl();
		
		Market market = new Market();
		market = marketDao.findByMarketCode("IBEX35");
		
		Stock stock = new Stock();
		stock.setCode("REP");
		stock.setName("REPSOL");
		stock.setMarket(market);
		stockDao.save(stock);
		
		stock.setCode("REP2");
		stock.setName("REPSOL2");
		stockDao.update(stock, "REP");
		
		stockDao.delete(stock);
		
	    stockDao.CloseEntityManager();
		
/*		try {
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("stocksApp");

			EntityManager entityManager = emf.createEntityManager();
			entityManager.getTransaction().begin();

			Market market = new Market();
			market.setCode("IBEX35");
			market.setCity("Madrid");
			entityManager.persist(market);
			Stock stock = new Stock();
			stock.setCode("REP");
			stock.setName("REPSOL");
			stock.setMarket(market);
			entityManager.persist(stock);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	}
}

