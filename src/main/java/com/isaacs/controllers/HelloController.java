package com.isaacs.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import com.isaacs.dao.MarketDao;
import com.isaacs.model.Market;
import com.isaacs.services.MarketService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
@RequestMapping("/welcome")
public class HelloController {
	
	@Autowired
	private MarketDao MarketDaoELImpl;
	
	private MarketService marketService;
    
    //@Autowired(required=true)
    //@Qualifier(value="personService")
    public void setMarketService(MarketService ms){
        this.marketService = ms;
    }
 
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
 
		model.addAttribute("message", "Spring 3 MVC Hello World");
		
		MarketDao marketDao = (MarketDao) this.MarketDaoELImpl;		
		Market market = MarketDaoELImpl.find(1);
		Market market2 = MarketDaoELImpl.findByCode("NYSE");
		List<Market> list = MarketDaoELImpl.list();
		
		return "hello2";
	}
}
//		ApplicationContext context = 
//		    	   new ClassPathXmlApplicationContext(new String[] {"mvc-dispatcher-servlet.xml"});
//		MarketService cust = (MarketService)context.getBean("marketService");
/*		try {
			DataSource ds = this.dataSource;
			Connection connection = ds.getConnection();
            PreparedStatement statement = connection
            		.prepareStatement("SELECT * FROM Market");
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                System.out.print("NAME: " + rs.getString("code") + " ");
            }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		
//asadmin list-jndi-entries --context jdbc  
//https://computingat40s.wordpress.com/how-to-setup-a-jdbc-connection-in-glassfish/
//Persistence