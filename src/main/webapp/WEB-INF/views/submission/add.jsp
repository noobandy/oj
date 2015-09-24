<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>

<html>
<head>
<title><spring:message code="submission.addsubmissionpage.title" />
</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/select2-3.5.4/select2-bootstrap.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/select2-3.5.4/select2.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/ace-builds-1.2.0/src-noconflict/ace.js"></script>
<style type="text/css" media="screen">
    #editor { 
        height: 400px;
    }
</style>
</head>

<body>
	<div class="row">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/">Home</a></li>
				<li><a href="${pageContext.request.contextPath}/problem">Problem</a></li>
				<li><a
					href="${pageContext.request.contextPath}/problem/${problemCode}">Problem
						Code</a></li>
				<li><a
					href="${pageContext.request.contextPath}/problem/${problemCode}/submission">Submission</a></li>
				<li class="active"><a
					href="${pageContext.request.contextPath}/problem/${problemCode}/submission/add">Add</a></li>
			</ol>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<form:form id="submissionForm" modelAttribute="command"
				action="${pageContext.request.contextPath}/problem/${problemCode}/submission/add"
				method="post" enctype="multipart/file-data">
				<legend>
					Submit Solution
				</legend>
				<div class="form-group">
					<label >Language</label>
					<form:select class="form-control" path="language">
						<form:option value="Java">Java</form:option>
					</form:select>
				</div>
				
				<div class="form-group">
					<label >Code</label>
					<div id="editor"></div>
					<form:hidden id="solution" path="solution"/>
				</div>
				
				<div class="form-group">
					<label >Solution File</label>
					<form:input path="solutionFile" type="file" />
				</div>
				<button type="submit" class="btn btn-primary">
					Submit
				</button>
			</form:form>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("select").select2();
				var textarea = $('#solution');

			   var editor = ace.edit("editor");
			   editor.setTheme("ace/theme/github");
			   editor.getSession().setMode("ace/mode/java");

			   editor.getSession().on('change', function () {
			       textarea.val(editor.getSession().getValue());
			   });

			   textarea.val(editor.getSession().getValue());

			  
		});
	</script>
</body>
</html>