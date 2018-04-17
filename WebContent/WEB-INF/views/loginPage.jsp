<div class="col-md-12">
	<p><strong>Login Page</strong></p>
	<form name="loginForm" ng-submit="checkUser()" class="form">
		<span class="text-success" >{{ info }}</span>
		
		<div class="col-md-4">
			<div class="form-group">
				<input type="number" class="form-control" ng-model="user.userId" placeholder="user Id" required/>
			</div> 
		
			<div class="form-group">
				<input type="password" class="form-control" ng-model="user.password" placeholder="password" required/>
			</div>
		
			<div class="form-group">
				<button type="submit" class="btn btn-success" ng-disabled="loginForm.$invalid">Login</button>
				<span class="text-danger" style="color:red">{{ error }}</span>
			</div>
			<div class="form-group">
				New user: <a ui-sref="register">click here</a>
			</div>
		
		</div>
	</form>
</div>