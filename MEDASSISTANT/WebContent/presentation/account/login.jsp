<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MED ASSISTANT accedi</title>
</head>
<body>

<h2>LOGIN</h2>
<form action="../../autenticazione" method="POST" name="loginForm" onsubmit="return validateLoginForm(loginForm)">
<input type="text" name="email" placeholder="email"><br>
<input type="password" name="psw" placeholder="password"><br>
<input type="submit" value="Submit">
</form>

<script src="js/validatingForm.js"></script>

</body>
</html>