<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="hostel_reg.dao.OrderDao"%>
<%@page import="hostel_reg.beans.Orders"%>
<%@ page import="java.util.List" %>

<%
OrderDao dao = new OrderDao();
List<Orders> orders = dao.getAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking page</title>
<link href="style.css" rel="stylesheet">
<link rel="stylesheet" href="bootstrap/vendor/bootstrap/css/bootstrap.min.css">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="#">Hostel Management System</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
       <a class="nav-item nav-link" href="orders.jsp">Booking</a>
      <a class="nav-item nav-link" href="users.jsp">Users</a>
    </div>
    
    <a class="btn btn-danger btn-sm ml-auto" href="index.jsp">Logout</a>
  </div>
</nav>

<div class="main">
	<div class="d-flex justify-content-between align-items-end mb-3">
	<h2 align="center" class="m-0">Booking List</h2>
	<a href="add-orders.jsp" class="btn btn-primary">Add Booking</a>
	</div>
	
	<table class="table table-sm table-bordered" >
		<tr>
			<th>Id</th>
			<th>Student Name</th>
			<th>Date</th>
			<th>Block Name</th>
			<th>Room No:</th>
			<th>Residence</th>
			<th>Disability</th>
			<th>Period(years)</th>
			<th class="text-center">Actions</th>
		</tr>
		<%
			for(Orders u: orders) {
		%>
		<tr>
			<td><%= u.getId() %></td>
			<td><%= u.getNames() %></td>
			<td><%= u.getDate() %></td>
			<td><%= u.getBlock() %></td>
			<td><%= u.getRoomNo() %></td>
			<td><%= u.getResidence() %></td>
			<td><%= u.getDisability() %></td>
			<td><%= u.getPeriod() %></td>
			<td class="text-center">
				<a class="btn btn-info" href="edit-orders.jsp?id=<%=u.getId()%>">Edit</a> ||
				<a class="btn btn-danger" href="orders/delete?id=<%=u.getId()%>">Delete</a>
			</td>
		</tr>
		<% } %>
	</table>
</div>
</body>
</html>