  <div class="content-wrapper">
    <div class="container-fluid">
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">Fixed Deposit</li>
      </ol>
      <!-- Example DataTables Card-->
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Fixed Deposit
        	<a class="btn btn-primary" style="float:right" href="${contextRoot}/investmentportfolio/addfixeddeposite">Add Deposite</a>
        </div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>Customer Name</th>
                  <th>Policy Date</th>
                  <th>Policy Period</th>
                  <th>Bank Name</th>
                  <th>Interest</th>
                  <th>Amount</th>                  
                  <th>Policy Number</th>                  
                  <th>Policy Last Date</th>                  
                </tr>
              </thead>
              <tbody>
               	<c:forEach items="${fixeddeposite}" var= "fixeddeposite">
	                <tr>
	                  <th>${fixeddeposite.customername}</th>
	                  <th>${fixeddeposite.policydate}</th>
	                  <th>${fixeddeposite.policyperiod}</th>
	                  <th>${fixeddeposite.bankname}</th>
	                  <th>${fixeddeposite.interset}</th>
	                  <th>${fixeddeposite.amount}</th>
	                  <th>${fixeddeposite.policynumber}</th>
	                  <th>${fixeddeposite.policylastdate}</th>
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
