 <!-- /.content-wrapper-->
    <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <div class="content-wrapper">
	    <div class="container-fluid">
	    <ol class="breadcrumb">
	        <li class="breadcrumb-item">
	          <a href="#">Edit</a>
	        </li>
	        <li class="breadcrumb-item active">Edit Customer Record</li>
	     </ol>
	     <div class="panel panel-default">
			    <div class="panel-body">
			    	<sf:form class="form-horizontal" modelAttribute="editCustomerDetails" name = "editCusomterForm" action="${contextRoot}/investmentportfolio/submitCusomter" onsubmit="return validateCusomterForm()" method="POST">
				          	  <div class="form-group">
							    <label for="Name">Name:</label>
							    <sf:input type="text" path="customerName" id="name" name = "name" class="form-control"></sf:input>
							  </div>
							  <div class="form-group">
							    <label for="Email">Email:</label>
							    <sf:input type="email" path="customerEmail" id="email" name = "email" class="form-control"></sf:input>
							  </div>

							  <div class="form-group">
							    <label for="Phone">Phone:</label>
							    <sf:input type="number"  path="customerPhone" id="phone" name = "phone"  class="form-control"></sf:input>
							  </div>
							  <div class="form-group">
							    <label for="email">Pan No:</label>
							    <sf:input type="text" path="customerPAN" id="pan" name = "pan" class="form-control"></sf:input>
							  </div>
							  <div class="form-group">
							    <label for="pwd">Password:</label>
							    <sf:input type="password" path="customerPWD" id="password" name = "password" class="form-control"></sf:input>
							  </div>
							  <div class="panel-footer">
								  <a class="btn btn-secondary"  href="${contextRoot}/investmentportfolio/index">Cancel</a>
					              <input type="submit" name="submit" id="submit" value="submit" class="btn btn-primary">
							  </div>
				              
				      </sf:form>
			    </div>
			 </div>
	    </div>
    </div>