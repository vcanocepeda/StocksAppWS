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

import com.isaacs.model.Stock;
import com.isaacs.services.StockService;
import com.mysql.jdbc.StringUtils;
 
@RestController
public class StockRestController {
 
    public static final Logger logger = LoggerFactory.getLogger(StockRestController.class);
 
    @Autowired
    private StockService StockServiceMongoImpl; 
 
    // -------------------Retrieve All Stocks---------------------------------------------
    
    @GetMapping("/stock")
    public ResponseEntity<List<Stock>> listAllStocks() {
        List<Stock> stocks = StockServiceMongoImpl.list();
        if (stocks.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Stock>>(stocks, HttpStatus.OK);
    }
 
    // -------------------Retrieve Single Stock------------------------------------------
 
    @GetMapping("/stock/{id}")
    public ResponseEntity<?> getStock(@PathVariable("id") int id) {
        logger.info("Fetching Stock with id {}", id);
        Stock stock = StockServiceMongoImpl.find(id);
        if (stock == null) {
            logger.error("Stock with id {} not found.", id);
            return new ResponseEntity(new String("Stock with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Stock>(stock, HttpStatus.OK);
    }
 
    // -------------------Create a Stock-------------------------------------------
    
    @PostMapping(value = "/stock")
    public ResponseEntity<?> createStock(@RequestBody Stock stock, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Stock : {}", stock);
 
       if (!StringUtils.isNullOrEmpty(stock.getCode()) && 
    		   (StockServiceMongoImpl.findByCode(stock.getCode()) != null)) {
            logger.error("Unable to create. A stock with code {} already exist", stock.getCode());
            return new ResponseEntity(new String("Unable to create. A Stock with name " + 
            stock.getName() + " already exist."),HttpStatus.CONFLICT);
        } 
       StockServiceMongoImpl.save(stock);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/stock/{id}").buildAndExpand(stock.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
 
    // ------------------- Update a Stock ------------------------------------------------
    
    @PutMapping("/stock/{id}")
    public ResponseEntity<?> updateStock(@PathVariable("id") int id, @RequestBody Stock stock) {
        logger.info("Updating Stock with id {}", id);
 
        Stock currentStock = StockServiceMongoImpl.find(id);
 
        if (currentStock == null) {
            logger.error("Unable to update. Stock with id {} not found.", id);
            return new ResponseEntity(new String("Unable to upate. Stock with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
 
        currentStock.setCode(stock.getCode());
        currentStock.setName(stock.getName());
        currentStock.setMarket(stock.getMarket());
 
        StockServiceMongoImpl.update(currentStock);
        return new ResponseEntity<Stock>(currentStock, HttpStatus.OK);
    }
 
    // ------------------- Delete a Stock-----------------------------------------
 
    @DeleteMapping(value = "/stock/{id}")
    public ResponseEntity<?> deleteStock(@PathVariable("id") int id) {
        logger.info("Fetching & Deleting Stock with id {}", id);
 
        Stock stock = StockServiceMongoImpl.find(id);
        if (stock == null) {
            logger.error("Unable to delete. Stock with id {} not found.", id);
            return new ResponseEntity(new String("Unable to delete. Stock with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        StockServiceMongoImpl.delete(stock);
        return new ResponseEntity<Stock>(HttpStatus.NO_CONTENT);
    } 
}