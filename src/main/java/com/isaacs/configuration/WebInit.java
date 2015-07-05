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
		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext rootCtx = new AnnotationConfigWebApplicationContext();
		rootCtx.register(AppConfig.class);
		
		// Manage the lifecycle of the root application context = rootCtx.setServletContext(servletContext);
		servletContext.addListener(new ContextLoaderListener(rootCtx));
				
		// Create the dispatcher servlet's Spring application context
	  /*   AnnotationConfigWebApplicationContext dispatcherContext =
	        new AnnotationConfigWebApplicationContext();
	      dispatcherContext.register(DispatcherConfig.class); */
		
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("spring-mvc-dispatcher", 
        		new DispatcherServlet(rootCtx));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");		
	}

}
