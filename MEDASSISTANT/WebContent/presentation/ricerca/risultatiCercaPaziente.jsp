<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>MedAssistant | Ricerca</title>
<link rel="icon" href="${pageContext.request.contextPath}/core/img/core-img/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath}/core/css/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/core/vendor/animate/animate.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/core/vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/core/vendor/perfect-scrollbar/perfect-scrollbar.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/core/css/table_util.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/core/css/table_main.css">	
</head>
<body>
    
    	<% if(request.getSession().getAttribute("docLog")==null){
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	%>
    
    <div id="preloader">
        <div class="medilife-load"></div>
    </div>
	
	<%@ include file="../generali/header.jsp" %>

	<br>
	<br>
	<br>
	<br>
	<br>
	
    <div class="container-table100">
		<div class="wrap-table100">
			<div class="table100">
				<table >
					<c:choose>
						<c:when test="${empty accPaz}">
						<br><br><br><br>
							<h1>Nessun paziente trovato.</h1>
						<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
						</c:when>
						<c:otherwise>
							<c:forEach items="${accPaz}" var="info">
								<thead>
									<tr class="table100-head" style="background-color: #081f3e">
										<th class="column1">Nome</th>
										<th class="column2">Cognome</th>
										<th class="column3">Data di nascita</th>
										<th class="column4">Foto</th>
										<th class="column5"></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="column1">${info.name}</td>  
										<td class="column2">${info.surname}</td>
										<td class="column3">${info.birthDate}</td>
										<td class="column4"><img src="GetProfileImage.jsp?patient=${info.patient}" width="230px" height="140px" class="img-responsive" style="width:250px"></td>
										<td><form method="post" action="${pageContext.request.contextPath}/VisualizzaProfiloPaziente">
										<input type="hidden" name="emailpaz" value="${info.patient}">
										<button type="submit" class="btn btn-primary">Visualizza Profilo</button>											
										</form></td>
									</tr>
								</tbody>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</table>
			</div>
		</div>
	</div>
    
    <br><br><br><br><br><br><br><br><br><br><br><br>

	<%@ include file="../generali/footer.jsp" %>  
	
    <script src="${pageContext.request.contextPath}/core/js/jquery/jquery-2.2.4.min.js"></script>
	<script src="${pageContext.request.contextPath}/core/vendor/bootstrap/js/popper.js"></script>
	<script src="${pageContext.request.contextPath}/core/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/core/vendor/select2/select2.min.js"></script>
	<script src="${pageContext.request.contextPath}/core/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/core/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/core/js/plugins.js"></script>
    <script src="${pageContext.request.contextPath}/core/js/active.js"></script>

</body>
</html>