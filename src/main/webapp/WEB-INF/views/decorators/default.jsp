<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-paper.min.css">
<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/jquery/jquery-2.1.4.js"></script>
<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>	
<title><sitemesh:write property="title" /></title>
<style type="text/css">
.verticalLine {
	border-left: thick solid #F0F0F0;
}
</style>
<sitemesh:write property="head" />
</head>
<body>
	<jsp:include page="../parts/navbar.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<jsp:include page="../parts/alerts.jsp"></jsp:include>
				<sitemesh:write property="body" />
			</div>
		</div>
	</div>
</body>
</html>
