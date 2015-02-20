package com.isaacs.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.isaacs.dao.MarketDao;
import com.isaacs.model.Market;
import com.isaacs.services.MarketService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class MarketController {
	
	@Autowired
	private MarketService MarketServiceELImpl;
    

	@RequestMapping(value="/listMarkets", method = RequestMethod.GET)
	public String listMarkets(ModelMap model) {
		
//		MarketService marketService = (MarketService)MarketServiceELImpl;		
//		Market market = MarketServiceELImpl.find(1);
//		Market market2 = MarketServiceELImpl.findByCode("NYSE");
		List<Market> list = MarketServiceELImpl.list();
	 
		model.addAttribute("markets", list);
		
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
	
/*	public String addMarket(ModelMap model) {
		
		model.addAttribute("market", new Market());
		return "addMarket";
	} */
	
	@RequestMapping(value="/addMarket2", method = RequestMethod.GET)
	public String addMarket2(ModelMap model) {
		Collection<Object> values = model.values();
		return "marketList";
	}
	
	@RequestMapping(value="{/addMarket",method=RequestMethod.POST)	
	public String addMarket(@ModelAttribute("market")Market market, BindingResult result, 
			Model model)
	{
		 // if (!bindingResult.hasErrors()) {
			  MarketServiceELImpl.delete(market);
		//    LOGGER.debug("Received request for command : {removeContact(contact)}");
		    return "redirect:/contacts";
		//  }
	//	  return "contacts/delete";
		}
	
	/* @RequestMapping(value="{identifier}/edit",method=RequestMethod.POST) public String formEditSubmit(@ModelAttribute("contact") @Valid Contact contact,BindingResult bindingResult){
  LOGGER.debug("Received form submit for contact with identifier {}",contact.getIdentifier());
  if (bindingResult.hasErrors()) {
    return "contacts/edit";
  }
  contactRepository.save(contact);
  LOGGER.debug("Received request for command : {editContact(contact)}");
  return "redirect:/contacts/" + contact.getIdentifier();
 */
	
	
}
		
//asadmin list-jndi-entries --context jdbc  
//https://computingat40s.wordpress.com/how-to-setup-a-jdbc-connection-in-glassfish/
//Persistence