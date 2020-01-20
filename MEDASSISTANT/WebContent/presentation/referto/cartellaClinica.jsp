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
<title>MedAssistant | Cartella clinica</title>
<link rel="icon" href="${pageContext.request.contextPath}/core/img/core-img/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath}/core/css/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/core/vendor/animate/animate.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/core/vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/core/vendor/perfect-scrollbar/perfect-scrollbar.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/core/css/table_util.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/core/css/table_main.css">	
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
	
    <div class="container-table100">
		<div class="wrap-table100">
			<div class="table100">
			
			<div class="row">
			    <div class="form-group">
		           <div class="col-lg-12">
		           <h2>Referti</h2>
		           </div>
		         </div>
		         <div class="form-group">
		           <div class="col-lg-9">
								<c:choose>
						   		 <c:when test="${docLog!=null}">
								<a type="submit" class="btn btn-primary" href="${pageContext.request.contextPath}/presentation/referto/caricaReferto.jsp">Carica Referto</a>
								</c:when>
								</c:choose>
		           </div>
		         </div>
		    </div>
	
			<hr>
			<br>											
				<table>
					<c:choose>
						<c:when test="${empty medReps}">
						  <br><br><br><br>
							<h1>Nessun referto trovato.</h1>
						 <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
						</c:when>
						<c:otherwise>
								<thead>
									<tr class="table100-head" style="background-color: #081f3e">
										<th class="column1">Oggetto</th>
										<th class="column2">Data</th>
										<th class="column5"></th>
									</tr>
								</thead>
							<c:forEach items="${medReps}" var="rep">
								<tbody>
									<tr>
										<td class="column1">${rep.object}</td>  
										<td class="column2">${rep.date}</td>
										<td><form action="${pageContext.request.contextPath}/VisualizzaReferto" method="GET">
										<input type="hidden" name="idReport" value="${rep.idReport}">
										<button type="submit" class="btn btn-primary">Visualizza Referto</button>											
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