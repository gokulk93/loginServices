
//loginController-js 
//var app = angular.module('loginApp');
app.controller('LoginController', function($scope, $rootScope, $stateParams, $state, LoginService) {
  $rootScope.title = "AngularJS Login Sample";
  
  $scope.formSubmit = function() {
    if(LoginService.login($scope.user)) {
      $rootScope.userName = $scope.user.userName;
      $scope.error = '';
      $scope.user.name = '';
      $scope.user.password = '';
      $state.transitionTo('home');
    } else {
      $scope.error = "Incorrect username/password !";
    }   
  };
  
});

app.controller('HomeController', 
		  function($scope, $rootScope, $stateParams, $state, LoginService) {
		    $scope.user = $rootScope.userName;
		    
		  });

app.controller('RegistrationController', 
		  function($scope, $rootScope, $stateParams, $state, LoginService) {
		    
		    
		  });