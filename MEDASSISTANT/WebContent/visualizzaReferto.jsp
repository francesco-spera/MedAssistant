<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core"%>

<% 
if(request.getAttribute("Pres")==null && request.getAttribute("read")!="true"){
			request.getRequestDispatcher("/verificaRicetta").forward(request, response);
		}
request.removeAttribute("read");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>MedAssistant | Referto</title>
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
		<div class="row">
	      <div class="col align-self-center personal-info mb-5">
	      <c:choose>
	      	<c:when test="${Pres==null}">
	      		<c:choose>
	      		<c:when test="${pazLog!=null}">
		      		<a type="submit" class="btn btn-primary" target="_blank" href="${pageContext.request.contextPath}/#">Richiedi ricetta</a>
		      	</c:when>
	      		<c:when test="${tipoDoc!='medico di base' && tipoDoc!=null}">
		      		<a type="submit" class="btn btn-primary" href="${pageContext.request.contextPath}/#">Carica ricetta</a>
		      	</c:when>
	      		</c:choose>
	      	</c:when>
	      	<c:when test="${Pres!=null}">
	      		<a type="submit" class="btn btn-primary" target="_blank" href="${pageContext.request.contextPath}/GetPdf.jsp?id=${Pres.ID}">Visualizza ricetta</a>
	      	</c:when>
	      </c:choose>
	      <br><br>  
	        <h3>Informazioni</h3>
	          <div class="form-group">
	            <label class="col-lg-3 control-label">Oggetto</label>
	            <div class="col-lg-8">
	              <input class="form-control" type="text" value="${medRep.object}" readonly>
	            </div>
	          </div>
	            <div class="form-group">
	            <label class="col-lg-3 control-label">Descrizione</label>
	            <div class="col-lg-8">
	              <input class="form-control" type="text" value="${medRep.description}" readonly>
	            </div>
	          </div>
	          <div class="form-group">
	            <label class="col-lg-3 control-label">Prescritta da</label>
	            <div class="col-lg-8">
	              <input class="form-control" type="text" value="${nameDoc.name} ${nameDoc.surname}" readonly>
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