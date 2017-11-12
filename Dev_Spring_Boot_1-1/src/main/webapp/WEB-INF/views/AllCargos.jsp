<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

<title>Transport</title>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-12">
			<form:form action="/cargos" method="GET" modelAttribute="cargoFilter">
				<div class="form-group row ">
					  <div class="col-4 ml-auto ">
					   		<form:input path="minWeight" class="form-control form-control-sm" placeholder="Min weight"/>
					  </div>
					  <div class="col-4  mr-auto">
					   		<form:input path="maxWeight" class="form-control form-control-sm" placeholder="Max weight"/>
					  </div>
				</div>
				<div class="form-group row ">
					  <div class="col-4 ml-auto ">
					   		<form:input path="minHeight" class="form-control form-control-sm" placeholder="Min height"/>
					  </div>
					  <div class="col-4  mr-auto">
					   		<form:input path="maxHeight" class="form-control form-control-sm" placeholder="Max height"/>
					  </div>
				</div>
				<div class="form-group row ">
					  <div class="col-4 ml-auto ">
					   		<form:input path="minWidth" class="form-control form-control-sm" placeholder="Min width"/>
					  </div>
					  <div class="col-4  mr-auto">
					   		<form:input path="maxWidth" class="form-control form-control-sm" placeholder="Max width"/>
					  </div>
				</div>
				<div class="form-group row ">
					  <div class="col-4 ml-auto ">
					   		<form:input path="minLength" class="form-control form-control-sm" placeholder="Min length"/>
					  </div>
					  <div class="col-4  mr-auto">
					   		<form:input path="maxLength" class="form-control form-control-sm" placeholder="Max length"/>
					  </div>
				</div>
				<div class="form-group row ">
					  <div class="col-4 ml-auto ">
					   		<form:input path="minPrice" class="form-control form-control-sm" placeholder="Min price"/>
					  </div>
					  <div class="col-4  mr-auto">
					   		<form:input path="maxPrice" class="form-control form-control-sm" placeholder="Max price"/>
					  </div>
				</div>
				<div class="form-group row">
					<div class="col-2 ml-auto ">
						<label>City from:</label>
						<form:select class="form-control-sm" path="cityFrom">
							<form:option value="">All</form:option>
							<form:options items="${citys}"/>
						</form:select>
					</div>
					<div class="col-2 ">
						<label>City to:</label>
						<form:select class="form-control-sm" path="cityTo">
							<form:option value="">All</form:option>
							<form:options items="${citys}"/>
						</form:select>
					</div>
					<div class="col-2 text-center ">
 						<button class="dropdown-toggle btn btn-outline-primary btn-sm dropdown-toggle" type="button" data-toggle="dropdown">Sort <span class="caret"></span>
 						</button>
 						<div class="dropdown-menu">
 							<custom:sort innerHtml="Price: lowest first" paramValue="price"/>
 							<custom:sort innerHtml="Price: highest first" paramValue="price,desc"/>
 						</div>
 					</div>
		 			<div class="col-2 text-center mr-auto">
		 				<custom:size posibleSizes="1,2,5,10" size="${cargos.size}" />
		 			</div>
				</div>
				<div class="form-group row">
 						<div class="col-10 ml-auto">
         					<button type="submit" class="btn btn-outline-success btn-sm">Search</button>
         					<a href="/cargos/clean<custom:allParams/>" class="btn btn-outline-success btn-sm">Clean</a>
       					</div>
       			</div>
			</form:form>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
			<div class="col-12">
				<table class="table table-hover table-inverse">
				<thead>
					<tr>
						<th class="text-center">Owner</th>
						<th class="text-center">Goods</th>
						<th class="text-center">Weight</th>
						<th class="text-center">Dimensions</th>
						<th class="text-center">City from</th>
						<th class="text-center">City to</th>
						<th class="text-center">Price</th>
						<th class="text-center">Options</th>
					</tr>
				</thead>
					<tbody>
					<c:forEach var="cargo" items="${cargos.content}">
						<tr>
							<td class="text-center">${cargo.owner}</td>
							<td class="text-center">${cargo.goods}</td>
							<td class="text-center">${cargo.weight} kg</td>
							<td class="text-center">${cargo.length}*${cargo.width}*${cargo.height} mm</td>
							<td class="text-center">${cargo.cityFrom}</td>
							<td class="text-center">${cargo.cityTo}</td>
							<td class="text-center">${cargo.price} Uah</td>
							<td class="text-center">
							<sec:authorize access="isAuthenticated()">
								<a href="/cargo/${cargo.id}"  class="btn btn-outline-light btn-sm">Details</a>
								</sec:authorize>
								<sec:authorize access="isAnonymous()">
								<a href="/login"  class="btn btn-outline-light btn-sm">Details</a>
								</sec:authorize>
							</td>
						</tr>
					</c:forEach>
						</tbody>
				</table>
			</div>
		</div>
		<div class="row"> 
 			<div class="col-md-12 col-xs-12 text-center">
 				<custom:pageable page="${cargos}"/>
 			</div>
 		</div>
</div>
</body>
</html>