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
			    	<sf:form class="form-horizontal" modelAttribute="addLifeInsurance" name="lifeinsurance" action="${contextRoot}/investmentportfolio/submitLifeInsurance" onsubmit="return validateLifeInsurance()" method="POST">
				          	  
				          	  <div class="form-group">
							    <label for="Name">Policy Customer name:</label>
							    <sf:select path = "customername" class="form-control" name="customername">
				                     <sf:option value = "NONE" label = "Select"/>
				                     <sf:options items = "${customerlist}" />
				                 </sf:select> 
							  </div>
							  <div class="form-group">
							    <label for="Name">Policy Period:</label>
							     <sf:select path = "policyperiod" class="form-control" name="year">
				                     <sf:option value ="NONE" label = "Select Period"/>
				                     <sf:option value ="1" >January</sf:option>
				                     <sf:option value ="2" >February</sf:option>
				                     <sf:option value ="3" >March</sf:option>
				                     <sf:option value ="4" >April</sf:option>
				                     <sf:option value ="5" >May</sf:option>
				                     <sf:option value ="6" >June</sf:option>
				                     <sf:option value ="7" >July</sf:option>
				                     <sf:option value ="8" >August</sf:option>
				                     <sf:option value ="9" >September</sf:option>
				                     <sf:option value ="10" >October</sf:option>
				                     <sf:option value ="11" >November</sf:option>
				                     <sf:option value ="12" >December</sf:option>
				                 </sf:select>
							  </div>
							  <div class="form-group">
							    <label for="Name">Policy Scheme name:</label>
							    <sf:select path = "schemename" class="form-control" name="schemename">
				                     <sf:option value = "NONE" label = "Select"/>
				                     <sf:options items = "${fundschemelist}" />
				                 </sf:select> 
							  </div>
							  <div class="form-group">
							    <label for="Name">Policy Number:</label>
							    <sf:input type="text" path="policynumber" id="name" name = "policynumber" class="form-control"></sf:input>
							  </div>
							  <div class="form-group">
							    <label for="Name">Policy Term:</label>
								<input type=radio name=t value=Monthly>Monthly <input type=radio name=t value=Yearly checked>Yearly
							  </div>
							  <div class="form-group">
							    <label for="Name">Policy Term Year:</label>
								<input type=radio name=year value=15 checked>15-Year <input type=radio name=year value=20>20-Year <input type=radio name=year value=25>25-year
							  </div>
							  <div class="form-group">
							    <label for="Name">Policy Payable Amount:</label>
							    <sf:input type="number" path="amount" id="amount" class="form-control" onkeyup="changePolicyAmount()"></sf:input>
							  </div>
							  <div class="form-group">
							    <label for="Name">Policy Sum Assured:</label>
							    <sf:input type="number" path="sumassured" id="sumassured" name="sumassured" class="form-control"></sf:input>
							  </div>
							  <div class="form-group">
							    <label for="Name">Policy Date:</label>
							    <sf:input type="text" path="policydate" id="name" name="policydate" class="form-control"></sf:input>
							  </div>
							  <div class="form-group">
							    <label for="Name">Policy Last Date:</label>
							    <sf:input type="text" path="policylastdate" id="name" name="policylastdate" class="form-control"></sf:input>
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