<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>	
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">
				<i class="glyphicon glyphicon-home"></i>	<spring:message code="Application.brand"/>
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Language <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="?lang=hi">Hindi</a></li>
						<li><a href="?lang=en">English</a></li>
					</ul></li>
				<security:authorize access="hasRole('PROBLEM_SETTER_ROLE')">
					<li>
					<a
						href="${pageContext.request.contextPath}/problem/add"> <i class="glyphicon glyphicon-upload"></i> Upload Problem</a></li>
				</security:authorize>	
			</ul>

			<security:authorize access="isAnonymous()">
				<form class="navbar-form navbar-right" role="login"
					action="${pageContext.request.contextPath}/j_spring_security_check"
					method="post">
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-envelope"></i>
							</span> <input type="text" class="form-control" name="emailId"
								placeholder="email id">
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-lock"></i>
							</span> <input type="password" class="form-control"
								placeholder="password" name="password">
						</div>
						<span class="help-inline"> <a
							href="${pageContext.request.contextPath}/forgotPassword">Forgot
								password?</a>
						</span>
					</div>
					<div class="form-group">
						<div class="checkbox">
							<label> <input value="true" type="checkbox"
								name="_spring_security_remember_me"> Remember
							</label>
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Login</button>
				</form>
			</security:authorize>

			<security:authorize access="isAuthenticated()">
				<ul class="nav navbar-nav navbar-right">
					<li>
					<a
						href="${pageContext.request.contextPath}/j_spring_security_logout"> <i class="glyphicon glyphicon-off"></i> Log
							out</a></li>
				</ul>
			</security:authorize>

		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>