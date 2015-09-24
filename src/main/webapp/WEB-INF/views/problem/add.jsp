<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>

<html>
<head>
<title><spring:message code="problem.problemaddpage.title." /></title>
</head>

<body>
	<div class="row">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/">Home</a></li>
				<li><a href="${pageContext.request.contextPath}/problem">Problem</a></li>
				<li class="active"><a
					href="${pageContext.request.contextPath}/problem/add">Add</a></li>
			</ol>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<form class="form-horizontal"
				action="${pageContext.request.contextPath}/problem/add"
				enctype="multipart/form-data" method="post">
				<legend> Upload Problem </legend>

				<div class="form-group">
					<label class="control-label col-md-2"> Problem File </label>
					<div class="col-md-10">
						<input type="file" class="form-control" name="problems"
						placeholder="select file" />
						<span class="help-block"> Problem Zip File </span>
					</div>
				</div>

				<button type="submit" class="btn btn-primary">
					Submit
				</button>
			</form>
		</div>
	</div>
</body>
</html>