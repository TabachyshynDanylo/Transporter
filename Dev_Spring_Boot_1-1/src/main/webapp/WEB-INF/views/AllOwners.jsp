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
		<div class="col-12 ">
			<form:form action="/owners" method="GET" modelAttribute="ownerFilter">
				<div class="form-group row">
					  <div class="col-4 ml-auto">
					   		<form:input path="minCount" class="form-control form-control-sm" placeholder="Min count"/>
					  </div>
					  <div class="col-4 mr-auto">
					   		<form:input path="maxCount" class="form-control form-control-sm" placeholder="Max count"/>
					  </div>
				</div>
				<div class="form-group row">
					<div class="col-4 ml-auto">
						<form:input path="address" class="form-control form-control-sm" placeholder="Address"/>
					</div>
					<div class="col-2 text-center ">
 						<button class="dropdown-toggle btn btn-outline-primary btn-sm dropdown-toggle" type="button" data-toggle="dropdown">Sort <span class="caret"></span>
 						</button>
 						<div class="dropdown-menu">
 							<custom:sort innerHtml="Count: lowest first" paramValue="count"/>
 							<custom:sort innerHtml="Count: highest first" paramValue="count,desc"/>
 						</div>
 					</div>
		 			<div class="col-2 text-center mr-auto">
		 				<custom:size posibleSizes="1,2,5,10" size="${owners.size}" />
		 			</div>
				</div>
				<div class="form-group row">
 						<div class="col-10 ml-auto">
         					<button type="submit" class="btn btn-outline-success btn-sm">Search</button>
         					<a href="/owners/clean<custom:allParams/>" class="btn btn-outline-success btn-sm">Clean</a>
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
						<th class="text-center">Name</th>
						<th class="text-center">Count</th>
						<th class="text-center">Phone</th>
						<th class="text-center">Address</th>
						<th class="text-center">Options</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach var="owner" items="${owners.content}">
						<tr>
							<td class="text-center">${owner.name}</td>
							<td class="text-center">${owner.count}</td>
							<td class="text-center">${owner.phone}</td>
							<td class="text-center">${owner.address}</td>
							<td class="text-center">
							<sec:authorize access="isAuthenticated()">
								<a href="/owner/${owner.id}"  class="btn btn-outline-light btn-sm">Details</a>
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
 				<custom:pageable page="${owners}"/>
 			</div>
 		</div>
</div>
</body>
</html>