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
<link rel="icon" href="${pageContext.request.contextPath}/core/img/core-img/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath}/core/css/style.css">
<script src="${pageContext.request.contextPath}/core/js/jquery/jquery-2.2.4.min.js"></script>
<script src="${pageContext.request.contextPath}/core/js/validatingForm.js"></script>
</head>
<body>

<div id="preloader">
	<div class="medilife-load"></div>
</div>

<br>
<br>
<br>
<br>
<br>
<br>

<div class="container" style="margin-bottom: 16px">
	<div class="row mx-auto">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">
					<h5 class="card-title text-center">Accedi</h5>
						<form method="POST" name="loginForm" onsubmit="return canAccess()">
							<div class="form-label-group">
								<label for="inputEmail">Email</label>
								<input type="email" id="email" name="email" class="form-control" placeholder="Email">
								<p id="outEmail" style="color: red"></p>
							</div>
							<div class="form-label-group">
								<label for="inputPassword">Password</label>
								<input type="password" id="psw" name="psw" class="form-control" placeholder="Password">
								<p id="outPsw" style="color: red"></p>
							</div>
                    		<button class="btn btn-lg btn-primary btn-block" type="submit" id="buttLogin">Controlla credenziali</button>
                    	</form>
                    	<form action="../generali/index.jsp" method="GET">
                    		<button class="btn btn-lg btn-primary btn-block" type="submit" id="buttLogin2" style="display: none">Accedi</button>
						</form>
                </div>
			</div>
		</div>
	</div>
</div>


	<%@ include file="../generali/footer.jsp" %>    
 
    <script src="${pageContext.request.contextPath}/core/js/jquery/jquery-2.2.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/core/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/core/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/core/js/plugins.js"></script>
    <script src="${pageContext.request.contextPath}/core/js/active.js"></script>


</body>
</html>