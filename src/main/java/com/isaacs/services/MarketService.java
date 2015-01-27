package com.isaacs.services;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
import com.isaacs.dao.MarketDao;;
 
@Component
public class MarketService 
{
	//@Autowired
	protected MarketDao marketDAO;
 
	@Override
	public String toString() {
		return "MarketService [marketDAO=" + marketDAO + "]";
	}
}

//Usually in spring we have another layer on top of DAO called Service3