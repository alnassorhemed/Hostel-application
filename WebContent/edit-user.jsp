<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="hostel_reg.dao.UserDao"%>
<%@page import="hostel_reg.beans.User"%>
<%
String id = request.getParameter("id");
UserDao dao = new UserDao();
User u = dao.get(id);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	<form method="post" action="users/update">
		<div>
			<label>Full Name</label>
			<input type="text" name="name" value="<%= u.getName() %>" required>
		</div>
		<div>
			<label>Email</label>
			<input type="text" name="email" value="<%= u.getEmail() %>" required>
		</div>
		<div>
			<label>Username</label>
			<input type="text" name="user" value="<%= u.getUsername() %>" required>
		</div>
		<div>
			<label>Password</label>
			<input type="password" name="pass" value="<%= u.getPassword() %>" required>
		</div>
		<input name="id" type="hidden" value="<%= u.getId() %>" />
		<button class="btn btn-info">Update</button>
	</form>
</div>
</body>
</html>