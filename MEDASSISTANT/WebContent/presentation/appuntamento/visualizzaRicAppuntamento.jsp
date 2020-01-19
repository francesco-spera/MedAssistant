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
<link rel="icon" href="${pageContext.request.contextPath}/core/img/core-img/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath}/core/css/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/core/vendor/animate/animate.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/core/vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/core/vendor/perfect-scrollbar/perfect-scrollbar.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/core/css/table_util.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/core/css/table_main.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/core/js/ajaxsendemail.js"></script>
</head>
<body>
    <div id="preloader">
        <div class="medilife-load"></div>
    </div>

	<%@ include file="../generali/header.jsp" %>>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>



	<div>
	<br>
	<br>
	<br>
	
	
	
	</div>
	
	
	<c:choose>
	
		<c:when test="${docLog==null}"> Fare Accesso! </c:when>

			<c:otherwise>
				<div class="text-center">
			   <h3>Richiesta di appuntamento</h3>
				</div>
			    <hr>
			    
					<div class="container text-center">
					<form method="get" action="${pageContext.request.contextPath}/RispostaAppuntamento">
						  <div class="form-group text-center">
						    <h5>Hai ricevuto una nuova richiesta di appuntamento da: <%=request.getParameter("patient") %></h5>
						  </div>
						  <br>
						  
						  <div class="form-group text-center">
						    <label>Data: <%=request.getParameter("date")%> Ora: <%=request.getParameter("time")%></label>
						  </div>
						  
						  <br>
						  <div class="form-group text-center">
						    <label>Vuoi accettare o rinviare l'appuntamento?</label>
						  </div>
						  <br>
					<input type="hidden" id="response" name="response" value="" required="required">
					<input type="hidden" id="response" name="appId" value="<%=request.getParameter("appId") %>" required="required">
					<input type="hidden" id="response" name="date" value="<%=request.getParameter("date")%>" required="required">
					<input type="hidden" id="response" name="time" value="<%=request.getParameter("time")%>" required="required">
					<button type="submit" class="btnresponse btn btn-default btn-lg" data-attr="1" id="Accettabtn"> Accetta</button>
					<button type="submit" class="btnresponse btn btn-default btn-lg" data-attr="2" id="modificabtn"> Rinvia</button>
			        <input type="hidden" id="email" name="email" value="<%=request.getParameter("patient") %>" required="required">
					
					</form>
				  	</div>
		    </c:otherwise>
	</c:choose>
	
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	


	<%@ include file="../generali/footer.jsp" %>

	<script src="${pageContext.request.contextPath}/core/vendor/bootstrap/js/popper.js"></script>
	<script src="${pageContext.request.contextPath}/core/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/core/vendor/select2/select2.min.js"></script>
    <script src="${pageContext.request.contextPath}/core/js/jquery/jquery-2.2.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/core/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/core/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/core/js/plugins.js"></script>
    <script src="${pageContext.request.contextPath}/core/js/active.js"></script>
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
