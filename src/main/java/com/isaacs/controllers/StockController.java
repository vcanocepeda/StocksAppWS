package com.isaacs.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.isaacs.forms.StockForm;
import com.isaacs.model.Market;
import com.isaacs.model.Stock;
import com.isaacs.services.MarketService;
import com.isaacs.services.StockService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class StockController {
	
	@Autowired
	private StockService StockServiceELImpl;
	@Autowired
	private MarketService MarketServiceELImpl;
    

	@RequestMapping(value="/listStocks", method = RequestMethod.GET)
	public String listStocks(ModelMap model) {		
		List<Stock> list = StockServiceELImpl.list();	 
		model.addAttribute("stocks", list);		
		return "stockList";
	}
	
	@RequestMapping(value="/createStock", method = RequestMethod.GET)
	public ModelAndView createStock(ModelMap model) {	
		List<Market> marketList = MarketServiceELImpl.list();
		Map<Integer, String> marketMap = new HashMap<Integer, String>();
		marketList.forEach(market -> marketMap.put(market.getId(), market.getCode()));
		
	//	model.addAttribute("markets", marketMap);
		model.addAttribute("markets", marketList);
		model.addAttribute("stock", new StockForm());
		return new ModelAndView("createStock", model);
	}
	
	@RequestMapping(value="/addStock",method=RequestMethod.POST)	
	public String addMarket(@ModelAttribute("stock")StockForm stockForm, BindingResult bindingResult, 
			Model model)
	{
		if (bindingResult.hasErrors()) {
			return "error";
		} else {
			Stock stock = new Stock();
			Market market = null;
			//TODO We have to change this parse
			stock.setId(stockForm.getId());
			stock.setCode(stockForm.getCode());
			Integer idMarket = stockForm.getIdmarket();
			if (idMarket != null) {
				market = MarketServiceELImpl.find(idMarket);
			}
			stock.setMarket(market);
			StockServiceELImpl.save(stock);
			model.addAttribute("stocks", null);	
		}
		return "stockList";
	}
	

}
	