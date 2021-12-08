<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet">
<link rel="stylesheet" href="bootstrap/vendor/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="bootstrap/js/ruang-admin.js">

</head>
<body >
<div class="login" class="bg-warning">
<h2 align="center">Login Form</h2>
	<form method="post" action="login">
		<div>
			<label>Username</label>
			<input type="text" class="form-control" name="user" required>
		</div>
		<div>
			<label>Password</label>
			<input type="password" class="form-control" name="pass"  required>
		</div>
		<button class="btn btn-primary btn-lg btn-block">Login</button>

	</form>
</div>
</body>
</html>