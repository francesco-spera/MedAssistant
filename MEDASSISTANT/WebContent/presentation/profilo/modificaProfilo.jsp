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
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>MedAssistant | Modifica profilo</title>
<link rel="icon" href="${pageContext.request.contextPath}/core/img/core-img/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath}/core/css/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/core/vendor/animate/animate.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/core/vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/core/vendor/perfect-scrollbar/perfect-scrollbar.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/core/css/table_util.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/core/css/table_main.css">
<script src="${pageContext.request.contextPath}/core/js/jquery/jquery-2.2.4.min.js"></script>
<script src="${pageContext.request.contextPath}/core/js/validatingForm.js"></script>
</head>
<body>
    <div id="preloader">
        <div class="medilife-load"></div>
    </div>
	
	<%@ include file="../generali/header.jsp" %>  

	<div>
	<br>
	<br>
	<br>
	<br>
	<br>
	</div>
	
	<div class="container" style="margin-bottom: 16px;">
		<div class="row mx-auto">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<h2>Profilo personale</h2>
				<div class="card card-signin my-5">
					<div class="card-body">
						<h5 class="card-title text-center">Modifica il profilo</h5><hr>
							<c:choose>
	    					<c:when test="${docLog!=null}">
							<form action="${pageContext.request.contextPath}/ModificareProfilo" method="POST" name="regForm">
								<h4>Informazioni generali</h4> <br><br>
								<div class="form-label-group">
									<input type="hidden" id="email" name="emailM" class="form-control" value="${dettDoc.email}">
								</div>								
								<div class="form-label-group">
									<label for="inputPassword">Password</label>
									<input type="password" id="pswM" name="pswM" class="form-control">
									<p id="outPswM" style="color: red"></p>
								</div>
								<div class="form-label-group">
									<label>Nome</label>
									<input type="text" name="nameM" id="nameM" class="form-control" placeholder="${docLog.name}">
									<p id="outNameM" style="color: red"></p>
								</div>
								<div class="form-label-group">
									<label>Cognome</label>
									<input type="text" name="surnameM" id="surnameM" class="form-control" placeholder="${docLog.surname}">
									<p id="outSurnameM" style="color: red"></p>
								</div>
								<div class="form-label-group">
									<label>Data di nascita</label>
									<input type="date" name="birthM" id="birthM" class="form-control" placeholder="${docLog.birthDate}">
								</div>
								<div class="form-label-group">
									<label>Codice fiscale</label>
									<input type="text" name="cfM" id="cfM" class="form-control" placeholder="${docLog.cf}">
									<p id="outCfM" style="color: red"></p>
								</div>
								<h3>Informazioni specifiche account</h3> <br><br>
								<div class="form-label-group">
									<label>Numero di telefono</label>
									<input type="text" name="mobilep" id="mobilep" class="form-control" placeholder="${dettDoc.phoneNumber}">
									<p id="outMobile" style="color: red"></p>
								</div>
								<div class="form-label-group">
									<label>Indirizzo Studio</label>
									<input type="text" name="studioaddr" id="studioaddr" class="form-control" placeholder="${dettDoc.studioAddress}">
									<p id="outStudio" style="color: red"></p>
								</div>
								<div class="form-label-group">
									<label>Provincia</label>
									<input type="text" name="munaddr" id="munaddr" class="form-control" placeholder="${dettDoc.municipalityAddress}">
									<p id="outMun" style="color: red"></p>
								</div>
                    			<button class="btn btn-lg btn-primary btn-block text-uppercase" id="btn_signin" type="submit">Conferma</button>
                    		</form>
                    		</c:when>
                    		<c:otherwise>
                    		<form action="${pageContext.request.contextPath}/ModificareProfilo" method="POST" name="regForm">
								<h4>Informazioni generali</h4><br><br>
								<div class="form-label-group">
									<input type="hidden" id="inputEmail" name="email" class="form-control" value="${dettPaz.email}">
								</div>
								<div class="form-label-group">
									<label for="inputPassword">Password</label>
									<input type="password" id="psw" name="psw" class="form-control">
									<p id="outPsw" style="color: red"></p>
								</div>
								<div class="form-label-group">
									<label>Nome</label>
									<input type="text" name="name" id="name" class="form-control" placeholder="${pazLog.name}">
									<p id="outName" style="color: red"></p>
								</div>
								<div class="form-label-group">
									<label>Cognome</label>
									<input type="text" name="surname" id="surname" class="form-control" placeholder="${pazLog.surname}">
									<p id="outSurname" style="color: red"></p>
								</div>
								<div class="form-label-group">
									<label>Data di nascita</label>
									<input type="date" name="birth" class="form-control" placeholder="${pazLog.birthDate}">
								</div>
								<div class="form-label-group">
									<label>Codice fiscale</label>
									<input type="text" name="cf" id="cf" class="form-control" placeholder="${pazLog.cf}">
									<p id="outCf" style="color: red"></p>
								</div>
								<h4>Informazioni specifiche account</h4><br><br>
								<div class="form-label-group">
									<label>Residenza</label>
									<input type="text" name="residence" id="residence" class="form-control" placeholder="${dettLog.residence}">
									<p id="outRes" style="color: red"></p>
								</div>
								<div class="form-label-group">
									<label>Domicilio</label>
									<input type="text" name="domicile" id="domicile" class="form-control" placeholder="${dettLog.domicile}">
									<p id="outDom" style="color: red"></p>
								</div>
                    			<button class="btn btn-lg btn-primary btn-block text-uppercase" id="btn_signin" type="submit">Conferma</button>
                    		</form>
                    		</c:otherwise>
							</c:choose>
                	</div>
				</div>
			</div>
		</div>
	</div>
    

	<%@ include file="../generali/footer.jsp" %> 
	
	
	<script src="${pageContext.request.contextPath}/core/js/jquery/jquery-2.2.4.min.js"></script>
	<script src="${pageContext.request.contextPath}/core/vendor/bootstrap/js/popper.js"></script>
	<script src="${pageContext.request.contextPath}/core/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/core/vendor/select2/select2.min.js"></script>
    <script src="${pageContext.request.contextPath}/core/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/core/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/core/js/plugins.js"></script>
    <script src="${pageContext.request.contextPath}/core/js/active.js"></script>

</body>
</html>