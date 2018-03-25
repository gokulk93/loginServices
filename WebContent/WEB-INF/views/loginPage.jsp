<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<spring:url value="/resources/images/favicon.png" var="favicon" />
<link rel="shortcut icon" href="${favicon}" />

<spring:url value="/resources/styles/form.css" var="formStyles" />

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular-messages/1.6.9/angular-messages.min.js"></script>

<spring:url value="/resources/scripts/app.js" var="angularApp" />
<script src="${angularApp}" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="resources/styles/form.css">
	
</head>
<body ng-app="loginApp">
	<form action="login" method="POST" name="loginForm"> 
		<h3 style="color:maroon;">${userStatus}</h3> 
		<label>Username</label><br/>
	    <input type="text" name="username" placeholder="username" required>
	    <br/>
	    <label>Password</label><br/>
	    <input type="password" name="password" placeholder="password" required>
	    <br/>
	    
	    <label>New User? <a href="register">click here</a></label><br/>
	    <input type="submit" value="Submit"></input>
    </form> 
</body>
</html>
