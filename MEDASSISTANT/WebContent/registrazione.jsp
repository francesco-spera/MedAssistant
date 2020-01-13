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
<title>MedAssistant | Registrazione</title>
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
<br>
<br>
<br>

<div class="container">
          <div class="row mx-auto">
            <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
              <div class="card card-signin my-5">
                <div class="card-body">
                  <h5 class="card-title text-center"style="color:dark blue;">Crea un nuovo account</h5>	

					<input type="radio" name="gender" value="accType" onclick="document.getElementById('regPaz').style.visibility='visible'">Paziente
					<input type="radio" name="gender" value="accType" onclick="document.getElementById('regMed').style.visibility='visible'">Medico

					<div id="regPaz" style="visibility: hidden">
						<h2>REGISTRAZIONE PAZIENTE</h2>
						<form action="${pageContext.request.contextPath}/registrazione" enctype='multipart/form-data' method="POST" name="regForm" onsubmit="return valRegFormPaz(regForm)">
						   <input type="text"  class="form-control" name="email" placeholder="email">
							<input type="password"  class="form-control" name="psw" placeholder="password">
						<h3>INFORMAZIONI PERSONALI</h3>
							<input type="text"  class="form-control" name="name" placeholder="nome">
							<input type="text"  class="form-control" name="surname" placeholder="cognome">
							<input type="date"  class="form-control" name="birth" placeholder="data di nascita">
							<input type="text"  class="form-control" name="cf" placeholder="codice fiscale">
							<input type="file"  class="form-control" name="photo" placeholder="foto" accept="image/png, image/jpeg" data-multiple-caption="{count} files selected">
							<input type="text"  class="form-control" name="domicile" placeholder="domicilio">
							<input type="text"  class="form-control" name="residence" placeholder="residenza">
							<input type="submit" class="btn btn-primary btn-block" value="Submit">
						</form>
					</div>
					<br>

					<div id="regMed" style="visibility: hidden">
						<h2>REGISTRAZIONE MEDICO</h2>
						<form action="${pageContext.request.contextPath}/registrazione" enctype='multipart/form-data' method="POST" name="regForm" onsubmit="return valRegFormMed(regForm)">
							<input type="text" class="form-control" name="email" placeholder="email">
							<input type="password" class="form-control" name="psw" placeholder="password">
						<h3>INFORMAZIONI PERSONALI</h3>
							<input type="text" class="form-control" name="name" placeholder="nome">
							<input type="text" class="form-control" name="surname" placeholder="cognome">
							<input type="date" class="form-control" name="birth" placeholder="data di nascita">
							<input type="text" class="form-control" name="cf" placeholder="codice fiscale">
							<input type="text" class="form-control" name="photo" placeholder="foto">
							<input type="tel" class="form-control" name="mobilep" placeholder="mobilephone">
							<input type="text" class="form-control" name="studioaddr" placeholder="indirizzo studio">
							<input type="text" class="form-control" name="munaddr" placeholder="comune studio">
							<select name="type">
								<option value="medico di base">Medico di base</option>
								<option value="cardiologo">Cardiologo</option>
							  	<option value="dermatologo">Dermatologo</option>
							  	<option value="neurologo">Neurologo</option>
							  	<option value="podologo">Podologo</option>
							</select>
							<br><br><br><input type="submit" class="btn btn-primary btn-block" value="Submit"><br><br><br>
							
                      
							
						</form>
					</div> 
					<br>
						<p class="text-center" style="color:dark blue">Hai già un account? <a href="login.jsp" style="color:light blue;">Accedi</a> </p>
				</div>
			</div>
		</div>
	</div>
</div>


<script src="js/validatingForm.js"></script>

<br>
<br>
<br>
<br>
<br>
<br>
<br>


<%@ include file="core/header/footer.jsp" %>  
	
    <!-- jQuery (Necessary for All JavaScript Plugins) -->
    <script src="core/js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="core/js/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="core/js/bootstrap.min.js"></script>
    <!-- Plugins js -->
    <script src="core/js/plugins.js"></script>
    <!-- Active js -->
    <script src="core/js/active.js"></script>
    
    
    
</body>
</html>




