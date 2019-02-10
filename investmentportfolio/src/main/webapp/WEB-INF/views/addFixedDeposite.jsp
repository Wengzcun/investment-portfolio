 <!-- /.content-wrapper-->
    <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <div class="content-wrapper">
	    <div class="container-fluid">
	    <ol class="breadcrumb">
	        <li class="breadcrumb-item">
	          <a href="#">Dashboard</a>
	        </li>
	        <li class="breadcrumb-item active">Add Fixed Deposit</li>
	     </ol>
	     <div class="panel panel-default">
			    <div class="panel-body">
			    	<sf:form class="form-horizontal" modelAttribute="addFixedDeposit" name="fixeddeposit" onsubmit="return validateFixedDeposit()" action="${contextRoot}/investmentportfolio/submitfixeddeposit" method="POST">
				          	  <div class="form-group">
							    <label for="Name">Policy Customer name:</label>
							    <sf:select path = "customername" name="customername" class="form-control">
				                     <sf:option value = "NONE" label = "Select"/>
				                     <sf:options items = "${customerlist}" />
				                 </sf:select> 
							  </div>
				          	  <div class="form-group">
							    <label for="Name">Policy Date:</label>
							    <sf:input type="text" path="policydate" id="name" name="policydate" class="form-control"></sf:input>
							  </div>
							  <div class="form-group">
							    <label for="Name">Policy Amount:</label>
							    <sf:input type="number" path="amount" id="policyAmountId" name="policyyear" class="form-control"></sf:input>
							  </div>
							  <div class="form-group">
							    <label for="Name">Policy Period:</label>
							     <sf:select path = "policyperiod" class="form-control" name="policyperiod" id="policyPeriod" onlick="selectYear(this)">
				                     <sf:option value ="NONE" label = "Select Year"/>
				                     <sf:option value ="1" >1</sf:option>
				                     <sf:option value ="2" >2</sf:option>
				                     <sf:option value ="3" >3</sf:option>
				                 </sf:select>
							  </div>
							  <div class="form-group">
							    <label for="Name">Bank name:</label>
							    <sf:select path = "bankname" class="form-control" id="policyBankName" name="bankname" onChange="selectBank(this)">
				                     <sf:option value = "NONE" label = "Select Bank"/>
				                     <sf:option value= "Mahindra and Mahindra Financial Services Ltd" label="Mahindra and Mahindra Financial Services Ltd" />
				                     <sf:option value= "Shriram City Union Finance Limited" label="Shriram City Union Finance Limited" />
				                     <sf:option value= "National Housing Bank" label="National Housing Bank" />
				                     <sf:option value= "SHRIRAM TRANSPORT FINANCE CO.LTD" label="SHRIRAM TRANSPORT FINANCE CO.LTD" />				                     				                     
				                     <sf:option value= "DHFL LTD" label="DHFL LTD" />
				                     <sf:option value="DHFL SWAYAMSIDHA FOR WOMEN" label="DHFL SWAYAMSIDHA FOR WOMEN"/>
				                     <sf:option value="HDFC LIMITED" label="HDFC LIMITED"/>
				                     <sf:option value="HUDCO Limited" label="HUDCO Limited"/>
				                     <sf:option value="PNB HOUSING FINANCE LTD" label="PNB HOUSING FINANCE LTD"/>	                     				                     
				                 </sf:select> 
							  </div>
							  <div class="form-group">
							    <label for="Name">Interest rate:</label>
							    <sf:input type="text" path="interset" id="interstRateId" class="form-control"></sf:input>
							  </div>
							  <div class="form-group">
							    <label for="Name">Policy Number:</label>
							    <sf:input type="text" path="policynumber" id="name" name="policynumber" class="form-control"></sf:input>
							  </div>
							  <div class="form-group">
							    <label for="Name">Policy Sum Assured:</label>
							    <sf:input type="number" path="sumassured" id="policySumAssured" name="sumassured" class="form-control"></sf:input>
							  </div>
							  <div class="form-group">
							    <label for="Name">Policy Last Date:</label>
							    <sf:input type="text" path="policylastdate" id="name" class="form-control"></sf:input>
							  </div>
							  <div class="panel-footer">
								  <a class="btn btn-secondary"  href="${contextRoot}/investmentportfolio/fixeddeposite">Cancel</a>
					              <input type="submit" name="submit" id="submit" value="submit" class="btn btn-primary">
							  </div>
				              
				      </sf:form>
			    </div>
			 </div>
	    </div>
    </div>