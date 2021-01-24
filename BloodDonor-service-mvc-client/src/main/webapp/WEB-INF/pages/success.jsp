<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style type="text/css">
body {
  font-family: Arial;
  background:url(background.jpg) no-repeat;
    background-size: cover;
}

a {
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


a:hover{
    color:  rgb(66,99,245);
    background-color: whitesmoke;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Blood Donor</title>
</head>
<body>
<h1>Success</h1>
<p>${added}</p>
<a href="http://localhost:2020/">Home Page</a>
</body>
</html>