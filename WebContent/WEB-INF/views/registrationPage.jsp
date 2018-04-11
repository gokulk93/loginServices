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
	<form 
		action="addDetails" 			method="POST" 
		name="registrationForm" 		modelAttribute="registrationForm" novalidate >
		
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
	    	<input type="password"		name="password1"			placeholder="Password" 
	    		ng-model="password1"		ng-required="true"		ng-minlength="8"		ng-maxlength="16">
	    	<span class="error" ng-show="registrationForm.password.$invalid && registrationForm.password.$touched">Password should be 8 to 16 characters</span>
	    </div>
	    
	    <div>
	    	<input type="password"		name="passwordConfirmation"		placeholder="Confirm password"	
	    		ng-model="passwordConfirmation" 	ng-required="true" password-match="password">
	    		<input type="password" 
     ng-model="password2"
      />
	    	<span class="error" ng-show="registrationForm.passwordConfirmation.$error.match">Password do not match</span>
	    </div>
	    
	    <input type="submit" value="Submit" ng-disabled="registrationForm.$invalid"></input>
	    
	 <input placeholder="Password"
           name="pwd" ng-model="thePwd" ng-model-options="{ updateOn: 'blur' }"
           required type="password" pattern=".{2,}" />
    <div class="error-message"
         ng-show="form.password.$invalid && !form.password.$pristine">
        Passwords must have at least 2 chars.
    </div>

    <input placeholder="Check Password"
           name="check" ng-model="chkPwd"
           type="password" wj-valid="chkPwd == thePwd" />
    <div class="error-message"
         ng-show="form.check.$invalid && !form.check.$pristine">
        Sorry, the passwords don't match.
    </div>
    <button type="submit"
            ng-disabled="form.$invalid">
        Create Account
    </button>
    
    
	</form> 
</div>  
</body>
</html>