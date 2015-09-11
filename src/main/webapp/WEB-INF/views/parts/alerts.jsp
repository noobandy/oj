<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<c:forEach items="${alerts}" var="alert">
	<c:choose>
		<c:when test="${alert.type == 'success' }">
			<div class="alert alert-success alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<c:out value="${alert.message}"></c:out>
			</div>
		</c:when>
		<c:when test="${alert.type == 'error' }">
			<div class="alert alert-danger alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<c:out value="${alert.message}"></c:out>
			</div>
		</c:when>
		<c:when test="${alert.type == 'warning' }">
			<div class="alert alert-warning alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<c:out value="${alert.message}"></c:out>
			</div>
		</c:when>
		<c:when test="${alert.type == 'info' }">
			<div class="alert alert-info alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<c:out value="${alert.message}"></c:out>
			</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>

	</c:choose>
</c:forEach>