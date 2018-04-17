  app.factory('LoginService', function($http,$log) {

    var isAuthenticated = false;
    var userName='';
    return {
      login : function(user,callback) {  	  
    	  
    	  var data =$.param(user);
		  
    	  $http({
    		  method: 'POST',
    	      url: 'login',
    	      data: data,
    	      headers: {'Content-Type': 'application/x-www-form-urlencoded'}
    	    })
    	    .then(function(response) {
				isAuthenticated = response.data.result;
				userName = response.data.userName;
				callback(isAuthenticated);
    	    }, 
    	    function(response) { 
    	    	alert( "failure message: " + response.data);
    	    	callback( isAuthenticated);
    	    });
      },
      
      isAuthenticated : function() {
        return isAuthenticated;
      },
      
      getUserName : function(){
    	  return userName;
      }
      
    };
    
  });
  
  app.factory('RegistrationService', function($http,$log) {
		

	    var status = '';
	    return {
	      addUserDetail : function(user,callback) {  	  
	    	  
	    	  var data =$.param(user);
			  
	    	  $http({
	    		  method: 'POST',
	    	      url: 'addDetails',
	    	      data: data,
	    	      headers: {'Content-Type': 'application/x-www-form-urlencoded'}
	    	    })
	    	    .then(function(response) {
	    	    	status = response.data.result;
	    	    	callback(status);
	    	    }, 
	    	    function(response) { 
	    	    	alert( "failure message: " + response.data);
	    	    	status="failed";
	    	    	callback( status);
	    	    });
	      }
	    };
	    
	  });