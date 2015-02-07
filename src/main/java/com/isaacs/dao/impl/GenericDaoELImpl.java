package com.isaacs.dao.impl;

import com.isaacs.dao.GenericDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

public abstract class GenericDaoELImpl<E, K extends Serializable> implements GenericDao<E, K> {

	protected static Logger logger = null;
	@Autowired
	protected EntityManagerFactory entityManagerFactory;
	protected EntityManager em;
    protected Class<? extends E> daoType;
    
    @SuppressWarnings("unchecked")
	public GenericDaoELImpl() {
		daoType = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
		Logger.getLogger(daoType);
	}
    
    public abstract void CreateEntityManager();
    
    public abstract void CloseEntityManager();

	
	
	@Override
	public String save(E entity) {
		String error = "";
		try {
			em.getTransaction().begin();
			if (!em.contains(entity)) {
				em.persist(entity);

				em.flush();
			}
			em.getTransaction().commit();		
			// we have to write entity namelogger.info("EntityMarket saved: entity " + entity.getClass());
			logger.info("Entity saved: entity " + entity.getClass());
		} catch (Exception e) {
			em.getTransaction().rollback();
			error = e.toString();
			logger.error(e);
		}
		return error;
	}
	
	@Override
	public String update(E entity) {
		String error = "";
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.flush();
			em.getTransaction().commit();
			logger.info("Entity updated: market " + entity.getClass());
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			logger.error(e);
		}
		return error;
	}

	@Override
	public String delete(E entity) {
		String error = "";
		return error;
	}
	
	@Override
	public E find(K key) {
		E entity = null;
		try {
			entity = (E) em.find(daoType, key);
		} catch (NoResultException e) {

		} 
		return entity;
	}

	@Override
	public List<E> list() {
		E entity = null;
		List<E> listEntities = null;
		try {
			listEntities = em.createQuery("SELECT m FROM " + daoType.getSimpleName() + " m")
					.getResultList();
	//		listEntities = em.createQuery( "FROM " + daoType.getSimpleName() + " m", E)
	//				.getResultList();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			logger.error(e);
		}
		return listEntities;
	}
	
	// Try to implement session factory
		//private SessionFactory sessionFactory;
		// class="org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean">
	    //<property name="dataSource" ref="dataSource" />
	    //<property name="annotatedClasses" >
}
