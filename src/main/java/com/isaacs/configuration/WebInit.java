package com.isaacs.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInit implements WebApplicationInitializer {
	
	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
	
		AnnotationConfigWebApplicationContext rootContext =
		      new AnnotationConfigWebApplicationContext();
		rootContext.register(WebConfig.class);
	    
		servletContext.addListener(new ContextLoaderListener(rootContext));
	   // servletContext.setInitParameter("contextInitializerClasses", "mvctest.web.DemoApplicationContextInitializer");
		
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("spring-mvc-dispatcher", 
        		new DispatcherServlet(rootContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");		
	}

}
