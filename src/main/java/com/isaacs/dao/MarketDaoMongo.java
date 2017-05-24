package com.isaacs.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.isaacs.model.Market;
import com.isaacs.model.Stock;


@Repository("MarketDaoMongo")
public interface MarketDaoMongo extends MongoRepository<Market, String> {

    public Market findByCode(String code);

}