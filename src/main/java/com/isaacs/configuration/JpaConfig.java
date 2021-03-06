package com.isaacs.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.isaacs.configuration")
public class JpaConfig {
  
  @Bean
  public DataSource DataSource()  {
	DataSource ds = null;
	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		ds = (DataSource)envCtx.lookup("jdbc/MysqlDS");
	} catch (NamingException e) {
		e.printStackTrace();
	}	  
    return ds;
  }
   
  @Bean
  public EntityManagerFactory entityManagerFactory() {
	  EclipseLinkJpaVendorAdapter vendorAdapter = new EclipseLinkJpaVendorAdapter();
	  vendorAdapter.setGenerateDdl(true);
     
      LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
      factory.setJpaVendorAdapter(vendorAdapter);
      Map<String, String> jpaProperties = new HashMap<String, String>();
      jpaProperties.put("eclipselink.weaving", "false");
    // jpaProperties.put("useJDBCCompliantTimezoneShift", "true");
    //  jpaProperties.put("jpaDialect"," org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect");
      factory.setJpaPropertyMap(jpaProperties);
      
      factory.setPackagesToScan("com.isaacs.model");
      factory.setDataSource(DataSource());
    //  factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
      factory.setJpaDialect(new EclipseLinkJpaDialect());
      factory.afterPropertiesSet();
      return factory.getObject();
  }
   
  @Bean
  public PlatformTransactionManager transactionManager() {
      JpaTransactionManager txManager = new JpaTransactionManager();
      txManager.setEntityManagerFactory(entityManagerFactory());
      return txManager;
  }
  
  /*
   * Just for hibernate
    @Bean
    public AnnotationSessionFactoryBean sessionFactory() {
  	  AnnotationSessionFactoryBean sessionFactory = new AnnotationSessionFactoryBean();
  	  sessionFactory.setPackagesToScan("com.isaacs.model");
  	  sessionFactory.setDataSource(DataSource());
  	  Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
        hibernateProperties.put("hibernate.hbm2ddl.auto", "create-drop");
        sessionFactory.setHibernateProperties(hibernateProperties);
  	  return sessionFactory;
    }

  or you can place this in web.xml
   */
}