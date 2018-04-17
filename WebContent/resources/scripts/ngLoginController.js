
app.controller('LoginController', function($scope, $rootScope, $stateParams, $state, $log, LoginService) {
  
  $scope.checkUser = function() {
	 
	 LoginService.login($scope.user,function(result){
		 if(result=="true"){
			 $rootScope.userName = LoginService.getUserName();
		      $scope.error = '';
		      $scope.user.name = '';
		      $scope.user.password = '';
		      $state.transitionTo('home');
		 }else{
			 $log.log("fail");
			 $scope.error = "Incorrect username/password !";
			 $scope.user.password = '';
		 }
	 });
  };
  
});

app.controller('HomeController', 
		  function($scope, $rootScope, $stateParams, $state, LoginService) {
		    $scope.user = $rootScope.userName;
		    
		  });

app.controller('RegistrationController', 
		  function($scope, $rootScope, $stateParams, $state, $log, RegistrationService) {
		    $scope.addUser = function(){
		    	RegistrationService.addUserDetail($scope.user,function(result){
		    		if(result == "successfull") {
		    			$rootScope.info ="New user succesfully added. Continue your login";
						$state.transitionTo('login');
					}else if(result == "existing user") {
						$scope.error="User already exists";
					}else {
						$scope.error="Error occured. Please try after some time.";
					}
		    	});
		    };
		    
		  });