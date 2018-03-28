<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<%@ include file = "header.html" %>
</head>
<body ng-app="loginApp">
	<form ng-controller="registrationController as registrationCtrl" 
		action="addDetails" 			method="POST" 
		name="registrationForm" 		modelAttribute="registrationForm" >
		
		<h3 style="color:maroon;">${userStatus}</h3> 
		
		<div>
	    	<input type="number"	name="userId"			placeholder="UserId"
	    		ng-model="userId"	ng-required="true"		ng-minlength="4"		ng-maxlength="6">
	    	<span class="error" ng-show="registrationForm.userId.$invalid && registrationForm.userId.$touched">User id should be between 4 to 6 digit length</span>
	    </div>
	    
		<div>
	    	<input type="text"			name="userName"		placeholder="UserName"	
	    		ng-model="userName"		ng-required="true">
	    	<span class="error" ng-show="registrationForm.userName.$invalid && registrationForm.userName.$touched" ng-show="registrationForm.userName.$invalid">Enter your name </span>
	    </div>
	    
	    <div>
	    	<input type="password"		name="password"			placeholder="Password" 
	    		ng-model="password"		ng-required="true"		ng-minlength="8"		ng-maxlength="16">
	    	<span class="error" ng-show="registrationForm.password.$invalid && registrationForm.password.$touched">Password should be 8 to 16 characters</span>
	    </div>
	    
	    <div>
	    	<input type="password"		name="vPassword"		placeholder="Retype password"	
	    		ng-model="vpassword" 	ng-match="password">
	    	<span class="error" ng-show="registrationForm.vPassword.$error.match">Password doesn't match</span>
	    </div>
	    
	    <input type="submit" value="Submit"></input>
	</form> 
</body>
</html>