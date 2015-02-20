<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<title>All Markets</title>  
</head>  
<body>  
<h1>List Markets</h1>  
<h3><a href="addMarket">Add More Markets</a></h3>  
  
<c:if test="${!empty markets}">  
 <table align="left" border="1">  
  <tr>  
   <th>Id</th>  
   <th>Code</th>  
   <th>City</th>    
  </tr>  
  
  <c:forEach items="${markets}" var="market">  
   <tr>  
    <td><c:out value="${market.id}"/></td>  
    <td><c:out value="${market.code}"/></td>  
    <td><c:out value="${market.city}"/></td>    
   </tr>  
  </c:forEach>  
 </table>  
</c:if>  
</body>  
</html>  