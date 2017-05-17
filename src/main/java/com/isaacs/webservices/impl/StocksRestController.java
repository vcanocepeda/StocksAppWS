package com.isaacs.webservices.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isaacs.model.Stock;
import com.isaacs.services.StockService;


@RestController
public class StocksRestController {

	
	@Autowired
	private StockService stockService;

	
	@GetMapping("/customers")
	public List getCustomers() {
		return stockService.list();
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity getCustomer(@PathVariable("id") Integer id) {

		Stock stock = stockService.find(id);
		if (stock == null) {
			return new ResponseEntity("No Stock found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(stock, HttpStatus.OK);
	}

	@PostMapping(value = "/customers")
	public ResponseEntity createStock(@RequestBody Stock stock) {

		stockService.save(stock);

		return new ResponseEntity(stock, HttpStatus.OK);
	}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity deleteCustomer(@PathVariable Integer id) {

		if (null == stockService.find(id)) {
			return new ResponseEntity("No Stock found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}

	@PutMapping("/customers/{id}")
	public ResponseEntity updateCustomer(@PathVariable Integer id, @RequestBody Stock stock) {

		String error = "";

		if (null == stockService.find(id)) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		} else {
			error = stockService.update(stock);
			return new ResponseEntity(stock, HttpStatus.OK);
		}

		
	}

}
