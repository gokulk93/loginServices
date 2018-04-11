


	  /* login check 
	   app.run(function($rootScope, $location, $state, LoginService) {
	     console.clear();
	     console.log('running');
	    if(!LoginService.isAuthenticated()) {
	        $state.transitionTo('login');
	      }
	  });
	  */
	  
	  var app = angular.module('loginApp', ['ui.router']);

	  app.config(function($stateProvider, $urlRouterProvider) {

	      $urlRouterProvider.otherwise('/login');

	      $stateProvider
	          .state('login', {
	              url: '/login',
	              templateUrl: 'login',
	              controller : 'LoginController'
	          })
	          .state('register', {
	              url: '/register',
	              templateUrl: 'register',
	              controller : 'RegistrationController'
	          })
	          .state('home', {
	  	        url : '/home',
	  	        templateUrl : 'home',
	  	        controller : 'HomeController'
	  	      });

	  });

	  
	 