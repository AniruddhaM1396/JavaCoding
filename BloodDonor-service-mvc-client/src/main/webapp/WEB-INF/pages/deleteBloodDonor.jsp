<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<!DOCTYPE html>
<html>
<style>
body {
  background:url(background.jpg) no-repeat;
    background-size: cover;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="delete" method="post">

<div class="form-control">
        <label>donorPhone</label>
        <input type="text" #donorPhone="ngModel" pattern="^\d{9}$" [class.is-invalid]="donorPhone.invalid && donorPhone.touched" 
        class="form-control" name="donorPhone" [(ngModel)]="userModel.donorPhone" path="donorPhone"/>
        <small class="text-danger" [class.d-none]="donorPhone.valid || donorPhone.untouched">Phone number must be 9 digits</small>
      </div>


<button class="btn btn-primary"  type="submit" (click)="getTextBoxVal(name)">Delete</button>

</form:form>
</body>
</html>