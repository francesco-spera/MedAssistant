<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>MedAssistant - Health &amp; Medical Template | Home</title>

    <!-- Favicon  -->
    <link rel="icon" href="core/img/core-img/favicon.ico">

    <!-- Style CSS -->
    <link rel="stylesheet" href="style.css">

</head>
<body>

<!-- Preloader -->
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
<br>
<br>

<h2>PROFILO PERSONALE</h2>


<c:choose>
  <c:when test="${paziente!=null}">
    <p>WELCOME <c:out value="${paziente.name}"/> <c:out value="${paziente.surname}"/></p>
    <br>
    <c:out value="${paziente.cf}"/> 
    <br>
    <c:out value="${paziente.birthDate}"/>
    <br>
    
    
	<a href="">Modifica Profilo</a>
	<br>
	
	<a href="logout">logout</a>
	
	
  </c:when>
  <c:when test="${medico!=null}">
    <p>WELCOME <c:out value="${medico.name}"/> <c:out value="${medico.surname}"/></p>
  </c:when>
</c:choose>

<script src="js/validatingForm.js"></script>

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