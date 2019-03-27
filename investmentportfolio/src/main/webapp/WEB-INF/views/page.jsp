<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url var="vendor" value="/resources/vendor" />
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="image" value="/resources/image" />
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Investment Portfolio - ${title}</title>
  <!-- Bootstrap core CSS-->
  <link href="${vendor}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="${vendor}/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="${vendor}/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  
  <!-- Custom styles for this template-->
  <link href="${css}/sb-admin.css" rel="stylesheet">
  
  
      <c:if test="${userClickCalendar == true}">
    <!-- <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"> -->  
		<link href = "https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/2.3.2/fullcalendar.min.css" rel="stylesheet">
	</c:if>
  
  

  
  <style>
	body  {
	/*  background-image: url("invest-online.jpg");*/
	}
	</style>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
 	<!-- Content Start  -->
		
		<c:if test="${userClickLogin == true}">
			<%@include file="login.jsp" %>
		</c:if>
		
		<!-- Load Dashboard Start -->
		<c:if test="${userClickDashboard == true}">
			<%@include file="./shared/header.jsp" %>
			<%@include file="dashboard.jsp" %>
		</c:if>
		<!-- Load Dashboard End -->
		
		<!-- Load Calendar View -->
		<c:if test="${userClickCalendar == true}">
			<%@include file="./shared/header.jsp" %>
			<%@include file="calendar.jsp"%>
		</c:if>
		<!-- End Load Calendar View -->
		<!-- Load Click Start Start -->
		<c:if test="${userClickAdd == true}">
			<%@include file="./shared/header.jsp" %>
			<%@include file="addCustomer.jsp" %>
		</c:if>
		<!-- Load Add Customer End -->
		
		<c:if test="${userClickEditCustomer == true}">
			<%@include file="./shared/header.jsp" %>
			<%@include file="editCustomer.jsp" %>
		</c:if>
				
		<!-- Load Dashboard Start -->
		<c:if test="${userClickFundCategory == true}">
			<%@include file="./shared/header.jsp" %>
			<%@include file="fundCategory.jsp" %>
		</c:if>
		<!-- Load Add FUnd Category Form -->
		<c:if test="${userClickAddFundCatgory == true}">
			<%@include file="./shared/header.jsp" %>
			<%@include file="addFundCategory.jsp" %>
		</c:if>
		
		<!-- Load Add FUnd Category Form -->
		<c:if test="${userClickFundScheme == true}">
			<%@include file="./shared/header.jsp" %>
			<%@include file="fundScheme.jsp" %>
		</c:if>
		
		<!-- Load Add FUnd Category Form -->
		<c:if test="${userClickAddFundScheme == true}">
			<%@include file="./shared/header.jsp" %>
			<%@include file="addFundScheme.jsp" %>
		</c:if>
		
		<!-- Load Add Life Insurance -->
		<c:if test="${userClickLifeInsurance == true}">
			<%@include file="./shared/header.jsp" %>
			<%@include file="lifeInsurance.jsp" %>
		</c:if>
		
		<!-- Load Add Life INsurance Add Form -->
		<c:if test="${userClickAddLifeInsuracne == true}">
			<%@include file="./shared/header.jsp" %>
			<%@include file="addLifeInsurance.jsp" %>
		</c:if>
		
		<c:if test="${userClickFixedDeposite == true}">
			<%@include file="./shared/header.jsp" %>
			<%@include file="fixedDeposite.jsp" %>
		</c:if>
		
		<c:if test="${userClickAddFixedDeposite == true}">
			<%@include file="./shared/header.jsp" %>
			<%@include file="addFixedDeposite.jsp" %>
		</c:if>
		
		<!-- Load Dashboard End -->
	<!-- Content End -->    
    <!-- Footer Content Start-->

    <!-- Footer Content -->
    <!-- Scroll to Top Button Start -->
    <%@include file="./shared/scroll.jsp" %>
    <!-- Scroll to Top Button End-->

    <!-- Logout Modal Start-->
    <%@include file="./shared/logoutModal.jsp" %>
    <!-- Logout Modal End -->
    
    <!-- Bootstrap core JavaScript-->
    <script src="${vendor}/jquery/jquery.min.js"></script>
    <script src="${vendor}/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="${vendor}/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="${vendor}/chart.js/Chart.min.js"></script>
    <script src="${vendor}/datatables/jquery.dataTables.js"></script>
    <script src="${vendor}/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="${js}/sb-admin.js"></script>
    <!-- Custom scripts for this page-->
    <script src="${js}/sb-admin-datatables.js"></script>
    <script src="${js}/sb-admin-charts.js"></script>
    <script src="${js}/validate.js"></script>
    
    <c:if test="${userClickCalendar == true}">
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.3/moment.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/2.3.2/fullcalendar.min.js"></script>
	<script>
	$(document).ready(function() {
	    // page is now ready, initialize the calendar..
	    var calendarData = [];
	    
	    $.ajax({
		      type: "GET",
		      contentType : 'application/json',
		      dataType : 'json',
		      url: "/investmentportfolio/getcalendardata",
		      success :function(result) {
		       // do what ever you want with data
		     	console.log(result);
		        for(var i = 0 ; i < result.length ; i++){
		        	var innerdata = result[i];
		        	//innerdata
		        	var obj = {};
		        	obj["title"] = innerdata.customername +'--'+ innerdata.schemename;
		        	obj["start"] = innerdata.policydate
		        	calendarData.push(obj);
		        }
		        
		        $('#calendar').fullCalendar({
			        weekends: true,
			        dayClick: function() {
			        //  alert('a day has been clicked!');
			        },
			        events: calendarData,
			        defaultView: 'month'
			    });
		      }
		  });
	    
    });
	</script>
	</c:if>

	
	
	<script>
	
	function selectBank(){
		var bankName = $("#policyBankName").val();
		var periodSelected = $("#policyPeriod").val();
		var interestRate = 0;
		var policyAmountVal = $("#policyAmountId").val();
		$("#interstRateId").val("");
		if(bankName == "Mahindra and Mahindra Financial Services Ltd"){
			if(periodSelected == "1"){
				interestRate = 8.0;
			}else if(periodSelected == "2"){
				interestRate = 8.25;
			}else if(periodSelected == "3"){
				interestRate = 8.55;
			}
		}else if(bankName == "Shriram City Union Finance Limited"){
			if(periodSelected == "1"){
				interestRate = 7.50;
			}else if(periodSelected == "2"){
				interestRate = 7.75;
			}else if(periodSelected == "3"){
				interestRate = 8.0;
			}
		}else if(bankName == "National Housing Bank"){
			if(periodSelected == "1"){
				interestRate = 8.50;
			}else if(periodSelected == "2"){
				interestRate = 8.75;
			}else if(periodSelected == "3"){
				interestRate = 9.0;
			}	
		}else if(bankName == "SHRIRAM TRANSPORT FINANCE CO.LTD"){
			if(periodSelected == "1"){
				interestRate = 7.0;
			}else if(periodSelected == "2"){
				interestRate = 7.75;
			}else if(periodSelected == "3"){
				interestRate = 8.0;
			}
		}else if(bankName == "DHFL LTD"){
			if(periodSelected == "1"){
				interestRate = 8.55;
			}else if(periodSelected == "2"){
				interestRate = 8.75;
			}else if(periodSelected == "3"){
				interestRate = 0.0;
			}			
		}else if(bankName == "DHFL SWAYAMSIDHA FOR WOMEN"){
			if(periodSelected == "1"){
				interestRate = 7.55;
			}else if(periodSelected == "2"){
				interestRate = 7.75;
			}else if(periodSelected == "3"){
				interestRate = 7.85;
			}	
		}else if(bankName == "HDFC LIMITED"){
			if(periodSelected == "1"){
				interestRate = 8.15;
			}else if(periodSelected == "2"){
				interestRate = 8.25;
			}else if(periodSelected == "3"){
				interestRate = 8.45;
			}	
		}else if(bankName == "HUDCO Limited"){
			if(periodSelected == "1"){
				interestRate = 7.55;
			}else if(periodSelected == "2"){
				interestRate = 7.85;
			}else if(periodSelected == "3"){
				interestRate = 8.25;			
			}	
		}else if(bankName == "PNB HOUSING FINANCE LTD"){
			if(periodSelected == "1"){
				interestRate = 7.15;
			}else if(periodSelected == "2"){
				interestRate = 7.25;
			}else if(periodSelected == "3"){
				interestRate = 7.45;
			}	
		}
		if((periodSelected == "NONE" || bankName == "NONE") || policyAmountVal == ""){
			if(policyAmountVal == "NONE"){
				alert("Please Enter Policy Amount");
			}else if(periodSelected == "NONE"){
				alert("Please Select Policy Period");
			}else if(bankName == "NONE"){
				alert("Please Select Bank");
			}		
		}else{
			$("#interstRateId").val(interestRate);
			var sumAssuredAmt = Math.round(policyAmountVal * Math.pow((1+(interestRate/(12*periodSelected*100))),periodSelected*12));
			$("#policySumAssured").val(sumAssuredAmt);
		}	

	}
	
	
	function validateCusomterForm() {
		
		  var name = document.forms["addCusomterForm"]["name"].value;
		  var email = document.forms["addCusomterForm"]["email"].value;
		  var phone = document.forms["addCusomterForm"]["phone"].value;
		  var panNo = document.forms["addCusomterForm"]["pan"].value;
		  var password = document.forms["addCusomterForm"]["password"].value;
		  
		  var regpan = /^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}?$/;
		  var regEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		  var regName = /^[A-z ]+$/;
		  var regPhone = /^[0]?[789]\d{9}$/;
		  
		  if(name == "" || !regName.test(name)){
			  alert("Plaese Enter Valid Customer Name");
			  return false;			  
		  }
		  else if(email == "" || !regEmail.test(email)){
			  alert("Plaese Enter Valid Email");
			  return false;
		  }
		  else if(phone == "" || !regPhone.test(phone)){
			  alert("Plaese Enter Valid Phone Number");
			  return false;			  
		  }
		  else if (panNo == "" || !regpan.test(panNo)) {
		    alert("Plaese Enter Valid Pan No");
		    return false;
		  }
		  else if(password == "" || password.length <= 8){
			  alert("Plaese Enter Password greater than or equal to 8");
			  return false;			  
		  }
		}
	
	
		function changePolicyAmount(){
			var totamount=0;
			
			var p1= document.getElementById("amount").value;
			var p= parseFloat(p1);
			
			var y= parseFloat(getCheckedValue("year"));
			
			var t=getCheckedValue("t")
			if(p == "")
			{
				alert("enter the amount,interstand year");
			}

			else
			{
			if(t=="Yearly")
			{
			totamount=(y*p)+(y*500*41);
			}
			else
			{
			totamount=(p*12*y)+(y*500*41);
			}
			}
			
			document.getElementById("sumassured").value=totamount;
		}
	
		function validateLifeInsurance(){
		   var cusotmername = document.forms["lifeinsurance"]["customername"].value;
		   var cusomteryear = document.forms["lifeinsurance"]["year"].value;
		   var policyscheme = document.forms["lifeinsurance"]["schemename"].value;
		   var policyNumber  = document.forms["lifeinsurance"]["policynumber"].value;
		   var sumAssured  = document.forms["lifeinsurance"]["sumassured"].value;
		   var policyStartDate = document.forms["lifeinsurance"]["policydate"].value;
		   var policyLastDate = document.forms["lifeinsurance"]["policydate"].value;
		   if(cusotmername == "NONE"){
			   alert("Plaese Select Valid Customer Name");
			   return false;			  
		   }else if(cusomteryear == "NONE"){
			   alert("Please Select Valid cusomterYear")
			   return false;
		   }else if(policyscheme == "NONE"){
			   alert("Please Select Policy Scheme")
			   return false;
		   }else if(policyNumber == ""){
			   alert("Please Enter Policy Number")
			   return false;
		   }else if(sumAssured == ""){
			   alert("Please Enter Payable Amount")
			   return false;
		   }else if(policyStartDate == ""){
			   alert("Please Input Policy Date")
			   return false;
		   }else if(policyStartDate == ""){
			   alert("Please Input Policy Date");
			   return false;
		   }else if(policyLastDate == ""){
			   alert("Please Input Policy Last Date")
			   return false;
		   }
		}
		
		function getCheckedValue( groupName ) {
			var radios = document.getElementsByName( groupName );
			for( i = 0; i < radios.length; i++ ) {
			if( radios[i].checked ) {
			return radios[i].value;
			}
			}
			return null;
		}
		
		function validateFixedDeposit(){
			   var cusotmername = document.forms["fixeddeposit"]["customername"].value;
			   var policydate = document.forms["fixeddeposit"]["policydate"].value;
			   var policyamount = document.forms["fixeddeposit"]["amount"].value;
			   var policyperiod = document.forms["fixeddeposit"]["policyperiod"].value;
			   var bankname = document.forms["fixeddeposit"]["bankname"].value;policynumber
			   var policynumber = document.forms["fixeddeposit"]["policynumber"].value;
			   var policyassured = document.forms["fixeddeposit"]["sumassured"].value;
			   var policylastdate = document.forms["fixeddeposit"]["policylastdate"].value;
			   
			   if(cusotmername == "NONE"){
				   alert("Plaese Select Valid Customer Name");
				   return false;			  
			   }else if(policydate == ""){
				   alert("Please Input Policy Date")
				   return false;
			   }else if(policyamount == ""){
				   alert("Please Enter Policy Amount")
				   return false;
			   }else if(policyperiod == "NONE"){
				   alert("Please Select Policy Period")
				   return false;
			   }else if(bankname == "NONE"){
				   alert("Please select Bank Name")
				   return false;
			   }else if(policynumber == ""){
				   alert("Please Enter Policy Number")
				   return false;
			   }else if(policyassured == ""){
				   alert("Please Enter Sum Assured")
				   return false;
			   }else if(policylastdate == ""){
				   alert("Please Enter Policy Date")
				   return false;
			   }
		}
		
		function validateLoginDetails(){
			var userName = $("#userName").val();
			var userPassword = $("#userPassword").val();
			if(userName == ""){
				alert("Please Enter User Name");
				return false;
			}else if(userPassword == ""){
				alert("Please Enter Password");
				return false;
			}else if(userName != "admin"){
				alert("UserName is Incorrect");
				return false;
			}else if(userPassword != "admin123"){
				alert("Password is Incorrect");
				return false;
			}
		}
	</script>
</body>

</html>
    