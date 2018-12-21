 <!-- /.content-wrapper-->
    <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <div class="content-wrapper">
	    <div class="container-fluid">
	    <ol class="breadcrumb">
	        <li class="breadcrumb-item">
	          <a href="#">Dashboard</a>
	        </li>
	        <li class="breadcrumb-item active">Add Life Insurance</li>
	     </ol>
	     <div class="panel panel-default">
			    <div class="panel-body">
			    	<sf:form class="form-horizontal" modelAttribute="addLifeInsurance" action="${contextRoot}/investmentportfolio/submitLifeInsurance" method="POST">
				          	  
				          	  <div class="form-group">
							    <label for="Name">Policy Date:</label>
							    <sf:input type="text" path="policydate" id="name" class="form-control"></sf:input>
							  </div>
							  <div class="form-group">
							    <label for="Name">Policy Amount:</label>
							    <sf:input type="number" path="amount" id="name" class="form-control"></sf:input>
							  </div>
							  <div class="form-group">
							    <label for="Name">Policy Period:</label>
							    <sf:input type="number" path="policyperiod" id="name" class="form-control"></sf:input>
							  </div>
							  <div class="form-group">
							    <label for="Name">Policy Scheme name:</label>
							    <sf:select path = "schemename" class="form-control">
				                     <sf:option value = "NONE" label = "Select"/>
				                     <sf:options items = "${fundschemelist}" />
				                 </sf:select> 
							  </div>
							  <div class="form-group">
							    <label for="Name">Policy Number:</label>
							    <sf:input type="text" path="policynumber" id="name" class="form-control"></sf:input>
							  </div>
							  <div class="form-group">
							    <label for="Name">Policy Sum Assured:</label>
							    <sf:input type="number" path="sumassured" id="name" class="form-control"></sf:input>
							  </div>
							  <div class="form-group">
							    <label for="Name">Policy Last Date:</label>
							    <sf:input type="text" path="policylastdate" id="name" class="form-control"></sf:input>
							  </div>
							  <div class="form-group">
							    <label for="Name">Policy Customer name:</label>
							    <sf:select path = "customername" class="form-control">
				                     <sf:option value = "NONE" label = "Select"/>
				                     <sf:options items = "${customerlist}" />
				                 </sf:select> 
							  </div>
							  <div class="panel-footer">
								  <a class="btn btn-secondary"  href="${contextRoot}/investmentportfolio/lifeinsurance">Cancel</a>
					              <input type="submit" name="submit" id="submit" value="submit" class="btn btn-primary">
							  </div>
				              
				      </sf:form>
			    </div>
			 </div>
	    </div>
    </div>