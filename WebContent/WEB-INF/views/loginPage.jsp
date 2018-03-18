<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<spring:url value="resources/images/favicon.png" var="favicon" />
<link rel="shortcut icon" href="${favicon}" />

<spring:url value="/resources/styles/form.css" var="formStyles" />

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular-messages/1.6.9/angular-messages.min.js"></script>

<spring:url value="/resources/scripts/app.js" var="angularApp" />
<script src="${angularApp}" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${formStyles}">
	
</head>
<body ng-app="loginApp">
	<form action="login" method="post" name="loginForm">  
		<label>Username</label><br/>
	    <input type="text" name="username" placeholder="username" ng-model="inputname" ng-minlength="5" ng-maxlength="12" required>
	    <div ng-messages="loginForm.username.$error">
	    <p ng-message="minlength">Username should have at least 5 characters.</p>
	    <p ng-message="maxlength">Username should have at most 12 characters.</p>
	    <p ng-message="required">Providing a username is mandatory.</p>
	    </div><br/>
	    <label>Password</label><br/>
	    <input type="password" name="password" placeholder="password" ng-model="password" ng-minlength="6" ng-maxlength="12" required>
	    <div ng-messages="loginForm.password.$error">
	    <p ng-message="minlength">Password should have at least 6 characters.</p>
	    <p ng-message="maxlength">Password should have at most 12 characters.</p>
	    <p ng-message="required">Providing a password is mandatory.</p>
	    </div><br/>
	    <input type="submit" value="Submit"></input>
    </form> 
</body>
</html>
