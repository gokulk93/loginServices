<div class="col-md-12">
	<p><strong>Registration Page</strong></p>
	<form name="RegistrationForm" ng-submit="addUser()" class="form">
		<div class="col-md-4">
			<div class="form-group">
				<input type="number" class="form-control" name="userId" ng-model="user.userId" placeholder="user id"  required ng-minlength="4" ng-maxlength="6"/>
				<span class="error" ng-show="RegistrationForm.userId.$invalid && RegistrationForm.userId.$touched">User id should be between 4 to 6 digits length</span>
			</div> 
			
			<div class="form-group">
				<input type="text" class="form-control" name="userName" ng-model="user.userName" placeholder="user name"   required />
				<span class="error" ng-show="RegistrationForm.userName.$invalid && RegistrationForm.userName.$touched">Enter your name </span>
			</div>
			
			<div class="form-group">
				<input type="password" class="form-control" name="password" ng-model="user.password" placeholder="password"   required   ng-minlength="8"   ng-maxlength="16"/>
				<span class="error" ng-show="RegistrationForm.password.$invalid && RegistrationForm.password.$touched">Password should be 8 to 16 characters</span>
			</div>
		
			<div class="form-group">
				<button type="submit" class="btn btn-success" ng-disabled="RegistrationForm.$invalid">Register</button>
				<span class="text-danger" style="color:red">{{ error }}</span>
			</div>
		
		</div>
	</form>
</div>