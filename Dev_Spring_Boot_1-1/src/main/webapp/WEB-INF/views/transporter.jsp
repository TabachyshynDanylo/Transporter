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
<title>Transporter</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<form:form action="/admin/transporter" method="POST" modelAttribute="transporter">
				<div class="form-group row">
					<label class="col-2 col-form-label"> Name: </label>
					<div class="col-10">
						<form:input path="name" class="form-control" />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-2 col-form-label"> Rate: </label>
					<div class="col-10">
						<form:input path="rate" class="form-control" />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-2 col-form-label"> Max weight: </label>
					<div class="col-10">
						<form:input path="maxWeight" class="form-control" />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-2 col-form-label"> Count: </label>
					<div class="col-10">
						<form:input path="count" class="form-control" />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-2 col-form-label"> Photo URL: </label>
					<div class="col-10">
						<form:input path="photoUrl" class="form-control" />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-2 col-form-label"> Version: </label>
					<div class="col-10">
						<form:input path="version" class="form-control" />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-2 col-form-label"> Age: </label>
					<div class="col-10">
						<form:input path="age" class="form-control" />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-2 col-form-label"> Phone: </label>
					<div class="col-10">
						<form:input path="phone" class="form-control" />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-2 col-form-label"> Brand: </label>
					<div class="col-10">
						<form:select path="brand" items="${brands}" class="form-control"/>

					</div>
				</div>

				<div class="form-group row">
					<label class="col-2 col-form-label"> Model: </label>
					<div class="col-10">
<form:select path="model" items="${models}" class="form-control"/>
						
					</div>
				</div>

				<div class="form-group row">
					<label class="col-2 col-form-label"> Car age: </label>
					<div class="col-10">
						<form:input path="carAge" class="form-control" />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-2 col-form-label"> City arrive: </label>
					<div class="col-10">
<form:select path="cityArrive" items="${city's}" class="form-control"/>
						
					</div>
				</div>

				<div class="form-group row">
					<label class="col-2 col-form-label"> Date arrive: </label>
					<div class="col-10">
<form:select path="dateArrive" items="${dateArrives}" class="form-control"/>
						
					</div>
				</div>

				<div class="form-group row">
					<label class="col-2 col-form-label"> Status: </label>
					<div class="col-10">
<form:select path="status" items="${statuses}" class="form-control"/>
						
					</div>
				</div>

				<div class="form-group row">
					<div class="col-10 offset-sm-2">
						<button type="submit" class="btn btn-outline-success btn-sm">Save</button>
						<a href="/admin/transporter/cancel"
							class="btn btn-outline-warning btn-sm">Cancel</a>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Name</th>
						<th class="text-center">Rate</th>
						<th class="text-center">Max weight</th>
						<th class="text-center">Count</th>
						<th class="text-center">Photo URL</th>
						<th class="text-center">Version</th>
						<th class="text-center">Age</th>
						<th class="text-center">Phone</th>
						<th class="text-center">Brand</th>
						<th class="text-center">Model</th>
						<th class="text-center">Car age</th>
						<th class="text-center">City arrive</th>
						<th class="text-center">Date arrive</th>
						<th class="text-center">Status</th>

						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="transporter" items="${transporters}"></c:forEach>
					<tr>
						<td>${transporter.name}</td>
						<td>${transporter.rate}</td>
						<td>${transporter.maxWeight}</td>
						<td>${transporter.count}</td>
						<td>${transporter.photoUrl}</td>
						<td>${transporter.version}</td>
						<td>${transporter.age}</td>
						<td>${transporter.phone}</td>
						<td>${transporter.brand}</td>
						<td>${transporter.model}</td>
						<td>${transporter.carAge}</td>
						<td>${transporter.cityArrive}</td>
						<td>${transporter.dateArrive}</td>
						<td>${transporter.status}</td>
						<td class="text-center"><a
							href="/admin/transporter/update/${transporter.id}"
							class="btn btn-outline-warning btn-sm">Update</a> <a
							href="/admin/transporter/delete/${transporter.id}"
							class="btn btn-outline-danger btn-sm">Delete</a></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>