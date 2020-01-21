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
<link rel="icon" href="${pageContext.request.contextPath}/core/img/core-img/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath}/core/css/style.css">
<script src="${pageContext.request.contextPath}/core/js/jquery/jquery-2.2.4.min.js"></script>
</head>
<body>

    <div id="preloader">
        <div class="medilife-load"></div>
    </div>
	
	<%@ include file="../generali/header.jsp" %> 

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
                <div class="card-body" >
                  <h3 class="card-title text-center"style="color:dark blue">Crea un nuovo account</h3>	
                  <hr>
                  <br>       
               
                  <div class="container">
	                  <div class="row">   
	                    <div class="col-1">
	                  	</div>  
	                  	<div class="col-md-3">
	                  	     <label>Paziente</label> 
	                  	</div>  
	                  	<div class="col-md-3">   
			                  <label class="switch">
						      <input  type="checkbox"  onclick="SwapDivsWithClick(regPaz,regMed)">
						        <span class="slider round"  ></span>
						     </label>
						</div>
						<div class="col-md-3">   
	                  	     <label>Medico</label> 
	                  	</div>  
				     </div>
			     </div>
			    <br><br>
			    
					<div id="regPaz">
						<h4>Registrazione paziente</h4>
						<form method="POST" name="regForm" id="regFormP1" onsubmit="return canRegister()">
						   	<input type="text" id="email" class="form-control" name="email" placeholder="Email">
						   	<p id="outEmail" style="color: red"></p>
							<input type="submit" class="btn btn-primary btn-block" id="buttRegister" value="Controlla email">
						</form>
						<form action="${pageContext.request.contextPath}/registrazione" enctype='multipart/form-data' method="POST" id="regFormP2" style="display:none">
						<h4>Informazioni personali</h4>
							<input type="password"  class="form-control" name="psw" id="psw" placeholder="Password">
							<p id="outPsw" style="color: red"></p>
							<input type="text"  class="form-control" name="name" id="name" placeholder="Nome">
							<p id="outName" style="color: red"></p>
							<input type="text"  class="form-control" name="surname" id="surname" placeholder="Cognome">
							<p id="outSurname" style="color: red"></p>
							<input type="date"  class="form-control" name="birth" id="birth" placeholder="Data di nascita">
							<input type="text"  class="form-control" name="cf" id="cf" placeholder="Codice fiscale">
							<p id="outCf" style="color: red"></p>
							<input id="img" type="file" class="form-control" name="photo" placeholder="Foto" accept="image/png, image/jpeg" data-multiple-caption="{count} files selected">
							<input type="text"  class="form-control" name="domicile" id="domicile" placeholder="Domicilio">
							<p id="outDom" style="color: red"></p>
							<input type="text"  class="form-control" name="residence" id="residence" placeholder="Residenza">
							<p id="outRes" style="color: red"></p>
							<button class="btn btn-lg btn-primary btn-block" type="submit" id="buttRegister2">Crea account</button>
						</form>
					</div>
														
					<div id="regMed" style="display:none">
						<h4>Registrazione medico</h4>
						<form method="POST" name="regFormM" id="regFormM" onsubmit="return canRegisterM()">
							<input type="text" id="emailM" class="form-control" name="email" placeholder="Email">
							<p id="outEmailM" style="color: red"></p>
							<button class="btn btn-lg btn-primary btn-block" type="submit" id="buttRegisterM">Controlla email</button>
						</form>
						<form action="${pageContext.request.contextPath}/registrazione" enctype='multipart/form-data' method="POST" id="regFormM2" style="display:none">
							<input type="password" class="form-control" name="psw" id="pswM" placeholder="Password">
							<p id="outPswM" style="color: red"></p>
							<input type="text" class="form-control" name="name" id="nameM" placeholder="Nome">
							<p id="outNameM" style="color: red"></p>
							<input type="text" class="form-control" name="surname" id="surnameM" placeholder="Cognome">
							<p id="outSurnameM" style="color: red"></p>
							<input type="date" class="form-control" name="birth" id="birthM" placeholder="Data di nascita">
							<input type="text" class="form-control" name="cf" id="cfM" placeholder="Codice fiscale">
							<p id="outCfM" style="color: red"></p>
							<input id="img" type="file" class="form-control" name="photo" placeholder="Foto" accept="image/png, image/jpeg" data-multiple-caption="{count} files selected">
							<input type="tel" class="form-control" name="mobilep" id="mobilep" placeholder="Numero di telefono">
							<p id="outMobile" style="color: red"></p>
							<input type="text" class="form-control" name="studioaddr" id="studioaddr" placeholder="Indirizzo studio">
							<p id="outStudio" style="color: red"></p>
							<input type="text" class="form-control" name="munaddr" id="munaddr" placeholder="Comune studio">
							<p id="outMun" style="color: red"></p>
							<select name="type" id="type">
								<option value="medico di base">Medico di base</option>
								<option value="cardiologo">Cardiologo</option>
							  	<option value="dermatologo">Dermatologo</option>
							  	<option value="neurologo">Neurologo</option>
							  	<option value="podologo">Podologo</option>
							</select>
							<br><br><br><input type="submit" class="btn btn-primary btn-block" id="buttRegister2M" value="Crea account"><br><br><br>
						</form>
					</div> 
					<br>
						<p class="text-center" style="color:#081f3e">Hai già un account? <a  href="login.jsp" style="color:#68b3fd">Accedi</a></p>
				</div>
			</div>
		</div>
	</div>
</div>

<br>
<br>
<br>
<br>
<br>
<br>
<br>

	<%@ include file="../generali/footer.jsp" %> 
	<script src="../../core/js/validatingForm.js"></script>
	
	<script type="text/javascript">
		function SwapDivsWithClick(div1,div2)
		{
		   d1 = document.getElementById("regPaz");
		   d2 = document.getElementById("regMed");
		   if( d2.style.display == "none" )
		   {
		      d1.style.display = "none";
		      d2.style.display = "block";
		   }
		   else
		   {
		      d1.style.display = "block";
		      d2.style.display = "none";
		   }
		}
	</script>

	
  	<script src="${pageContext.request.contextPath}/core/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/core/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/core/js/plugins.js"></script>
    <script src="${pageContext.request.contextPath}/core/js/active.js"></script>
    
</body>
</html>
