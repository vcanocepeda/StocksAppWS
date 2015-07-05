package com.isaacs.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.isaacs")
public class AppConfig extends WebMvcConfigurerAdapter{

  @Bean
  public InternalResourceViewResolver getInternalResourceViewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    return resolver;
  }
  
  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
      configurer.enable("spring-mvc-dispatcher");
  } 
  
/*  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
     registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
      registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
      registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
      registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926); 
      registry.addResourceHandler("/*.jsp").addResourceLocations("/WEB-INF/views/");
  } 

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
      registry.addViewController("/").setViewName("forward:/index.jsp");
  } */
  
}