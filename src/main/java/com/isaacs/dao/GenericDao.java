package com.isaacs.dao;
 
import java.util.List;
 
public interface GenericDao<E, K> {
 
    String save(E entity);
     
    String update(E entity);
     
    String delete(E entity);
     
    E find(K key);
     
    List<E> list();
     
}