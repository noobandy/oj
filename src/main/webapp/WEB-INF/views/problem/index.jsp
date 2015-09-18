<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/DataTables/datatables.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/DataTables/datatables.js"></script>
<title><spring:message code="problem.indexpage.title" /></title>
</head>

<body>
	<div class="row">
		<div class="col-md-8">
			<!-- Nav tabs -->
			<ul class="nav nav-tabs nav-justified" role="tablist">
				<li role="presentation" class="active"><a href="#beginner-problem"
					aria-controls="beginner-problem" role="tab" data-toggle="tab">Beginner</a></li>
				<li role="presentation"><a href="#easy-problem"
					aria-controls="easy-problem" role="tab" data-toggle="tab">Easy</a></li>
				<li role="presentation"><a href="#medium-problem"
					aria-controls="medium-problem" role="tab" data-toggle="tab">Medium</a></li>
				<li role="presentation"><a href="#hard-problem"
					aria-controls="hard-problem" role="tab" data-toggle="tab">Hard</a></li>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane fade-in active" id="beginner-problem">
					<table id="problem-table" class="table table-striped table-hover">
						<thead>
							<tr>
								<th>Problem</th>
								<th>Successful Submissions</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
				<div role="tabpanel" class="tab-pane" id="easy-problem">...</div>
				<div role="tabpanel" class="tab-pane" id="medium-problem">...</div>
				<div role="tabpanel" class="tab-pane" id="hard-problem">...</div>
			</div>

		</div>
		<div class="col-md-4 verticalLine">
			<button id="notification-button" class="btn btn-block btn-primary" type="button">
				Notifications <span class="badge">30</span>
			</button>
			<hr/>
			<div id="notification-list">
				
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			for(var i = 0; i < 100; i++) {
				var className = "";
				
				
				if(i % 2 == 0) {
					className = "success";
				}
				
				if(i % 3 == 0) {
					className = "danger";
				}
				
				$("#problem-table > tbody").append($("<tr/>").addClass(className).append($("<td />").html("Problem "+i)).append($("<td/>").html(i)));
			}
			
			$("#notification-button").click(function() {
				var count = parseInt($(this).find("span.badge").html());
				
				for(var i = 0; i < count; i++) {
					$("#notification-list").prepend($('<div class="alert alert-warning alert-dismissible" role="alert">'
							  +'<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>'
							  +'<strong>Warning!</strong> Better check yourself, you\'re not looking too good.'
							+'</div>'));
				}
				
				$(this).find("span.badge").html("");
			});
			
			$("#problem-table").DataTable( {
				info : false,
				searching : false,
				lengthChange: false,
				columnDefs : [ {
					targets : 0,
					orderable : false
				}, {
					
				}]
			});
		});
	</script>
</body>
</html>