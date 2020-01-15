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
                <div class="card-body" >
                  <h3 class="card-title text-center"style="color:dark blue;">Crea un nuovo account</h3>	
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
					
				
					<div id="regPaz" >
						<h4>Registrazione paziente</h4>
						<form action="${pageContext.request.contextPath}/registrazione" enctype='multipart/form-data' method="POST" name="regForm" onsubmit="return valRegFormPaz(regForm)">
						   <input type="text"  class="form-control" name="email" placeholder="email">
							<input type="password"  class="form-control" name="psw" placeholder="password">
						<h4>Informazioni personali</h4>
							<input type="text"  class="form-control" name="name" placeholder="nome">
							<input type="text"  class="form-control" name="surname" placeholder="cognome">
							<input type="date"  class="form-control" name="birth" placeholder="data di nascita">
							<input type="text"  class="form-control" name="cf" placeholder="codice fiscale">
							<input id="img" type="file"  class="form-control" name="photo" placeholder="foto" accept="image/png, image/jpeg" data-multiple-caption="{count} files selected">
							<input type="text"  class="form-control" name="domicile" placeholder="domicilio">
							<input type="text"  class="form-control" name="residence" placeholder="residenza">
							<input type="submit" class="btn btn-primary btn-block" value="Submit">
						</form>
					</div>
														
					<div id="regMed" style="display:none;">
						<h4>Registrazione medico</h4>
						<form action="${pageContext.request.contextPath}/registrazione" enctype='multipart/form-data' method="POST" name="regForm" onsubmit="return valRegFormMed(regForm)">
							<input type="text" class="form-control" name="email" placeholder="email">
							<input type="password" class="form-control" name="psw" placeholder="password">
						<h4>Informazioni personali</h4>
							<input type="text" class="form-control" name="name" placeholder="nome">
							<input type="text" class="form-control" name="surname" placeholder="cognome">
							<input type="date" class="form-control" name="birth" placeholder="data di nascita">
							<input type="text" class="form-control" name="cf" placeholder="codice fiscale">
							<input id="img" type="file"  class="form-control" name="photo" placeholder="foto" accept="image/png, image/jpeg" data-multiple-caption="{count} files selected">
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
						<p class="text-center" style="color:#081f3e">Hai già un account? <a  href="login.jsp" style="color:#68b3fd; " >Accedi</a> </p>
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




