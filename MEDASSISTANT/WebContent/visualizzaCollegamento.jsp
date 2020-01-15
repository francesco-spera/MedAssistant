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
<title>MedAssistant | Visualizza Collegamento</title>
<link rel="icon" href="core/img/core-img/favicon.ico">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" type="text/css" href="core/vendor/animate/animate.css">
<link rel="stylesheet" type="text/css" href="core/vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css" href="core/vendor/perfect-scrollbar/perfect-scrollbar.css">
<link rel="stylesheet" type="text/css" href="core/css/table_util.css">
<link rel="stylesheet" type="text/css" href="core/css/table_main.css">
<script type="text/javascript" src="js/ajaxsendemail.js"></script>
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

   <h6>Richiesta di collegamento</h6>

    <hr>
    
		<div class="container">
		<form method="get" action="${pageContext.request.contextPath}/RispostaCollegamento">
			  <div class="form-group">
			    <h6>Hai ricevuto una nuova richiesta di collegamento da: <%=request.getParameter("email") %></h6>
			  </div>
			  <div class="form-group">
			    <label>Vuoi accettare o rifiutare il collegamento?</label>
			  </div>
		<input type="hidden" id="response" name="response" value="" required="required">
		<button type="button" class="btnresponse btn btn-default btn-lg" data-attr="1" id="rating-star-1"> Accetta</button>
        <button type="button" class="btnresponse btn btn-default btn-lg" data-attr="2" id="rating-star-2">Rifiuta</button>
        <input type="hidden" id="email" name="email" value="<%=request.getParameter("email") %>" required="required">
		<input type="submit" class="btn btn-primary" value="Salva" >
		
		</form>
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
    <script type="text/javascript">
    
	jQuery(document).ready(function($){
	    
  		$(".btnresponse").on('click',(function(e) {
  		
  		var previous_value = $("#response").val();
  		
  		var selected_value = $(this).attr("data-attr");
  		$("#response").val(selected_value);
  		
  		$(".response").empty();
  		$(".response").html(selected_value);
  		
  		
  		
  		}));
  		
  			
  	});

    
    
    
    
    
    </script>
</body>
</html>
