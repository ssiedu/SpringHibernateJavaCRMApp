<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Customer List</h3>
<hr>
<table border="2">
<tr><td>Code</td><td>Name</td><td>Address</td><td>Mobile</td></tr>
<c:forEach var="customer" items="${customers}">
<tr>
	<td>${customer.code}</td>
	<td>${customer.name}</td>
	<td>${customer.address}</td>
	<td>${customer.mobile}</td>
	
	<c:url var="deleteLink" value="delete">
		<c:param name="code" value="${customer.code}"/>
		<c:param name="name" value="${customer.name}"/>
	</c:url>
	<td><a href="${deleteLink}">del</a></a>
</tr>
</c:forEach>
</table>
<hr>
<a href="index.jsp">Home</a>
</body>
</html>
