package com.isaacs.webservices.controllers;
 
import java.util.List;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.isaacs.model.Market;
import com.isaacs.model.Stock;
import com.isaacs.services.MarketService;
import com.mysql.jdbc.StringUtils;
 
@RestController
public class MarketRestController {
 
    public static final Logger logger = LoggerFactory.getLogger(MarketRestController.class);
 
    @Autowired
    private MarketService MarketServiceMongoImpl;
 
    // -------------------Retrieve All Markets---------------------------------------------
    
    @GetMapping("/market")
    public ResponseEntity<List<Market>> listAllMarkets() {
        List<Market> market = MarketServiceMongoImpl.list();
        if (market.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Market>>(market, HttpStatus.OK);
    }
 
    // -------------------Retrieve Single Market------------------------------------------
 
    @GetMapping("/market/{id}")
    public ResponseEntity<?> getMarket(@PathVariable("id") int id) {
        logger.info("Fetching Market with id {}", id);
        Market market = MarketServiceMongoImpl.find(id);
        if (market == null) {
            logger.error("Market with id {} not found.", id);
            return new ResponseEntity(new String("Market with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Market>(market, HttpStatus.OK);
    }
 
    // -------------------Create a Market-------------------------------------------
    
    @PostMapping(value = "/market")
    public ResponseEntity<?> createMarket(@RequestBody Market market, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Market : {}", market);
 
       if (!StringUtils.isNullOrEmpty(market.getCode()) && 
    		   (MarketServiceMongoImpl.findByCode(market.getCode()) != null)) {
            logger.error("Unable to create. A market with code {} already exist", market.getCode());
            return new ResponseEntity(new String("Unable to create. A Market with name " + 
            market.getCity() + " already exist."),HttpStatus.CONFLICT);
        } 
       MarketServiceMongoImpl.save(market);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/stock/{id}").buildAndExpand(market.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
 
    // ------------------- Update a Market ------------------------------------------------
    
    @PutMapping("/market/{id}")
    public ResponseEntity<?> updateMarket(@PathVariable("id") int id, @RequestBody Market market) {
        logger.info("Updating Market with id {}", id);
 
        Market currentMarket = MarketServiceMongoImpl.find(id);
 
        if (currentMarket == null) {
            logger.error("Unable to update. Market with id {} not found.", id);
            return new ResponseEntity(new String("Unable to upate. Market with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
 
        currentMarket.setCode(market.getCode());
        currentMarket.setCity(market.getCity());
 
        MarketServiceMongoImpl.update(market);
        return new ResponseEntity<Market>(currentMarket, HttpStatus.OK);
    }
 
    // ------------------- Delete a Market-----------------------------------------
 
    @DeleteMapping(value = "/market/{id}")
    public ResponseEntity<?> deleteMarket(@PathVariable("id") int id) {
        logger.info("Fetching & Deleting Market with id {}", id);
 
        Market market = MarketServiceMongoImpl.find(id);
        if (market == null) {
            logger.error("Unable to delete. Market with id {} not found.", id);
            return new ResponseEntity(new String("Unable to delete. Market with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        MarketServiceMongoImpl.delete(market);
        return new ResponseEntity<Stock>(HttpStatus.NO_CONTENT);
    }
}