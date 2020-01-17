<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>MedAssistant | Appuntamenti</title>
<link rel="icon" href="core/img/core-img/favicon.ico">
<link rel="stylesheet" href="style.css">
</head>
<body>

<a href="presentation/appuntamento/appuntamento.jsp">appuntamento</a>

<div id="regPaz" style="visibility: hidden">
	<h2>REGISTRAZIONE PAZIENTE</h2>
	<form action="../../registrazione" method="POST" name="regForm" onsubmit="return valRegFormPaz(regForm)">
		<input type="text" name="email" placeholder="email"><br>
		<input type="password" name="psw" placeholder="password"><br>
	<h3>PERSONAL INFORMATION</h3>
		<input type="text" name="name" placeholder="nome"><br>
		<input type="text" name="surname" placeholder="cognome"><br>
		<input type="date" name="birth" placeholder="data di nascita"><br>
		<input type="text" name="cf" placeholder="codice fiscale"><br>
		<input type="text" name="photo" placeholder="foto"><br>
		<input type="text" name="domicile" placeholder="domicilio"><br>
		<input type="text" name="residence" placeholder="residenza"><br>
		<input type="submit" value="Submit">
	</form>
</div>

<c:choose>
  <c:when test="${appuntamento!=null}">
    <p>WELCOME <c:out value="${paziente.name}"/> <c:out value="${paziente.surname}"/></p>
    <input type="radio" name="gender" value="accType" onclick="document.getElementById('regPaz').style.visibility='visible'">Modifica Appuntamento
	<input type="radio" name="gender" value="accType" onclick="document.getElementById('regPaz').style.visibility='visible'">Cancella Appuntamento
  </c:when>
  <c:when test="${appuntamento==null}">
    <p>WELCOME <c:out value="${medico.name}"/> <c:out value="${medico.surname}"/></p>
    <input type="radio" name="gender" value="accType" onclick="document.getElementById('regPaz').style.visibility='visible'">Crea Appuntamento
  </c:when>
</c:choose>


<c:choose>
  <c:when test="${paziente!=null}">
    <p>WELCOME <c:out value="${paziente.name}"/> <c:out value="${paziente.surname}"/></p>
  </c:when>
  <c:when test="${medico!=null}">
    <p>WELCOME <c:out value="${medico.name}"/> <c:out value="${medico.surname}"/></p>
  </c:when>
</c:choose>

</body>
</html>