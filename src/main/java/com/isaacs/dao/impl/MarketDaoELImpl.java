package com.isaacs.dao.impl;

import com.isaacs.dao.MarketDao;
import com.isaacs.model.Market;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.NoResultException;

@Repository("MarketDaoELImpl")
public class MarketDaoELImpl extends GenericDaoELImpl<Market, Integer>  implements MarketDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3204732623661515600L;


	public MarketDaoELImpl() {
		super();
	}
	
	@PostConstruct
	public void CreateEntityManager() {
		em = entityManagerFactory.createEntityManager();
		logger.info("EntityManager created: em " + em.toString());
	}

	
	public Market findByCode(String code) {
		Market market = null;
		
		try {
			market = (Market) this.em.createQuery("SELECT m FROM Market m " +
              "WHERE m.code = :code")
					.setParameter("code", code).getSingleResult();
		    } catch (NoResultException e) {
		     
		    }
		return market;
	}
	
	@PreDestroy
	public void CloseEntityManager() {
		em.close();
		logger.info("EntityManager destroyed: em " + em.toString());
	}

}
