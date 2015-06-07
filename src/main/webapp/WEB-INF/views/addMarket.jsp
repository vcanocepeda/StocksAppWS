<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
 <head>  
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
  <title>Spring MVC Form Handling</title>  
 </head>  
 <body>  
  <h2>Add Market Data</h2>     
  
  <sf:form method="POST" modelAttribute="market" cssClass="personForm">
	<table>   
	   <tr>  
           <td><sf:label path="id">Market ID:</sf:label></td>  
           <td><sf:input path="id" /></td>  
       </tr>  
       <tr>  
           <td><sf:label path="code">Market Code:</sf:label></td>  
           <td><sf:input path="code"/></td>  
       </tr>  
       <tr>  
           <td><sf:label path="city">Market City:</sf:label></td>  
           <td><sf:input path="city"/></td>      
            
        <tr><td></td><td><input type="submit" value="Add" /></td></tr>
      </table>
  </sf:form>
 </body>
</html>