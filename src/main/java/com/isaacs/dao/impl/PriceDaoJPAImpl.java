package com.isaacs.dao.impl;

import com.isaacs.dao.PriceDao;
import com.isaacs.model.Market;
import com.isaacs.model.Price;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.log4j.Logger;

public class PriceDaoJPAImpl implements Serializable, PriceDao{

	private static final long serialVersionUID = -8471891881478662779L;
	static Logger logger = Logger.getLogger(StockDaoJPAImpl.class);
	private EntityManagerFactory emf;
	private EntityManager em;

	public PriceDaoJPAImpl() {
		CreateEntityManager();
	}

	public void CreateEntityManager() {
		this.emf = Persistence.createEntityManagerFactory("stocksApp");
		this.em = this.emf.createEntityManager();
		logger.info("EntityManager created: em " + this.em.toString());
	}
	
	public void save(Price price) { // We should return the id to test 1
		try {
			this.em.getTransaction().begin();
			if (!this.em.contains(price)) {
				this.em.persist(price);

				this.em.flush();
			}
			this.em.getTransaction().commit();
			logger.info("EntityStock saved: price " + price.getValue());
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
			logger.error(e);
		}
		
	}

	public void delete(Price price) {
		try {
			this.em.getTransaction().begin();
			this.em.remove(price);

			this.em.getTransaction().commit();
			logger.info("EntityStock removed: price " + price.getValue());
		} catch (Exception e) {
			this.em.getTransaction().rollback();
		//	e.printStackTrace();
			logger.error(e);
		}
		
	}

	public Price findByPriceId(Integer id) {
		Price price = new Price();
		try {
			price = (Price) this.em.getReference(Price.class, id);
		} catch (Exception e) {
		//	this.em.getTransaction().rollback();
		//	e.printStackTrace();
			price = null;
			logger.error(e);
		}
		return price;
	}
	
	public void CloseEntityManager() {
		this.em.close();
		logger.info("EntityManager destroyed: em " + this.em.toString());
	}

}
