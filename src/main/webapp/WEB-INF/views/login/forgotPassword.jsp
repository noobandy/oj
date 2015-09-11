<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Forgot Password</title>
</head>
<body>
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<form action="">
				<legend> Forgot Password </legend>
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-envelope"></i>
						</span> <input class="form-control input-lg" name="emailId"
							placeholder="email id">
					</div>
				</div>
				<button type="submit" class="btn btn-lg btn-primary">Reset
					Password</button>
			</form>
		</div>
		<div class="col-md-4"></div>
	</div>
</body>
</html>
