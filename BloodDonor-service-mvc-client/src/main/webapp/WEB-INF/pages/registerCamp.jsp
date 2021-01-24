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
<form:form action="register" method="post">
<div class="form-control">
        <label>donorPhone</label>
        <input type="text" #donorPhone="ngModel" pattern="^\d{9}$" [class.is-invalid]="donorPhone.invalid && donorPhone.touched" 
        class="form-control" name="donorPhone" [(ngModel)]="userModel.donorPhone" path="donorPhone"/>
        <small class="text-danger" [class.d-none]="donorPhone.valid || donorPhone.untouched">Phone number must be 9 digits</small>
      </div>
      
<div class="form-group">
      	<label>Blood Donation Camps</label>
        <select required #bloodCampRegistered="ngModel" [class.is-invalid]="topic.invalid && topic.touched" class="custom-select" name="bloodCampRegistered" [(ngModel)]="userModel.bloodCampRegistered" path="bloodCampRegistered"/>
          <option>unregister</option>
          <optgroup label="Bangalore"></optgroup>
          <option>Bangalore Camp1</option>
          <option>Bangalore Camp2</option>
          <option>Bangalore Camp3</option>
          <optgroup label="Chennai"></optgroup>
    	  <option>Chennai Camp1</option>
    	  <option>Chennai Camp2</option>
    	  <optgroup label="Delhi"></optgroup>
    	  <option>Delhi Camp1</option>
    	  <optgroup label="Pune"></optgroup>
    	  <option>Pune Camp1</option>
        </select>
        <small class="text-danger" [class.d-none]="bloodCampRegistered.valid || bloodCampRegistered.untouched">Register for Camps (Default Unregistered)</small>
      </div>

<div>
<button class="btn btn-primary"  type="submit" (click)="getTextBoxVal(name)">Submit</button>
</div>
</form:form>
</body>
</html>