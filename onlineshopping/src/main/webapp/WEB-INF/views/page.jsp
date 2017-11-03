<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath }" />

<spring:url var="js" value="/resources/js"></spring:url>
<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="images" value="/resources/images"></spring:url>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping ${title}</title>
<script>
	window.menu = '${title}';
</script>
<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<link href="${css}/bootstrap-redable-theme.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/shop-homepage.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<div class="wrapper">

		<!-- Navigation -->
		<%@ include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">

			<c:if test="${userClickHome==true}">

				<%@include file="./home.jsp"%>
			</c:if>

			<!-- Load when user clicks about -->
			<c:if test="${userClickAbout==true}">

				<%@include file="./about.jsp"%>
			</c:if>

			<!-- Load when user clicks contact -->
			<c:if test="${userClickContact==true}">

				<%@include file="./contact.jsp"%>
			</c:if>


			<!-- Load when user clicks Category Products-->
			<c:if test="${userClickAllProducts==true or userClickCategoryProducts==true}">

				<%@include file="./listProducts.jsp"%>
			</c:if>


		</div>
		<!-- /.container -->

		<!-- <div class="container"> -->

		<hr>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
		<!-- </div> -->
		<!-- /.container -->

		<script src="${js}/popper.js"></script>
		<!-- jQuery -->

		<script src="${js}/jquery.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>

		<!-- Self coded java script -->
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
