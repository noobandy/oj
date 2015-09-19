<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-contextmenu/bootstrap-contextmenu.js"></script>
<title><spring:message code="problem.indexpage.title" /></title>
</head>

<body>
	<div class="row">
		<div class="col-md-12">
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
								<th><a href="?order=asc">  Successful Submissions </a></th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
					<nav>
						<ul class="pagination pagination-lg pull-right">
							<li><a href="#" aria-label="Previous"> <span
									aria-hidden="true">&laquo;</span>
							</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#" aria-label="Next"> <span
									aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>
				</div>
				<div role="tabpanel" class="tab-pane" id="easy-problem">...</div>
				<div role="tabpanel" class="tab-pane" id="medium-problem">...</div>
				<div role="tabpanel" class="tab-pane" id="hard-problem">...</div>
			</div>

		</div>
	</div>
	<div id="context-menu">
		<ul class="dropdown-menu" role="menu">
			<li><a tabindex="-1" href="#"><i class="glyphicon glyphicon-plus"></i> To-Do</a></li>
		</ul>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			for(var i = 0; i < 100; i++) {
				var className = "pending-problem";
				
				
				if(i % 2 == 0) {
					className = "success";
				}
				
				if(i % 3 == 0) {
					className = "danger";
				}
				
				$("#problem-table > tbody").append($("<tr/>").addClass(className).append($("<td />").append($("<a href='${pageContext.request.contextPath}/problem/problemId'/>").html("Problem "+i))).append($("<td/>").html(i)));
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
			
			$(".pending-problem").contextmenu({
				target:'#context-menu', 
				before: function(e,context) {
				  // execute code before context menu if shown
				},
				onItem: function(context,e) {
				  // execute on menu item selection
				  e.preventDefault();
				}
			});
			
			/* $("#problem-table").DataTable( {
				info : false,
				searching : false,
				lengthChange: false,
				ordering: true,
				pageLength: 50,
				order : [[1,"asc"]],
				columnDefs : [ {
					targets : 0,
					orderable : false
				}, {
					
				}]
			}); */
		});
	</script>
</body>
</html>