 <!-- /.content-wrapper-->
    <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <div class="content-wrapper">
	    <div class="container-fluid">
	    <ol class="breadcrumb">
	        <li class="breadcrumb-item">
	          <a href="#">Dashboard</a>
	        </li>
	        <li class="breadcrumb-item active">Add Customer Record</li>
	     </ol>
	     <div class="panel panel-default">
			    <div class="panel-body">
			    	<sf:form class="form-horizontal" modelAttribute="addFundsScheme" action="${contextRoot}/investmentportfolio/submitFundScheme" method="POST">
				          	  
				          	  <div class="form-group">
							    <label for="Name">Name:</label>
							    <sf:input type="text" path="fundSchemeName" id="name" class="form-control"></sf:input>
							  </div>
							  
							  <div class="form-group">
							    <label for="Name">Category:</label>
							    <sf:select path = "fundCategoryId" class="form-control">
				                     <sf:option value = "NONE" label = "Select"/>
				                     <sf:options items = "${fundcategorylist}" />
				                 </sf:select> 
							  </div>
							  
							  <div class="panel-footer">
								  <a class="btn btn-secondary"  href="${contextRoot}/investmentportfolio/fundscheme">Cancel</a>
					              <input type="submit" name="submit" id="submit" value="submit" class="btn btn-primary">
							  </div>
				              
				      </sf:form>
			    </div>
			 </div>
	    </div>
    </div>