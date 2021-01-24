<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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



<form:form action="eligiblebloodgroup" method="post">

<div class="form-group">
<label>Search Blood Group</label>
        <select required #donorBloodgroup="ngModel" [class.is-invalid]="topic.invalid && topic.touched" class="custom-select" name="donorBloodgroup" [(ngModel)]="userModel.donorBloodgroup" path="donorBloodgroup"/>
          <option value="">BloodGroup</option>
          <option>apos</option>
    	  <option>bpos</option>
    	  <option>aneg</option>
    	  <option>bneg</option>
    	  <option>opos</option>
    	  <option>oneg</option>
        </select>
        <small class="text-danger" [class.d-none]="donorBloodgroup.valid || donorBloodgroup.untouched">Choose Bloodgroup</small>
      </div>
      
      <button class="btn btn-primary"  type="submit" (click)="getTextBoxVal(name)">Search Eligible Donors</button>

</form:form>



<a href="http://localhost:2020/">Home Page</a>
</body>
</html>