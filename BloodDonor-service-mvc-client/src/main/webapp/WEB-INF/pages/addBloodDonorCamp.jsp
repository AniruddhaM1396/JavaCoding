<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Camp</title>
<style type="text/css">
body {
  font-family: Arial;
  background:url(background.jpg) no-repeat;
    background-size: cover;
}
</style>
</head>
<body>
<div class="container-fluid">
    <h1>Required details</h1>
    <div  class="alert alert-success alert-dismissible fade show" role="alert">
      <strong>Hello!</strong>Fill all fields .
      <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>


    <form #userForm="ngForm" action="submitCamp" method="post">
      
      <div class="form-control">
        <label>campName</label>
        <input type="text" required #campName="ngModel" [class.is-invalid]="campName.invalid && campName.touched" 
        class="form-control" name="campName" [(ngModel)]="userModel.campName" path="campName"/>
        <small class="text-danger" [class.d-none]="campName.valid || campName.untouched">Name is required</small>
      </div>
  
      <div class="form-control">
        <label>campLocation</label>
        <input type="text" required #campLocation="ngModel" [class.is-invalid]="campLocation.invalid && campLocation.touched"
        class="form-control" name="campLocation" [(ngModel)]="userModel.campLocation" path="campLocation"/>
        <small class="text-danger" [class.d-none]="campLocation.valid || campLocation.untouched">campLocation is required</small>
      </div>
      
      <button class="btn btn-primary"  type="submit" (click)="getTextBoxVal(name)">Add Camp</button>
    </form>
  </div>
</body>
</html>