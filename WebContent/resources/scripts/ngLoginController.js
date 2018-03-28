
app.controller('registrationController',registrationCtrl);
 


app.controller('loginCtroller',['loginService','$log', function(loginService,$log){
	this.message="Angular message";
	var r="";
	this.checkLogin = function(){
		$log.log("Called function in ctrl");
		loginService.validateUser(this.username,this.password, function(result){
			r=result;
			$log.log(result);
		});
		this.message=r;
	}
	
}]);




function registrationCtrl(){
	this.message="Angular message";
}