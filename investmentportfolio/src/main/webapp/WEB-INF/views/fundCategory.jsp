  <div class="content-wrapper">
    <div class="container-fluid">
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">Fund Category</li>
      </ol>
      <!-- Example DataTables Card-->
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Funds
        	<a class="btn btn-primary" style="float:right" href="${contextRoot}/investmentportfolio/addfundcategory">Add Fund</a>
        </div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
<!--                   <th>Action</th> -->
                  <th>Name</th>
                </tr>
              </thead>
              <tbody>
               	<c:forEach items="${fundcategory}" var= "fundcategory">
	                <tr>
	                <!-- <th>Edit|Delete</th> -->  
	                  <th>${fundcategory.fundname}</th>
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
