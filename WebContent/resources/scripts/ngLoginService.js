app.service('loginService',['$http','$log', function($http,$log){
	$log.log("Initializing factory...");
	
	this.validateUser = function(userName, password, result){
		
		$http({
			url:'http://localhost:8080/LoginService/login?username='+userName+'&password='+password,
			method:'POST'
		}).then(function(response){
			result(response.data);
		},function(response){
			$log.log(response);
		});
		
	};
	
}]);