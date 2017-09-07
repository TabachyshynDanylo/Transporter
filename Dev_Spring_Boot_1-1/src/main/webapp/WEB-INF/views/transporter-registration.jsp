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
<title>Registration</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<form:form action="/registration/transporter" method="POST"
					modelAttribute="transporter">
					<div class="form-group row">
						<label class="col-2 col-form-label" for="email">Email:</label>
						<div class="col-10">
							<form:input path="email" id="email" class="form-control" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="password">Password:</label>
						<div class="col-10">
							<form:password path="password" id="password" class="form-control" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="repeatPassword">Repeat
							password:</label>
						<div class="col-10">
							<form:password path="repeatPassword" id="repeatPassword"
								class="form-control" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="name">Name:</label>
						<div class="col-10">
							<form:input path="name" id="name" class="form-control" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="maxWeight">Max
							weight:</label>
						<div class="col-10">
							<form:input path="maxWeight" id="maxWeight" class="form-control" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="age">Age:</label>
						<div class="col-10">
							<form:input path="age" id="age" class="form-control" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="phone">Phone:</label>
						<div class="col-10">
							<form:input path="phone" id="phone" class="form-control" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="brand">Brand:</label>
						<div class="col-10">
							<form:select path="brand" id="brand" class="form-control"
								items="${brands}" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="model">Model:</label>
						<div class="col-10">
							<form:select path="model" id="model" class="form-control"
								items="${models}" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="carAge">Car age:</label>
						<div class="col-10">
							<form:input path="carAge" id="carAge" class="form-control" />
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 ml-auto">
							<button class="btn btn-outline-success btn-sm">Register</button>
							<a href="/registration/owner"
								class="btn btn-outline-primary btn-sm">Owner registration</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>