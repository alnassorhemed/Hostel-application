<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="hostel_reg.dao.OrderDao"%>
<%@page import="hostel_reg.beans.Orders"%>
<%
String id = request.getParameter("id");
OrderDao dao = new OrderDao();
Orders u = dao.get(id);
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
      <a class="nav-item nav-link" href="users.jsp">Students</a>
    </div>
    
    <a class="btn btn-danger btn-sm ml-auto" href="index.jsp">Logout</a>
  </div>
</nav>

<div class="main">
	<form method="post" action="orders/update">
		<div>
			<label>Student Name</label>
			<input type="text" name="name" value="<%= u.getNames() %>" required>
		</div>
		<div>
			<label>Date</label>
			<input type="date" name="date" value="<%= u.getDate() %>" required>
		</div>
		<div>
			<label>Block Name</label>
			<input type="text" name="blocks" value="<%= u.getBlock() %>" required>
		</div>
		<div>
			<label>Room No:</label>
			<input type="number" name="room" value="<%= u.getRoomNo() %>" required>
		</div>
		<div>
			<label>Residence</label>
			<input type="text" name="recd" value="<%= u.getResidence() %>" required>
		</div>
		<div>
			<label>Disability</label>
			<input type="text" name="dis" value="<%= u.getDisability() %>" required>
		</div>
		<div>
			<label>Period</label>
			<input type="number" name="perd" value="<%= u.getPeriod() %>" required>
		</div>
		<input name="id" type="hidden" value="<%= u.getId() %>" />
		<button class="btn btn-info">Update </button>
	</form>
</div>
</body>
</html>