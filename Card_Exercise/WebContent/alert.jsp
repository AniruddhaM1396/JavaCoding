<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${Success == 1}">
		<h2>Success New Credit Limit Is := <c:out value="${creditLimit }"></c:out></h2>
	</c:if>
	
	<c:if test="${Success == 0}">
		<h2>Insufficient amount, Your Credit Limit Is := <c:out value="${creditLimit }"></c:out></h2>
	</c:if>
	
	<c:if test="${Success == -1}">
		<h2>Invalid</h2>
	</c:if>
</body>
</html>