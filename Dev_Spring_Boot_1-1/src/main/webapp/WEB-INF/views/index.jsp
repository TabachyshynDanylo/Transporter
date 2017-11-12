<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<title>Transport</title>
</head>
<body>
	()
	<h2>${message}</h2>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<a href="/admin">Admin </a>
	</sec:authorize>
	<sec:authorize access="isAnonymous()">
		<a href="/login">Login </a>
		<a href="/registration">Registration </a>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<form:form action="/logout">
			<button class="btn btn-outline-dark btn-sm">Logout</button>
		</form:form>
	</sec:authorize>
	<form:form action="/" modelAttribute="fileRequest" enctype="multipart/form-data">
	<input type="file" name="file">
	<button>OK</button>
	
	</form:form>
	<div class="container">
		<div class="row">
			<div class="col-4">
				</h2>
				ТОП 5 ПЕРЕВІЗНИКІВ
				</h2>
			</div>
			<div class="col-4">
			</div>
			<div class="col-4">
				<h2>ТОП 5 КОРИСТУВАЧІВ</h2>
			</div>
		</div>
	</div>

</body>
</html>