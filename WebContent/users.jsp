<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="hostel_reg.dao.UserDao"%>
<%@page import="hostel_reg.beans.User"%>
<%@ page import="java.util.List" %>

<%
UserDao dao = new UserDao();
List<User> users = dao.getAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User page</title>
<link href="style.css" rel="stylesheet">
<link rel="stylesheet" href="bootstrap/vendor/bootstrap/css/bootstrap.css">

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
	<h2 align="center" class="m-0">User List</h2>
	<a href="add-user.jsp" class="btn btn-primary">Add User</a>
	</div>
	<table class="table table-sm table-bordered">
		<tr>
			<th>Id</th>
			<th>Full Name</th>
			<th>Email</th>
			<th>Username</th>
			<th class="text-center">Action</th>
		</tr>
		<% for(User u: users) { %>
		<tr>
			<td><%= u.getId() %></td>
			<td><%= u.getName() %></td>
			<td><%= u.getEmail() %></td>
			<td><%= u.getUsername() %></td>
			<td class="text-center">
				<a class="btn btn-info" href="edit-user.jsp?id=<%=u.getId()%>">Edit</a> | 
				<a class="btn btn-danger" href="users/delete?id=<%=u.getId()%>">Delete</a>
			</td>
		</tr>
		<% } %>
	</table>
</div>
</body>
</html>