    <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Login</div>
      <div class="card-body">
        <sf:form class="form-horizontal" modelAttribute="loginDetails" name="loginForm" action="${contextRoot}/investmentportfolio/submitLogin" onsubmit="return validateLoginDetails()" method="POST">
          <div class="form-group">
            <label for="exampleInputEmail1">User Name</label>
			<sf:input type="text" path="userName" id="userName" name = "email" class="form-control"></sf:input>
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
			<sf:input type="password" path="userPassword" id="userPassword" name = "email" class="form-control"></sf:input>
          </div>
          <input type="submit" name="Login" id="submit" value="submit" class="btn btn-primary btn-block" >
         </sf:form>
      </div>
    </div>
  </div>