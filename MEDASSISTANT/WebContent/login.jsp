<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>MedAssistant | Login </title>
<link rel="icon" href="core/img/core-img/favicon.ico">
<link rel="stylesheet" href="style.css">
</head>
<body>

<div id="preloader">
	<div class="medilife-load"></div>
</div>

	<%@ include file="core/header/header.jsp" %>  

<br>
<br>
<br>
<br>
<br>
<br>

<div class="container" style="margin-bottom: 16px;">
	<div class="row mx-auto">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">
					<h5 class="card-title text-center">Accedi</h5>
						<form action="${pageContext.request.contextPath}/autenticazione" method="POST" name="loginForm" onsubmit="return validateLoginForm(loginForm)">
							<div class="form-label-group">
								<label for="inputEmail">Email</label>
								<input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email" required autofocus>
							</div>
							<div class="form-label-group">
								<label for="inputPassword">Password</label>
								<input type="password" id="inputPassword" name="psw" class="form-control" placeholder="Password" required>
							</div>
                    		<button class="btn btn-lg btn-primary btn-block text-uppercase" id="btn_signin" type="submit">Accedi</button>
                    	</form>
                </div>
			</div>
		</div>
	</div>
</div>


<%@ include file="core/header/footer.jsp" %>  
	
<script src="js/validatingForm.js"></script>
<script src="core/js/jquery/jquery-2.2.4.min.js"></script>
<script src="core/js/popper.min.js"></script>
<script src="core/js/bootstrap.min.js"></script>
<script src="core/js/plugins.js"></script>
<script src="core/js/active.js"></script>


</body>
</html>