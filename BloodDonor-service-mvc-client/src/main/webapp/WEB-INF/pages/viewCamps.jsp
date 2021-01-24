<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<style>

body {
  background:url(background.jpg) no-repeat;
    background-size: cover;
}

#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="update" method="post">
<table id="customers">
<tr>
	<th>Camp Name</th>
	<th>Camp Location</th>
	
<c:forEach items="${campList}" var="eachCamp">
	<tr>
	<td><c:out value="${eachCamp.campName}"/></td>
	<td><c:out value="${eachCamp.campLocation}"/></td>
	</tr>
</c:forEach>
	</tr>
</table>
</form:form>
</body>
</html>