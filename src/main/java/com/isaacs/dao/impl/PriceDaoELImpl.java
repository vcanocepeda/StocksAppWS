package com.isaacs.dao.impl;

import com.isaacs.dao.PriceDao;
import com.isaacs.model.Price;
import com.isaacs.model.Stock;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.NoResultException;

@Repository("PriceDaoELImpl")
public class PriceDaoELImpl extends GenericDaoELImpl<Price, Integer>  implements PriceDao {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 3204732623661515600L;


	public PriceDaoELImpl() {
		super();
	}
	
	@PostConstruct
	public void CreateEntityManager() {
		em = entityManagerFactory.createEntityManager();
		logger.info("EntityManager created: em " + em.toString());
	}
	
	@Override
	public Price findByPriceId(Integer id) {
		Price price = null;
		
		try {
			price = (Price) this.em.createQuery("SELECT p FROM Price p " +
              "WHERE s.id = :id")
					.setParameter("id", id).getSingleResult();
		    } catch (NoResultException e) {
		     
		    }
		return price;
	}
	
	@Override
	public Stock getStock(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
		
	@PreDestroy
	public void CloseEntityManager() {
		em.close();
		logger.info("EntityManager destroyed: em " + em.toString());
	}
}
