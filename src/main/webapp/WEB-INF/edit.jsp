<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Burger</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="bg-light">
	<div class="container col-6 d-flex justify-content-between gap-3 align-content-center py-5 px-2 margin-2">
		<h1 class="text-primary">Burger Tracker</h1>
		<div class="pt-1">
			<a class="btn btn-primary" href="/burgers">Home</a>
		</div>
	</div>		
	<div class="container card bg-dark text-light col-6 d-flex flex-column justify-content-center gap-3 align-content-center p-5 margin-2">
		<h1 class="text-primary text-center h2">Edit Burger</h1>
		<form:form action="/burgers/${burger.id}" method="POST" modelAttribute="burger">
			<input type="hidden" name="_method" value="PUT" />
			<div class="p-2 d-flex flex-column justify-content-start gap-1">
				<div class="d-flex flex-column gap-2 ps-2">
					<form:label path="name">Burger Name</form:label>
					<form:errors class="text-danger fw-bold fst-italic" path="name"/>
					<form:input class="form-control" type="text" path="name" />
				</div>
				<div class="d-flex flex-column gap-2 ps-2">
					<form:label path="restaurantName">Restaurant Name</form:label>
					<form:errors class="text-danger fw-bold fst-italic" path="restaurantName"/>
					<form:input class="form-control" type="text" path="restaurantName" />
				</div>
				<div class="d-flex flex-column gap-2 ps-2">
					<form:label path="rating">Rating</form:label>
					<form:errors class="text-danger fw-bold fst-italic" path="rating"/>
					<form:input class="form-control" type="number" path="rating" />
				</div>
				<div class="d-flex flex-column gap-2 ps-2">
					<form:label path="notes">Notes</form:label>
					<form:errors class="text-danger fw-bold fst-italic" path="notes"/>
					<form:textarea class="form-control" path="notes" cols="10" rows="3"></form:textarea>
				</div>
			</div>
			<div class="text-end pe-2">
				<button class="btn btn-success" type="submit">Edit Burger</button>						
			</div>
		</form:form>
	</div>
</body>
</html>