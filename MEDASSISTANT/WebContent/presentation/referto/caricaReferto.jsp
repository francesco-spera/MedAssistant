<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<title>MedAssistant | Carica referto</title>
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

	<div>
	<br>
	<br>
	<br>
	<br>
	<br>
	</div>
	
	<div class="container" style="margin-bottom: 16px;">
		<div class="row mx-auto">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<h2>Carica referto</h2>
				<div class="card card-signin my-5">
					<div class="card-body">
						<h5 class="card-title text-center">Compila i campi</h5><hr>
                    		<form action="${pageContext.request.contextPath}/caricareReferto" method="POST">
								<h4>Informazioni generali</h4><br><br>
								<div class="form-label-group">
									<label>Paziente</label>
									<input class="form-control" type="text" value="${accPaz.patient}" name="patient" readonly>
								</div>
								<div class="form-label-group">
									<label>Data</label>
									<%	Date date = new Date();
										SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
									%>
									<input class="form-control" type="text" name="date" value="<%=timeFormat.format(date)%>" readonly>
								</div>
								<div class="form-label-group">
									<label>Oggetto</label>
									<input type="text" name="object" class="form-control">
								</div>
								<div class="form-label-group">
									<label>Descrizione</label>
									<input type="text" name="description" class="form-control">
								</div>
								<div class="form-label-group">
									<label>Firma</label>
									<input class="form-control" type="text" value="${docLog.doctor}" name="doctor" readonly>
								</div>
                    			<button class="btn btn-lg btn-primary btn-block text-uppercase" id="btn_signin" type="submit">Conferma</button>
                    		</form>
                	</div>
				</div>
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