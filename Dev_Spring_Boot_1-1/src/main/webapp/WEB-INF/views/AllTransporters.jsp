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
			<form:form action="/transporters" method="GET" modelAttribute="transporterFilter">
				<div class="form-group row ">
					  <div class="col-4 ml-auto ">
					   		<form:input path="minRate" class="form-control form-control-sm" placeholder="Min rate"/>
					  </div>
					  <div class="col-4  mr-auto">
					   		<form:input path="maxRate" class="form-control form-control-sm" placeholder="Max rate"/>
					  </div>
				</div>
				<div class="form-group row">
					  <div class="col-4  ml-auto">
					   		<form:input path="minWeight" class="form-control form-control-sm" placeholder="Min weight"/>
					  </div>
					  <div class="col-4 mr-auto">
					   		<form:input path="maxWeight" class="form-control form-control-sm" placeholder="Max weight"/>
					  </div>
				</div>
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
					   		<form:input path="minAge" class="form-control form-control-sm" placeholder="Min age"/>
					  </div>
					  <div class="col-4 mr-auto">
					   		<form:input path="maxAge" class="form-control form-control-sm" placeholder="Max age"/>
					  </div>
				</div>
				<div class="form-group row">
					<div class="col-4 ml-auto">
						<label>City arrive</label>
						<form:select class="form-control-sm" path="cityId">
							<form:option value="">All</form:option>
							<form:options items="${city's}"/>
						</form:select>
					</div>
				<div class="col-2 text-center ">
 						<button class="dropdown-toggle btn btn-outline-primary btn-sm dropdown-toggle" type="button" data-toggle="dropdown">Sort <span class="caret"></span>
 						</button>
 						<div class="dropdown-menu">
 							<custom:sort innerHtml="Rate: lowest first" paramValue="rate"/>
 							<custom:sort innerHtml="Rate: highest first" paramValue="rate,desc"/>
 							<custom:sort innerHtml="Count: lowest first" paramValue="count"/>
 							<custom:sort innerHtml="Count: highest first" paramValue="count,desc"/>
 						</div>
 					</div>
		 			<div class="col-2 text-center mr-auto">
		 				<custom:size posibleSizes="1,2,5,10" size="${transporters.size}" />
		 			</div>
				</div>
				<div class="form-group row">
 					<div class="col-4 ml-auto">
 						<form:checkboxes items="${brands}" path="brandIds" element="div"/>
 					</div>
 					<div class="col-6 ">
 						<form:checkboxes items="${models}" path="modelIds" element="div"/>
 					</div>
 				</div>
 				<div class="form-group row">
 						<div class="col-10 ml-auto">
         					<button type="submit" class="btn btn-outline-success btn-sm">Search</button>
         					<a href="/transporters/clean<custom:allParams/>" class="btn btn-outline-success btn-sm">Clean</a>
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
						<th class="text-center">Photo</th>
						<th class="text-center">Name</th>
						<th class="text-center">Rate</th>
						<th class="text-center">Max weight</th>
						<th class="text-center">Count</th>
						<th class="text-center">Options</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach var="transporter" items="${transporters.content}">
						<tr>
							<td  class="text-center">		<img src="data:image/png;base64,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" class="rounded " alt="..."></td>
							<td  class="text-center"><h4>Name:</h4><br><h4>${transporter.name}</h4></td>
							<td class="text-center"><h4>Rate:</h4><br><h4>${transporter.rate}</h4></td>
							<td class="text-center"><h4>Max weight:</h4><br><h4>${transporter.maxWeight} kg</h4></td>
							<td class="text-center"><h4>Count:</h4><br><h4>${transporter.count}</h4></td>
							<td class="text-center">
								<sec:authorize access="isAuthenticated()">
								<a href="/transporter/${transporter.id}"  class="btn btn-outline-light ">Details</a>
								</sec:authorize>
								<sec:authorize access="isAnonymous()">
								<a href="/login"  class="btn btn-outline-light btn">Details</a>
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
				<custom:pageable page="${transporters}"/>
			</div>
		</div>
</div>
</body>
</html>