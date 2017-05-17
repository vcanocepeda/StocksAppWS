package com.isaacs.dao.impl;

import com.isaacs.dao.StockDao;
import com.isaacs.model.Market;
import com.isaacs.model.Stock;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.NoResultException;

@Repository("StockDaoELImpl")
public class StockDaoELImpl extends GenericDaoELImpl<Stock, Integer>  implements StockDao {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 3204732623661515600L;


	public StockDaoELImpl() {
		super();
	}
	
	@PostConstruct
	public void CreateEntityManager() {
		em = entityManagerFactory.createEntityManager();
		logger.info("EntityManager created: em " + em.toString());
	}

	
	public Stock findByCode(String code) {
		Stock stock = null;
		
		try {
			stock = (Stock) this.em.createQuery("SELECT s FROM Stock s " +
              "WHERE s.code = :code")
					.setParameter("code", code).getSingleResult();
		    } catch (NoResultException e) {
		     
		    }
		return stock;
	}
	
	@Override
	public Market getMarket(String code) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@PreDestroy
	public void CloseEntityManager() {
		em.close();
		logger.info("EntityManager destroyed: em " + em.toString());
	}

	

}
