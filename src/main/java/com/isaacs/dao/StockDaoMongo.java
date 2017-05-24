package com.isaacs.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.isaacs.model.Stock;


//Spring Data MongoDB so useful is the fact that you don’t have to create this implementation
@Repository("StockDaoMongo")
public interface StockDaoMongo extends MongoRepository<Stock, String> {

    public Stock findByCode(String code);

}