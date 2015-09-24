<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html>
<head>
<title><spring:message code="submission.indexpage.title" /></title>
</head>
<body>
	<div class="row">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/">Home</a></li>
				<li><a href="${pageContext.request.contextPath}/problem">Problem</a></li>
				<li><a
					href="${pageContext.request.contextPath}/problem/${problemCode}">Problem Code</a></li>
				<li class="active"><a
					href="${pageContext.request.contextPath}/problem/${problemCode}/submission">Submission</a></li>	
			</ol>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<table id="submission-table"
				class="table table-striped table-condensed">
				<thead>
					<tr>
						<th>User</th>
						<th>Score</th>
						<th>Memory</th>
						<th>Language</th>
						<th>Solution</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<nav>
				<ul class="pager">
					<li><a href="#">Previous</a></li>
					<li><a href="#">Next</a></li>
				</ul>
			</nav>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			for(var i = 0; i < 10; i++) {
				$("#submission-table").find("tbody").append($("<tr/>").
						append($("<td/>").append($("<a/>").html("User "+i))).
						append($("<td/>").html( i * 10)).
						append($("<td/>").html( i * 10)).
						append($("<td/>").html( "Java")).
						append($("<td/>").append($("<a href='${pageContext.request.contextPath}/problem/${problemCode}/submission/submissionId'/>").addClass("btn btn-default").html("View")))
						);
			}
			
		});
	</script>

</body>
</html>