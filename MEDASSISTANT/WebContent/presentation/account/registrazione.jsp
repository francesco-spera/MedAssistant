<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MED ASSISTANT registration</title>
</head>
<body>

<input type="radio" name="gender" value="accType" onclick="document.getElementById('regPaz').style.visibility='visible'">Paziente
<input type="radio" name="gender" value="accType" onclick="document.getElementById('regMed').style.visibility='visible'">Medico

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

<div id="regMed" style="visibility: hidden">
	<h2>REGISTRAZIONE MEDICO</h2>
	<form action="../../registrazione" method="POST" name="regForm" onsubmit="return valRegFormMed(regForm)">
		<input type="text" name="email" placeholder="email"><br>
		<input type="password" name="psw" placeholder="password"><br>
	<h3>PERSONAL INFORMATION</h3>
		<input type="text" name="name" placeholder="nome"><br>
		<input type="text" name="surname" placeholder="cognome"><br>
		<input type="date" name="birth" placeholder="data di nascita"><br>
		<input type="text" name="cf" placeholder="codice fiscale"><br>
		<input type="text" name="photo" placeholder="foto"><br>
		<input type="tel" name="mobilep" placeholder="mobilephone"><br>
		<input type="tel" name="studioaddr" placeholder="indirizzo studio"><br>
		<select name="type">
		  <option value="cardiologo">Cardiologo</option>
		  <option value="dermatologo">Dermatologo</option>
		  <option value="neurologo">Neurologo</option>
		  <option value="podologo">Podologo</option>
		</select>
		<input type="submit" value="Submit">
	</form>
</div>


<script src="js/validatingForm.js"></script>

</body>
</html>