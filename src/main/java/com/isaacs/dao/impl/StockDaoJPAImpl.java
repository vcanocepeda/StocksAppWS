package com.isaacs.dao.impl;

import com.isaacs.dao.StockDao;
import com.isaacs.model.Stock;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.log4j.Logger;

public class StockDaoJPAImpl implements Serializable, StockDao {
	private static final long serialVersionUID = 8890073456388862102L;
	static Logger logger = Logger.getLogger(StockDaoJPAImpl.class);
	private EntityManagerFactory emf;
	private EntityManager em;

	public StockDaoJPAImpl() {
		CreateEntityManager();
	}

	public void CreateEntityManager() {
		this.emf = Persistence.createEntityManagerFactory("stocksApp");
		this.em = this.emf.createEntityManager();
		logger.info("EntityManager created: em " + this.em.toString());
	}

	public void save(Stock stock) {
		try {
			this.em.getTransaction().begin();
			if (!this.em.contains(stock)) {
				this.em.persist(stock);

				this.em.flush();
			}
			this.em.getTransaction().commit();
			logger.info("EntityStock saved: stock " + stock.getCode());
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
			logger.error(e);
		}
	}

	public void update(Stock newStock, String code) {
		try {
			Stock stock = findByStockCode(code);
			this.em.getTransaction().begin();	
			stock.setCode(newStock.getCode());
			stock.setName(newStock.getName());
			stock.setMarket(newStock.getMarket());
			this.em.merge(stock);

			this.em.getTransaction().commit();
			logger.info("EntityStock updated: stock " + stock.getCode());
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
			logger.error(e);
		}
	}

	public void delete(Stock stock) {
		try {
			this.em.getTransaction().begin();
			this.em.remove(stock);

			this.em.getTransaction().commit();
			logger.info("EntityStock removed: stock " + stock.getCode());
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
			logger.error(e);
		}
	}

	public Stock findByStockCode(String stockCode) {
		Stock stock = new Stock();
		try {
			
			Query query = this.em
					.createQuery("SELECT s from Stock s where s.code=:code")
					.setParameter("code", stockCode);
			stock = (Stock) query.getSingleResult();
		} catch (Exception e) {
			//this.em.getTransaction().rollback();
			//e.printStackTrace();
			stock = null;
			logger.error(e);
		}
		return stock;
	}

	public List<Stock> getStockList() {
		List<Stock> listStocks = null;
		try {
			listStocks = this.em.createQuery("SELECT s FROM Stock s")
					.getResultList();
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
		}
		return listStocks;
	}

	public void CloseEntityManager() {
		this.em.close();
		logger.info("EntityManager destroyed: em " + this.em.toString());
	}
}