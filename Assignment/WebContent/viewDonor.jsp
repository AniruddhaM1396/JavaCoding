<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<style>
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
<header>
<%@ include file="menu.html" %></header>
<table id="customers">
<tr>
	<th>Name</th>
	<th>Age</th>
	<th>Gender</th>
	<th>BloodGroup</th>
	<th>MobileNum</th>
	<th>DOB</th>
<c:forEach items="${donorList}" var="eachDonor">
	<tr>
	<td><c:out value="${eachDonor.donorName}"/></td>
	<td><c:out value="${eachDonor.donorAge}"/></td>
	<td><c:out value="${eachDonor.donorGender}"/></td>
	<td><c:out value="${eachDonor.donorBloodgroup}"/></td>
	<td><c:out value="${eachDonor.donorPhone}"/></td>
	<td><c:out value="${eachDonor.dateOfBirth}"/></td>
	</tr>
</c:forEach>
	</tr>
	
</table>

</body>
</html>