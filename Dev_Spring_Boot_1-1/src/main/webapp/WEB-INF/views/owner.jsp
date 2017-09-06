<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<title>Owner</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<form action="/admin/cargo" method="POST">
				<div class="form-group row">
					<label class="col-2 col-form-label"> Name: </label>
					<div class="col-10">
						<input name="name" class="form-control">
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-2 col-form-label"> Phone: </label>
					<div class="col-10">
						<input name="phone" class="form-control">
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-2 col-form-label"> Count: </label>
					<div class="col-10">
						<input name="count" class="form-control">
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-2 col-form-label"> Address: </label>
					<div class="col-10">
						<input name="address" class="form-control">
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-2 col-form-label"> Cargos: </label>
					<div class="col-10">

						<select name="cargo" class="form-control">
							<c:forEach var="cargo" items="${cargos}">
								<option value="${cargo}">${cargo}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="form-group row">
					<div class="col-10 offset-sm-2">
						<button type="submit" class="btn btn-outline-success btn-sm">Save</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Name</th>
						<th class="text-center">Phone</th>
						<th class="text-center">Count</th>
						<th class="text-center">Address</th>
						<th class="text-center">Cargos</th>

						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="owner" items="${owners}"></c:forEach>
					<tr>
						<td>${owner.name}</td>
						<td>${owner.phone}</td>
						<td>${owner.count}</td>
						<td>${owner.address}</td>
						<td>${owner.cargos}</td>
						<td class="text-center"><a
							href="/admin/owner/update/${owner.id}"
							class="btn btn-outline-warning btn-sm">Update</a> <a
							href="/admin/owner/delete/${owner.id}"
							class="btn btn-outline-danger btn-sm">Delete</a></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>