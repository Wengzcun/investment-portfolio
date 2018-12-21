  <div class="content-wrapper">
    <div class="container-fluid">
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">Fund Scheme</li>
      </ol>
      <!-- Example DataTables Card-->
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Scheme
        	<a class="btn btn-primary" style="float:right" href="${contextRoot}/investmentportfolio/addlifeinsuracne">Add Insurance</a>
        </div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>Policy Date</th>
                  <th>Amount</th>
                  <th>Policy Period</th>
                  <th>Policy Number</th>
                  <th>Sum Assured</th>
                  <th>Policy Date</th>
                  <th>Scheme Name</th>
                  <th>Customer Name</th>
                </tr>
              </thead>
              <tbody>
               	<c:forEach items="${lifeinsurance}" var= "lifeinsurance">
	                <tr>
	                  <th>${lifeinsurance.policydate}</th>
	                  <th>${lifeinsurance.amount}</th>	
	                  <th>${lifeinsurance.policyperiod}</th>
	                  <th>${lifeinsurance.policynumber}</th>
	                  <th>${lifeinsurance.sumassured}</th>
	                  <th>${lifeinsurance.policylastdate}</th>
	                  <th>${lifeinsurance.schemename}</th> 
	                  <th>${lifeinsurance.customername}</th> 
	            </tr>
              	</c:forEach>
 
              </tbody>
            </table>
          </div>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
      </div>
    </div>
    <!-- /.container-fluid--> 
  </div>
