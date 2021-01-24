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
<div class="container-fluid">
    <h1>Required details</h1>
    <div  class="alert alert-success alert-dismissible fade show" role="alert">
      <strong>Hello!</strong>Fill all fields .
      <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>


    <form #userForm="ngForm" action="update" method="post">
      
      <div class="form-control">
        <label>donorName</label>
        <input type="text" required #donorName="ngModel" [class.is-invalid]="donorName.invalid && donorName.touched" 
        class="form-control" name="donorName" [(ngModel)]="userModel.donorName" path="donorName"/>
        <small class="text-danger" [class.d-none]="donorName.valid || donorName.untouched">Name is required</small>
      </div>
  
      <div class="form-control">
        <label>donorAge</label>
        <input type="text" required #donorAge="ngModel" [class.is-invalid]="donorAge.invalid && donorAge.touched"
        class="form-control" name="donorAge" [(ngModel)]="userModel.donorAge" path="donorAge"/>
        <small class="text-danger" [class.d-none]="email.valid || email.untouched">Age is required</small>
      </div>
      
      <div class="mb-3">
        <label>donorGender</label>
        <div class="form-check">
          <input class="form-check-input" [(ngModel)]="userModel.donorGender" type="radio" name="donorGender" value="male" path="donorGender"/>
          <label class="form-check-label">Male</label>
        </div>
        <div class="form-check">
          <input class="form-check-input" [(ngModel)]="userModel.donorGender" type="radio" name="donorGender" value="female" path="donorGender"/>
          <label class="form-check-label">Female</label>
        </div>
      </div>
      
      <div class="form-group">
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
  
      <div class="form-control">
        <label>donorPhone</label>
        <input type="text" #donorPhone="ngModel" pattern="^\d{9}$" [class.is-invalid]="donorPhone.invalid && donorPhone.touched" 
        class="form-control" name="donorPhone" [(ngModel)]="userModel.donorPhone" path="donorPhone"/>
        <small class="text-danger" [class.d-none]="donorPhone.valid || donorPhone.untouched">Phone number must be 9 digits</small>
      </div>
  
      <div class="form-control">
        <label>donorLocation</label>
        <input type="text" required #donorLocation="ngModel" [class.is-invalid]="donorLocation.invalid && donorLocation.touched" 
        class="form-control" name="donorLocation" [(ngModel)]="userModel.donorLocation" path="donorLocation"/>
        <small class="text-danger" [class.d-none]="donorLocation.valid || donorLocation.untouched">Location is required</small>
      </div>
  
      <div class="form-control">
        <label>lastDonated Date</label>
        <input type="text" required #lastDonated="ngModel" [class.is-invalid]="lastDonated.invalid && lastDonated.touched" 
        class="form-control" name="lastDonated" [(ngModel)]="userModel.lastDonated" path="lastDonated"/>
        <small class="text-danger" [class.d-none]="lastDonated.valid || lastDonated.untouched">lastDonated date is required</small>
      </div>
      
      <div class="form-group">
      	<label>Blood Donation Camps</label>
        <select required #bloodCampRegistered="ngModel" [class.is-invalid]="topic.invalid && topic.touched" class="custom-select" name="bloodCampRegistered" [(ngModel)]="userModel.bloodCampRegistered" path="bloodCampRegistered"/>
          <option>unregister</option>
          <option>Bangalore Blood Camp</option>
    	  <option>Chennai Blood Camp</option>
    	  <option>Delhi Blood Camp</option>
    	  <option>Pune Blood Camp</option>
        </select>
        <small class="text-danger" [class.d-none]="bloodCampRegistered.valid || bloodCampRegistered.untouched">Register for Camps (Default Unregistered)</small>
      </div>
  
      <button class="btn btn-primary"  type="submit" (click)="getTextBoxVal(name)">Update</button>
    </form>
  </div>
</body>
</html>