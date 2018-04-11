
//loginController-js 
//var app = angular.module('loginApp');
app.controller('LoginController', function($scope, $rootScope, $stateParams, $state, LoginService) {
  $rootScope.title = "AngularJS Login Sample";
  
  $scope.formSubmit = function() {
    if(LoginService.login($scope.username, $scope.password)) {
      $rootScope.userName = $scope.username;
      $scope.error = '';
      $scope.username = 'test';
      $scope.password = '';
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