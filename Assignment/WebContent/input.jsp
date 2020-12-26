<%@page import="jdk.internal.misc.FileSystemOption"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Donor Details</title>
</head>
<body>
<header>
<%@ include file="menu.html" %></header>

<div class="container">
<%
        String isUser=(String)session.getAttribute("user");
       	
        //redirect user to home page if already logged in
        if(isUser==null){
        	response.sendRedirect("login.jsp");
        }
 %>

	<form action="donor" method="post">
	
	<label for="">Donor Name</label>
	<input type="text" name="donorName" />
	
	<label for="">Donor Age</label>
	<input type ="text" name="donorAge" />
	
	<label for="">Donor Gender</label>
	<input type ="text" name="donorGender" />
	
	<label for="">Donor Bloodgroup</label>
	<select name="donorBloodgroup">
	<option value="o+ve">O+ve</option>
	<option value="a+ve">A+ve</option>
	<option value="b+ve">B+ve</option>
	<option value="o-ve">O-ve</option>
	<option value="a-ve">A-ve</option>
	<option value="b-ve">B-ve</option>
	</select>
	
	<label for="">Donor Phone</label>
	<input type ="text" name="donorPhone" />
	
	<label for="">Date of birth</label>
	<input type ="date" name="dateOfBirth" />
	
	<label for=""></label>
	<input type="submit" value="Add" />
</form>
</div>
</body>
</html>