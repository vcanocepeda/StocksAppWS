package com.isaacs.dao.impl;

import com.isaacs.dao.MarketDao;
import com.isaacs.model.Market;

import java.io.Serializable;
import java.util.List;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MarketDaoJPAImpl implements Serializable, MarketDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3204732623661515600L;
	static Logger logger = Logger.getLogger(MarketDaoJPAImpl.class);
	private EntityManagerFactory emf;
	private EntityManager em;

	public MarketDaoJPAImpl() {
		CreateEntityManager();
	}

	public void CreateEntityManager() {
		this.emf = Persistence.createEntityManagerFactory("stocksApp");
		this.em = this.emf.createEntityManager();
		logger.info("EntityManager created: em "
				+ this.em.toString());
	}

	public void save(Market market) {
		try {
			this.em.getTransaction().begin();
			if (!this.em.contains(market)) {
				this.em.persist(market);

				this.em.flush();
			}
			this.em.getTransaction().commit();
			logger.info("EntityMarket saved: market " + market.getCode());
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
			logger.error(e);
		}
	}

	public void update(Market market) {
	}

	public void delete(Market Market) {
	}

	public Market findByMarketCode(String marketCode) {
		Market market = new Market();
		try {
			market = (Market) this.em
					.createQuery("SELECT m from Market m where m.code=:code")
					.setParameter("code", marketCode).getSingleResult();
		} catch (Exception e) {
		//	this.em.getTransaction().rollback();
		//	e.printStackTrace();
			logger.error(e);
		}
		return market;
	}

	public List<Market> getMarketList() {
		List<Market> listMarkets = null;
		try {
			listMarkets = this.em.createQuery("SELECT m FROM Market m")
					.getResultList();
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
			logger.error(e);
		}
		return listMarkets;
	}

	public void CloseEntityManager() {
		System.out.println("PreDestroy");
		this.em.close();
		logger.info("EntityManager destroyed: em " + this.em.toString());
	}
}
