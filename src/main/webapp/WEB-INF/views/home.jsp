<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>
	<spring:message code="Application.brand" />
</title>
</head>
<body>
	<spring:message code="User.emailId" var="emailIdPlaceHolder" />
	<spring:message code="User.password" var="passwordPlaceHolder" />
	<spring:message code="User.repeatPassword"
		var="repeatPasswordPlaceHolder" />
	<div class="row">
		<div class="col-md-7">Brag about this site here :)</div>
		<div class="col-md-5 verticalLine">
			<form:form action="${pageContext.request.contextPath}/register"
				modelAttribute="registrationCommand">
				<legend>
					<spring:message code="Register.User" />
				</legend>
				<c:set var="emailIdHasErrors">
					<form:errors path="emailId" />
				</c:set>

				<c:set var="passwordHasErrors">
					<form:errors path="password" />
				</c:set>

				<c:set var="repeatPasswordHasErrors">
					<form:errors path="repeatPassword" />
				</c:set>

				<div
					class="form-group <c:if test="${not empty emailIdHasErrors}">
					has-error
				</c:if>">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-envelope"></i>
						</span>
						<form:input class="form-control input-lg" path="emailId"
							placeholder="${emailIdPlaceHolder}" />
						<span class="help-block"> <spring:message
								code="Help.User.emailId" />
						</span>
					</div>

				</div>
				<div
					class="form-group <c:if test="${not empty passwordHasErrors}">
					has-error
				</c:if>">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-lock"></i>
						</span>
						<form:input type="password" class="form-control input-lg"
							path="password" placeholder="${passwordPlaceHolder}" />
						<span class="help-block"> <spring:message
								code="Help.User.password" />
						</span>
					</div>

				</div>
				<div
					class="form-group <c:if test="${not empty repeatPasswordHasErrors}">
					has-error
				</c:if>">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-lock"></i>
						</span>
						<form:input type="password" class="form-control input-lg"
							path="repeatPassword" placeholder="${repeatPasswordPlaceHolder }" />
						<span class="help-block"> <spring:message
								code="Help.User.repeatPassword" />
						</span>
					</div>

				</div>
				<button type="submit" class="btn btn-lg btn-primary">
					<spring:message code="Register.User" />
				</button>
			</form:form>
		</div>
	</div>
</body>
</html>
