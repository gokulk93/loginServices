//var app = angular.module('loginApp');
  
  app.factory('LoginService', function($http,$log) {
    var admin = '';
    var pass = '';
    var isAuthenticated = false;
    
    return {
      login : function(user) {
    	  var url = 'http://localhost:8080/LoginService/login';
    	  
    	  
    	 /* var param = {
    			  userName: username,
    			  password: pswd
    	  };
    	  
		  

		  var JsonCrediantials = angular.toJson(param);
		  
		  $log.log("Data : "+ JsonCrediantials);*/
		  
		  /*$http({
				  method: 'POST',
				  url: 'login',
				  data: user,
				  headers: {'Content-Type': 'application/json'}
		  
		  })*/
		  $http.post('login',user)
		  	.then(function successCallback(response) {
				$log.log("Success Message : " + response.data);
				isAuthenticated = response.data;
				return isAuthenticated;
			  }, function errorCallback(response) {
				  alert( "failure message: " + response.data);
			});
		  
		  
    	  
       /* isAuthenticated = username === admin && password === password;
        return isAuthenticated;*/
      },
      isAuthenticated : function() {
        return isAuthenticated;
      }
    };
    
  });