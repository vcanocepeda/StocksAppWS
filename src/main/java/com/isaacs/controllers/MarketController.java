package com.isaacs.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.isaacs.model.Market;
import com.isaacs.services.MarketService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class MarketController {
	
	@Autowired
	private MarketService MarketServiceELImpl;
    
	@RequestMapping(value="/listMarkets", method = RequestMethod.GET)
	public String listMarkets(ModelMap model) {		
		List<Market> list = MarketServiceELImpl.list();	 
		model.addAttribute("markets", list);		
		return "marketList";
	}
	
	@RequestMapping(value="/createMarket", method = RequestMethod.GET)
	public String createMarket(ModelMap model) {	
		model.addAttribute("market", new Market());
		return "createMarket";
	}

	@RequestMapping(value="/addMarket",method=RequestMethod.POST)	
	public String addMarket(@ModelAttribute("market")Market market, BindingResult bindingResult, 
			Model model)
	{
		if (bindingResult.hasErrors()) {
			return "error";
		} else {
			MarketServiceELImpl.save(market);
			model.addAttribute("markets", null);	
		}
		return "marketList";
	}
	
	@RequestMapping(value="/addMarket", method = RequestMethod.GET)
	@ModelAttribute("webFrameworkList")
	public List<String> populateWebFrameworkList() {
		 
		//Data referencing for web framework checkboxes
		List<Market> list = MarketServiceELImpl.list();
		List<String> webFrameworkList = new ArrayList<String>();
		webFrameworkList.add(((Market)list.get(1)).getCity());
		webFrameworkList.add(((Market)list.get(2)).getCity());
		webFrameworkList.add("Struts 2");
		webFrameworkList.add("JSF");
		webFrameworkList.add("Apache Wicket");
		return webFrameworkList;
	}
}
	