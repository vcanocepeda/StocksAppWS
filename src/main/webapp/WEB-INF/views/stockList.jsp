<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<title>All Stocks</title>  
</head>  
<body>  
<h1>List Stocks</h1>    
  
<c:if test="${!empty stocks}">  
 <table align="left" border="1">  
  <tr>  
   <th>Id</th>  
   <th>Code</th>  
   <th>City</th>  
   <th>Market</th>  
  </tr>  
  
  <c:forEach items="${stocks}" var="stock">  
   <tr>  
    <td><c:out value="${stock.id}"/></td>  
    <td><c:out value="${stock.code}"/></td>  
    <td><c:out value="${stock.name}"/></td>    
    <td><c:out value="${stock.market.code}"/></td>
   </tr>  
  </c:forEach>  
 </table>  
</c:if> 
<br>
<form:form action="${pageContext.request.contextPath}/createStock" method="get">
<input type="submit" value="Create Stock"/>
</form:form>
</body>  
</html>  