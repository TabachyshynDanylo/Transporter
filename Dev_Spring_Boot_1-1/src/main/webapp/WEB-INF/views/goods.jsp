<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Goods</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<form action="/admin/goods" method="POST">
				<div class="form-group row">
					<label class="col-2 col-form-label"> Name:</label>
					<div class="col-10">
						<input name="name" class="form-control">
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
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="goods" items="${goodss}"></c:forEach>
					<tr>
						<td>${goods.name}</td>
						<td class="text-center"><a
							href="/admin/goods/update/${goods.id}"
							class="btn btn-outline-warning btn-sm">Update</a> <a
							href="/admin/goods/delete/${goods.id}"
							class="btn btn-outline-danger btn-sm">Delete</a></td>
					</tr>
				</table>
			</div>
		</div>
	</div>

</body>
</html>