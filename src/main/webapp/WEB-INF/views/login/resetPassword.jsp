<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Reset Password</title>
</style>
</head>
<body>
	<div class="row">
		<div class="col-md-4">
		</div>
		<div class="col-md-4">
			<form action="">
				<legend>
					Reset Password
				</legend>
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-lock"></i>
						</span> <input class="form-control input-lg" name="password"
							placeholder="password">
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-lock"></i>
						</span> <input class="form-control input-lg" name="repeatPassword"
							placeholder="repeat password">
					</div>
				</div>
				<button type="submit" class="btn btn-lg btn-primary">
					Reset Password</button>
			</form>
		</div>
		<div class="col-md-4"></div>
	</div>
</body>
</html>
