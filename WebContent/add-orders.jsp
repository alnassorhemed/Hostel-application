<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet">
<link href="bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

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
	<form method="post" action="orders">
		<div>
			<label>Student Name</label>
			<input type="text" name="name" required>
		</div>
		<div>
			<label>Date</label>
			<input type="date" name="date" required>
		</div>
		<div>
			<label>Block Name</label>
			<input type="text" name="blocks" required>
		</div>
		<div>
			<label>Room No:</label>
			<input type="number" name="room" required>
		</div>
		<div>
			<label>Residence</label>
			<input type="text" name="recd" required>
		</div>
		<div>
			<label>Disability</label>
			<input type="text" name="dis" required>
		</div>
		<div>
			<label>Period</label>
			<input type="number" name="perd" required>
		</div>
		<button class="btn btn-info">Submit</button>
	</form>
</div>
</body>
</html>