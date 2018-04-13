<div class="col-md-12">
      <p><strong>Login Page</strong></p>
      
      <form name="loginForm" ng-submit="formSubmit()" class="form">
        <div class="col-md-4">
          <div class="form-group">
            <input type="text" class="form-control" ng-model="user.userName" placeholder="username" required/>
          </div> 
 
          <div class="form-group">
            <input type="password" class="form-control" ng-model="user.password" placeholder="password" required/>
          </div>
 
          <div class="form-group">
            <button type="submit" class="btn btn-success" ng-disabled="loginForm.$invalid">Login</button>
            <span class="text-danger" style="color:red">{{ error }}</span>
          </div>
 
        </div>
      </form>
</div>