<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>



<%@ include file = "header.html" %>

</head>
<body ng-app="loginApp">
	<form action="login" method="post" name="loginForm" ng-controller="loginCtroller as ctrl"> 
		<h3 style="color:maroon;">${userStatus}</h3> 
		<p>{{ctrl.message}}</p>
		<label>Username</label><br/>
	    <input type="number"	name="userId"			placeholder="UserId"
	    		ng-model="ctrl.userId"	ng-required="true"		ng-minlength="4"		ng-maxlength="6">
	    <br/>
	    <label>Password</label><br/>
	    <input type="password"		name="password"			placeholder="Password" 
	    		ng-model="ctrl.password"		ng-required="true"		ng-minlength="8"		ng-maxlength="16">
	    <br/>
	    
	    <label>New User? <a href="register">click here</a></label><br/>
	    <input type="submit" value="Login"/>
    </form> 
</body>
</html>
