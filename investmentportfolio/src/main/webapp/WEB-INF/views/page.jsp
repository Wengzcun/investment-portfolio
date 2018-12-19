<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url var="vendor" value="/resources/vendor" />
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
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
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
 	<!-- Footer Start -->
		<%@include file="./shared/header.jsp" %>
	<!-- Footer End -->
	
	<!-- Content Start  -->
		
		<!-- Load Add Customer Start -->
		<c:if test="${userClickAdd == true}">
			<%@include file="addCustomer.jsp" %>
		</c:if>
		
		<!-- Load Dashboard Start -->
		<c:if test="${userClickDashboard == true}">
			<%@include file="dashboard.jsp" %>
		</c:if>
		
		<!-- Load Dashboard Start -->
		<c:if test="${userClickFundCategory == true}">
			<%@include file="fundCategory.jsp" %>
		</c:if>
		<!-- Load Add FUnd Category Form -->
		<c:if test="${userClickAddFundCatgory == true}">
			<%@include file="addFundCategory.jsp" %>
		</c:if>
		
		<!-- Load Add FUnd Category Form -->
		<c:if test="${userClickFundScheme == true}">
			<%@include file="fundScheme.jsp" %>
		</c:if>
		
		<!-- Load Add FUnd Category Form -->
		<c:if test="${userClickAddFundScheme == true}">
			<%@include file="addFundScheme.jsp" %>
		</c:if>
		
		
		<!-- Load Dashboard End -->
	<!-- Content End -->    
    <!-- Footer Content Start-->
    <%@include file="./shared/footer.jsp" %>
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
    <script src="${js}/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="${js}/sb-admin-datatables.min.js"></script>
    <script src="${js}/sb-admin-charts.min.js"></script>
    <script src="${js}/validate.js"></script>

</body>

</html>
    