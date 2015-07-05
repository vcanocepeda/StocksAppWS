<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<html>  
  <head>  
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
    <title>Spring3MVC with Hibernate3 CRUD Example using Annotations</title>  
  </head>  
  <body>  
  	<form:form action="${pageContext.request.contextPath}/listMarkets" method="get">
    	<h2>Spring3MVC with Hibernate3 CRUD Example using Annotations</h2>  
    	<input type="submit" value="List of Markets"/>
    	<h2>1. <a href="./helloworld.html">List of Markets2</a></h2>
    </form:form>
  </body>  
</html>  