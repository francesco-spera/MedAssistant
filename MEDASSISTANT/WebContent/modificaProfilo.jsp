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
<link rel="icon" href="core/img/core-img/favicon.ico">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" type="text/css" href="core/vendor/animate/animate.css">
<link rel="stylesheet" type="text/css" href="core/vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css" href="core/vendor/perfect-scrollbar/perfect-scrollbar.css">
<link rel="stylesheet" type="text/css" href="core/css/table_util.css">
<link rel="stylesheet" type="text/css" href="core/css/table_main.css">
</head>
<body>
    <div id="preloader">
        <div class="medilife-load"></div>
    </div>
	
	<%@ include file="core/header/header.jsp" %>  

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
	    					<c:when test="${accDoc!=null}">
							<form action="${pageContext.request.contextPath}/ModificareProfilo" enctype='multipart/form-data' method="POST" name="regForm" onsubmit="return valRegFormPaz(regForm)">
								<h4>Informazioni generali</h4> <br><br>
								<div class="form-label-group">
									<label for="inputEmail">Email</label>
									<input type="email" id="inputEmail" name="email" class="form-control" placeholder="${infoDoc.email}">
								</div>								
								<div class="form-label-group">
									<label for="inputPassword">Password</label>
									<input type="password" id="inputPassword" name="psw" class="form-control" placeholder="${infoDoc.password}">
								</div>
								<div class="form-label-group">
									<label>Nome</label>
									<input type="text" name="name" class="form-control" placeholder="${accDoc.name}">
								</div>
								<div class="form-label-group">
									<label>Cognome</label>
									<input type="text" name="surname" class="form-control" placeholder="${accDoc.surname}">
								</div>
								<div class="form-label-group">
									<label>Data di nascita</label>
									<input type="date" name="birth" class="form-control" placeholder="${accDoc.birthDate}">
								</div>
								<div class="form-label-group">
									<label>Codice fiscale</label>
									<input type="text" name="cf" class="form-control" placeholder="${accDoc.cf}">
								</div>
								<div class="form-label-group">
									<label>Foto</label>
									<input type="file" name="photo" class="form-control" placeholder="${accDoc.photo}" accept="image/png, image/jpeg" data-multiple-caption="{count} files selected">
								</div>
								<h3>Informazioni specifiche account</h3> <br><br>
								<div class="form-label-group">
									<label>Numero di telefono</label>
									<input type="number" name="mobilep" class="form-control" placeholder="${infoDoc.phoneNumber}">
								</div>
								<div class="form-label-group">
									<label>Indirizzo Studio</label>
									<input type="text" name="studioaddr" class="form-control" placeholder="${infoDoc.studioAddress}">
								</div>
								<div class="form-label-group">
									<label>Provincia</label>
									<input type="text" name="munaddr" class="form-control" placeholder="${infoDoc.municipalityAddress}">
								</div>
								<div class="form-label-group">
									<label>Specializzazione</label>
									<input type="text" name="type" class="form-control" placeholder="${infoDoc.type}">
								</div>
                    			<button class="btn btn-lg btn-primary btn-block text-uppercase" id="btn_signin" type="submit">Conferma</button>
                    		</form>
                    		</c:when>
                    		<c:otherwise>
                    		<form action="${pageContext.request.contextPath}/ModificareProfilo" enctype='multipart/form-data' method="POST" name="regForm" onsubmit="return valRegFormPaz(regForm)">
								<h4>Informazioni generali</h4><br><br>
								<div class="form-label-group">
									<label for="inputEmail">Email</label>
									<input type="email" id="inputEmail" name="email" class="form-control" placeholder="${infoPaz.email}">
								</div>
								<div class="form-label-group">
									<label for="inputPassword">Password</label>
									<input type="password" id="inputPassword" name="psw" class="form-control" placeholder="${infoPaz.password}">
								</div>
								<div class="form-label-group">
									<label>Nome</label>
									<input type="text" name="name" class="form-control" placeholder="${accPaz.name}">
								</div>
								<div class="form-label-group">
									<label>Cognome</label>
									<input type="text" name="surname" class="form-control" placeholder="${accPaz.surname}">
								</div>
								<div class="form-label-group">
									<label>Data di nascita</label>
									<input type="date" name="birth" class="form-control" placeholder="${accPaz.birthDate}">
								</div>
								<div class="form-label-group">
									<label>Codice fiscale</label>
									<input type="text" name="cf" class="form-control" placeholder="${accPaz.cf}">
								</div>
								<div class="form-label-group">
									<label>Foto</label>
									<input type="file" name="photo" class="form-control" placeholder="${accPaz.photo}" accept="image/png, image/jpeg" data-multiple-caption="{count} files selected">
								</div>
								<h4>Informazioni specifiche account</h4><br><br>
								<div class="form-label-group">
									<label>Residenza</label>
									<input type="text" name="residence" class="form-control" placeholder="${infoPaz.residence}">
								</div>
								<div class="form-label-group">
									<label>Domicilio</label>
									<input type="text" name="domicile" class="form-control" placeholder="${accPaz.domicile}">
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
    

	<%@ include file="core/header/footer.jsp" %> 
	
	<script src="core/vendor/bootstrap/js/popper.js"></script>
	<script src="core/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="core/vendor/select2/select2.min.js"></script>
    <script src="core/js/jquery/jquery-2.2.4.min.js"></script>
    <script src="core/js/popper.min.js"></script>
    <script src="core/js/bootstrap.min.js"></script>
    <script src="core/js/plugins.js"></script>
    <script src="core/js/active.js"></script>

</body>
</html>