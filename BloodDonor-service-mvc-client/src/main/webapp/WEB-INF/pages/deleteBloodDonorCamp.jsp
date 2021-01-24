<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<style type="text/css">
body {
  font-family: Arial;
  background:url(background.jpg) no-repeat;
    background-size: cover;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form #userForm="ngForm" action="deleteCamp" method="post">
      
      <div class="form-control">
        <label>campName</label>
        <input type="text" required #campName="ngModel" [class.is-invalid]="campName.invalid && campName.touched" 
        class="form-control" name="campName" [(ngModel)]="userModel.campName" path="campName"/>
        <small class="text-danger" [class.d-none]="campName.valid || campName.untouched">CampName is required</small>
      </div>
      
      <button class="btn btn-primary"  type="submit" (click)="getTextBoxVal(name)">Delete Camp</button>
    </form>
</body>
</html>