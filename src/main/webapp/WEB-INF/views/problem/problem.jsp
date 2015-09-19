<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html>
<head>
<title><spring:message code="problem.problempage.title" /></title>
</head>

<body>
	<div class="row">
		<div class="col-md-12">
			<div class="btn-group">
				<a class="btn btn-dfault"> <spring:message
						code="problem.problempage.submitsolution" />
				</a> <a class="btn btn-dfault"> <spring:message
						code="problem.problempage.allsubmissions" />
				</a>
			</div>
			<hr />
		</div>
	</div>
	<div class="row">
		<div class="col-md-7">
			<h1>Square</h1>
			<p>
				Write a program to calculate square of a given number N.
				<br/>
				Input : first line of input contains no of test cases T. then each line contains number N.
				<br/>
				Ouput : each line contains sqare of input N.
				<br/>
				Examle :
				<br/>
				Input :
				<br/> 
				2
				<br/>
				3
				<br/>
				5
				<br/>
				Output :
				<br/>
				9
				<br/>
				25
				<br/>
				Exlaination:
				<br/> 
				first line 2 (2 test cases) then each input 3 and 5 on seperate line. Their output 3^2 = 9, 5^2 = 25
			</p>
		</div>
		<div class="col-md-5">
			<table id="submission-table" class="table table-striped table-condensed">
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
						append($("<td/>").append($("<a/>").addClass("btn btn-default").html("View")))
						);
			}
			
		});
	</script>


</body>
</html>