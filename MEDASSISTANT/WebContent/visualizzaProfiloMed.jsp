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
<title>MedAssistant | Profilo Medico</title>
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
	
	<div class="container mt-5">
	    <h1>Profilo del dott. <c:out value="${accDoc.surname}"/></h1>
	    <form method="post" action="${pageContext.request.contextPath}/RichiedereCollegamento">
		<input type="hidden" name="emaildoc" value="${accDoc.doctor}">
		<button type="submit" class="btn btn-primary">Richiedi Collegamento</button>					<!-- spostarlo in alto a destra -->						
		</form>
	  	<hr>
	  	
		<div class="row">
	      <div class="col align-self-center personal-info mb-5">
	        <h3>Informazioni</h3>
	          <div class="form-group">
	            <label class="col-lg-3 control-label">Nome</label>
	            <div class="col-lg-8">
	              <input class="form-control" type="text" value="${accDoctor.name}" readonly>
	            </div>
	          </div>
	            <div class="form-group">
	            <label class="col-lg-3 control-label">Numero di telefono</label>
	            <div class="col-lg-8">
	              <input class="form-control" type="text" value="${infoDoc.phoneNumber}" readonly>
	            </div>
	          </div>
	          <div class="form-group">
	            <label class="col-lg-3 control-label">Indirizzo Studio</label>
	            <div class="col-lg-8">
	              <input class="form-control" type="text" value="${infoDoc.studioAddress}" readonly>
	            </div>
	          </div>
	          <div class="form-group">
	            <label class="col-lg-3 control-label">Provincia</label>
	            <div class="col-lg-8">
	              <input class="form-control" type="text" value="${infoDoc.municipalityAddress}" readonly>
	            </div>
	          </div>
	          <div class="form-group">
	          	<label class="col-lg-3 control-label">Specializzazione</label>
	            <div class="col-lg-8">
	              <input class="form-control" type="text" value="${infoDoc.type}" readonly>
	          </div>
	          </div>
	          <div class="form-group">
	            <label class="col-lg-3 control-label">Ratings</label>
	          <div class="col-lg-8">
	            <input class="form-control" type="text"  value="${infoDoc.avgReviews}" readonly>
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