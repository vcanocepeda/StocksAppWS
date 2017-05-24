package com.isaacs.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.isaacs.dao.GenericDao;
import com.isaacs.services.GenericService;

@Service
public abstract class GenericServiceImpl<E, K> 
        implements GenericService<E, K> {
 
    private GenericDao<E, K> genericDao;
 
    public GenericServiceImpl(GenericDao<E,K> genericDao) {
        this.genericDao=genericDao;
    }
 
    public GenericServiceImpl() {
    }
 
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public String save(E entity) {
        return genericDao.save(entity);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public String update(E entity) {
        return genericDao.update(entity);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public String delete(E entity) {
        return genericDao.delete(entity);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public E find(K id) {
        return genericDao.find(id);
    }
 
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<E> list() {
        return genericDao.list();
    }
}