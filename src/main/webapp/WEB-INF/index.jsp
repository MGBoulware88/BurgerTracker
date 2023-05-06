<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Burger Tracker</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="bg-light">
	<div class="container d-flex flex-column justify-content-center gap-3 align-content-center p-5 margin-2">
		<h1 class="text-primary">All Burgers</h1>
		<table class="table table-bordered table-striped table-dark">
			<thead>
				<tr>
					<th>Burger Name</th>
					<th>Restaurant Name</th>
					<th>Rating (out of 5)</th>
					<th colspan="2" >Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="burger" items="${allBurgers}">
				<tr>
					<td class=""><c:out value="${burger.name}"/></td>
					<td class=""><c:out value="${burger.restaurantName}"/></td>
					<td class=""><c:out value="${burger.rating}"/></td>
					<td><a class="btn btn-success" href="/burgers/edit/${burger.id}">Edit</a></td>
					<td>
						<form method="POST" action="/burgers/delete/${burger.id}">
							<input type="hidden" name="_method" value="DELETE" />
							<button class="btn btn-danger" type="submit">Delete</button>						
						</form>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />
		<!-- I'd rather put this on a differnet page, but the wireframe had it on index -->
		<div class="container card bg-dark text-light col-6 d-flex flex-column justify-content-center gap-3 align-content-center p-5 margin-2">
			<h1 class="text-primary text-center">New Burger</h1>
		
			<form:form action="/burgers/create" method="POST" modelAttribute="burger">
				<div class="p-2 d-flex flex-column bg-dark text-light justify-content-start gap-1">
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
					<button class="btn btn-primary" type="submit">Add Burger</button>						
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>