<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<spring:url value="/resources/images/favicon.png" var="favicon" />
<link rel="shortcut icon" href="${favicon}" />
</head>
<body>
	<form action="addDetails" method="POST" name="loginForm" >
		<label>UserId</label><br/>
	    <input type="text" name="userId" placeholder="userId" required>
	    <br/>
		<label>Username</label><br/>
	    <input type="text" name="username" placeholder="username" required>
	    <br/>
	    <label>Password</label><br/>
	    <input type="password" name="password" placeholder="password" required>
	    <br/>
	    <label>Re-Type Password</label><br/>
	    <input type="password" name="password" placeholder="password" required>
	    <br/>
	    
	    <input type="submit" value="Submit"></input>
	</form>
</body>
</html>