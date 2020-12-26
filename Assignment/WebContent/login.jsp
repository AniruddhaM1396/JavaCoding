<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="valid" method="post">

	<label for="">User Name: </label>
	<input type="text" name="name" required>
	<label for="">Password : </label>
	<input type="password" name="password" required>

    <input type="submit" value="Login">

</form>
</body>
</html>