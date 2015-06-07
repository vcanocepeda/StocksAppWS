package com.isaacs.services;

import java.util.List;

public interface GenericService<E, K> {
 
    String save(E entity);
     
    String update(E entity);
     
    String delete(E entity);
     
    E find(K key);
     
    List<E> list();
     
}