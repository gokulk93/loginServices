//var app = angular.module('loginApp');
  
  app.factory('LoginService', function($http,$log) {
    var admin = '';
    var pass = '';
    var isAuthenticated = false;
    
    return {
      login : function(userName, pswd) {
    	  var url = 'http://localhost:8080/LoginService/login';
    	  var data = {userId: userName, password: pswd};
    	  $log.log("User Name: "+userName);
    	 
    	  
    	  $http.post(url, data)
    	  .then(
                  function(response){
                	  isAuthenticated = response.data;
                      return isAuthenticated;
                  }, 
                  function(errResponse){
                	  $log.log("Error: "+errResponse.data);
                      
                  }
          );
    	  
       /* isAuthenticated = username === admin && password === password;
        return isAuthenticated;*/
      },
      isAuthenticated : function() {
        return isAuthenticated;
      }
    };
    
  });