<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<title>Login</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<form:form action="/login" method="POST">
				<div class="form-group row">
					<label class="col-2 form-col-label" for="email">Email:</label>
					<div class="col-10">
						<input name="login" id="email" class="form-control" />
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 form-col-label" for="password">Password:</label>
					<div class="col-10">
						<input type="password" name="password" id="password"
							class="form-control" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-10">
						<label><input type="checkbox" name="rememberMe">
							Remember me!</label>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-10 ml-auto">
						<button class="btn btn-outline-success btn-sm">Sign in</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>