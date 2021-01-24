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

div{
text-align:center;
font-size:30px;
}

.eligible{
width: 115px;
    height: 25px;
    background: #4E9CAF;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    line-height: 25px;
}

.back{
width: 115px;
    height: 25px;
    background: red;
    padding: 10px;
    text-align: right;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    line-height: 25px;
}

a:hover{
    color:  rgb(66,99,245);
    background-color: whitesmoke;
}

</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table id="customers">
<tr>
	<th>Name</th>
	<th>Age</th>
	<th>Gender</th>
	<th>BloodGroup</th>
	<th>MobileNum</th>
	<th>Location</th>
	<th>Last Donated</th>
	<th>Camps Registered</th>
<c:forEach items="${donorList}" var="eachDonor">
	<tr>
	<td><c:out value="${eachDonor.donorName}"/></td>
	<td><c:out value="${eachDonor.donorAge}"/></td>
	<td><c:out value="${eachDonor.donorGender}"/></td>
	<td><c:out value="${eachDonor.donorBloodgroup}"/></td>
	<td><c:out value="${eachDonor.donorPhone}"/></td>
	<td><c:out value="${eachDonor.donorLocation}"/></td>
	<td><c:out value="${eachDonor.lastDonated}"/></td>
	<td><c:out value="${eachDonor.bloodCampRegistered}"/></td>
	</tr>
</c:forEach>
	</tr>
	
</table>

<form:form action="bloodgroup" method="post">

<div>
<label for="">DonorBloodgroup</label>
<form:input path="donorBloodgroup"/>
</div>


<div>
<input type="submit" value="Search">
</div>
</form:form>


<a class="eligible" href="eligible">Eligible Donor List</a>
<a class="back" href="http://localhost:2020/">Home Page</a>
</body>
</html>