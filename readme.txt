Add MongoDB too extending from MongoRepository Spring Data class


This is actually a webapp for Spring. Very Important to know Spring
scalable code

I have to develop two roles Admin and User

Admin Add Stocks and Markets

User just show prizes

we are going to add Jquery to the user to show graficas

looks like login is phasesession_listener

--------------------------------------------------------------------------------------------
We have to add filters to login. Study how to do it with Spring security

We have to implement the different tasks with ant

//-------------------------------------------------------------------------------------------//

//We get an error when we start up the server

http://stackoverflow.com/questions/15669270/option-sql-select-limit-default

Maybe we have to change from the POM

<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>5.1.6</version>
</dependency>



-------------------------  Transactional -----------------------

You can omit the transaction-manager attribute in the <tx:annotation-driven/> tag 
if the bean name of the PlatformTransactionManager that you want to wire in has 
the name transactionManager. If the PlatformTransactionManager bean that you want 
to dependency-inject has any other name, then you have to use the transaction-manager 
attribute explicitly, as in the preceding example.
[Note]
The @EnableTransactionManagement annotation provides equivalent support if you are 
using Java based configuration. Simply add the annotation to a @Configuration class.
 See the javadocs for full details.
 
 For JNDI
asadmin list-jndi-entries --context jdbc  
https://computingat40s.wordpress.com/how-to-setup-a-jdbc-connection-in-glassfish/
Persistence


Add Twitter bootstrap


// How to ViewResolve complex Beans in Spring

The DispatcherServlet again relies on a strategy, called a ViewResolver 
to decide which View is responsible for rendering the response. 
This can be configured as needed for the application (in a simple or chained fashion), 
but by default, an InternalResourceViewResolver is used. 
This is a very simple view resolver that produces a JstlView which simply delegates 
to the Servlet engine’s internal RequestDispatcher to render, and is thus suitable 
for use with JSP pages or HTML pages.


org.springframework.validation.BeanPropertyBindingResult: 1 errors
Field error in object 'stock' on field 'market': rejected value [com.isaacs.model.Market@720d667e];
 codes [typeMismatch.stock.market,typeMismatch.market,typeMismatch.com.isaacs.model.Market,typeMismatch]; 
 arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [stock.market,market]; 
 arguments []; default message [market]]; default message [Failed to convert property value of type 'java.lang.String' 
 to required type 'com.isaacs.model.Market' for property 'market'; nested exception is java.lang.IllegalStateException: 
 Cannot convert value of type 'java.lang.String' to required type 'com.isaacs.model.Market' for property 'market': 
 no matching editors or conversion strategy found]
