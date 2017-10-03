<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="custom" uri="/WEB-INF/tags/implicit.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<title>Cargo</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-3">
				<form:form modelAttribute="filter" action="/admin/cargo"
					method="GET">
					<div class="form-group row">
						<div class="col-12">
							<form:input path="search" class="form-control"
								placeholder="search" />
						</div>
					</div>
				</form:form>
			</div>
			<div class="col-9">
				<form:form action="/admin/cargo" method="POST"
					modelAttribute="cargo">
					<custom:hiddenInputs excludeParams="name"/>
					<div class=" row">
					<div class="col-10 ml-auto" style="color: red;">
							<form:errors path="name" />
						</div>
						<label class="col-2 col-form-label"> Goods: </label>
						<div class="col-10">
							<form:select path="goods" items="${goodss}" class="form-control" />

						</div>
					</div>

					<div class="form-group row">
						<label class="col-2 col-form-label"> Weight: </label>
						<div class="col-10">
							<form:input path="weight" class="form-control" />
						</div>
					</div>

					<div class="form-group row">
						<label class="col-2 col-form-label"> Height: </label>
						<div class="col-10">
							<form:input path="height" class="form-control" />
						</div>
					</div>

					<div class="form-group row">
						<label class="col-2 col-form-label"> Width: </label>
						<div class="col-10">
							<form:input path="width" class="form-control" />
						</div>
					</div>

					<div class="form-group row">
						<label class="col-2 col-form-label"> Length: </label>
						<div class="col-10">
							<form:input path="length" class="form-control" />
						</div>
					</div>

					<div class="form-group row">
						<label class="col-2 col-form-label"> City from: </label>
						<div class="col-10">
							<form:select path="cityFrom" items="${city's}"
								class="form-control" />

						</div>
					</div>


					<div class="form-group row">
						<label class="col-2 col-form-label"> City to: </label>
						<div class="col-10">
							<form:select path="cityTo" items="${city's}" class="form-control" />

						</div>
					</div>

					<div class="form-group row">
						<label class="col-2 col-form-label"> Price: </label>
						<div class="col-10">
							<form:input path="price" class="form-control" />
						</div>
					</div>

					<div class="form-group row">
						<div class="col-10 offset-sm-2">
							<button type="submit" class="btn btn-outline-success btn-sm">Save</button>
							<a href="/admin/cargo/cancel<custom:allParams/>"
								class="btn btn-outline-warning btn-sm">Cancel</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-9">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Goods</th>
						<th class="text-center">Weight</th>
						<th class="text-center">Height</th>
						<th class="text-center">Width</th>
						<th class="text-center">Length</th>
						<th class="text-center">City from</th>
						<th class="text-center">City to</th>
						<th class="text-center">Price</th>
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="cargo" items="${cargos.content}">
						<tr>
							<td>${cargo.goods}</td>
							<td>${cargo.weight}</td>
							<td>${cargo.height}</td>
							<td>${cargo.width}</td>
							<td>${cargo.length}</td>
							<td>${cargo.cityFrom}</td>
							<td>${cargo.cityTo}</td>
							<td>${cargo.price}</td>
							<td class="text-center"><a
								href="/admin/cargo/update/${cargo.id}<custom:allParams/>"
								class="btn btn-outline-warning btn-sm">Update</a> <a
								href="/admin/cargo/delete/${cargo.id}<custom:allParams/>"
								class="btn btn-outline-danger btn-sm">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-3">
				<div class="row">
					<div class="col-6 text-center">
							<button class="dropdown-toggle btn btn-outline-primary btn-sm dropdown-toggle" type="button" data-toggle="dropdown">Sort <span class="caret"></span>
							</button>
							<div class="dropdown-menu">
								<custom:sort innerHtml="Name asc" paramValue="name"/>
								<custom:sort innerHtml="Name desc" paramValue="name,desc"/>
							</div>
					</div>
					<div class="col-6 text-center">
						<custom:size posibleSizes="1,2,5,10" size="${cargos.size}" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-12 text-center">
				<custom:pageable page="${cargos}" />
			</div>
		</div>
	</div>
</body>
</html>