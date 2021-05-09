<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Menu Page</title>
</head>
<body >
	<h1 align="center" >Admin Menu Items</h1>
	<table>
		<thead font-style="bold">
			<td><h3>Name &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</h3></td>
			<td><h3>Price&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</h3></td>
			<td><h3>Active&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</h3></td>
			<td><h3>Date of Launch &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</h3></td>
			<td><h3>Category &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</h3></td>
			<td><h3>Free Delivery &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</h3></td>
			<td><h3>Actions</h3></td>
		</thead>
		<c:forEach items = ${menu} var = "items">
		<tr>
			<td>${ items.name }</td>
			<td>${ items.price }</td>
			<td>${ items.active }</td>
			<td>${ items.date }</td>
			<td>${ items.category }</td>
			<td>${ items.delivery }</td>
			<td><input value="Delete"> &nbsp; <input value="Add"> </td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>