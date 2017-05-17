<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
 <head>  
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
  <title>Spring MVC Form Handling</title>  
 </head>  
 <body>  
  <h2>Create Market</h2>     
  
  <form:form method="POST" modelAttribute="market" cssClass="personForm" 
  action="${pageContext.request.contextPath}/addMarket">
	<table>   
       <tr>  
           <td><form:label path="code">Market Code:</form:label></td>  
           <td><form:input path="code"/></td>  
       </tr>  
       <tr>  
           <td><form:label path="city">Market City:</form:label></td>  
           <td><form:input path="city"/></td>      
       </tr>    
        <tr><td></td><td><input type="submit" value="Add" /></td></tr>
      </table>
  </form:form>
 </body>
</html>