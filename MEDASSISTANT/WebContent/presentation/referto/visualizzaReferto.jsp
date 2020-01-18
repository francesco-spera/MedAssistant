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
	
	<%@ include file="../generali/header.jsp" %> 

	<div>
	<br>
	<br>
	<br>
	</div>
	
	<div class="container mt-5">
		<div class="row">
	      <div class="col align-self-center personal-info mb-5">


	      <br><br>  
	        <h3>Informazioni</h3>
	        <hr>
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
	  
	  <div class="row">
	      <div class="col align-self-center personal-info mb-5">
	      
	      <div class="row">
			    <div class="form-group">
		           <div class="col-lg-12">
		          		<h3>Lista ricette</h3>
		           </div>
		         </div>
		         <div class="form-group">
		           <div class="col-lg-9">
					<c:choose>
		      		<c:when test="${pazLog!=null}">
			      		<a type="submit" class="btn btn-primary" onclick="ajaxCall('load','<%=request.getContextPath()%>/richiedereRicetta', displayResults(),'${medRep.doctor}','Richiesta Ricetta','Salve Dottor,\nL\'utente, email: \n\nha richiesto l\'invio di una ricetta: http://localhost:8080/MEDASSISTANT/visualizzaRicRicetta.jsp?email=',6000)">Richiedi ricetta</a>
			      	</c:when>
		      		</c:choose>
		           </div>
		         </div>
		         <div class="form-group">
		           <div class="col-lg-9">
		           <c:choose>
		           <c:when test="${tipoDoc!='medico di base' && tipoDoc!=null}">
			      		<a type="submit" class="btn btn-primary" href="${pageContext.request.contextPath}/presentation/ricetta/caricaRicetta.jsp?reportid=${medRep.idReport}&email=${medRep.patient}&response=0">Carica ricetta</a>
			      	</c:when>
			      </c:choose>
		           </div>
		         </div>
		    </div>
		<hr>
	  <table>
		<thead>
			<tr class="table100-head" style="background-color: #081f3e">
				<th class="column1">Data ricetta</th>
				<th class="column1"></th>
			</tr>
		</thead>
		<c:choose>
			<c:when test="${empty Pres}">
			<td colspan="2">NESSUNA RICETTA RICHIESTA</td>
			</c:when>
			<c:otherwise>
			<c:forEach items="${Pres}" var="presc">
			<c:choose>
			<c:when test="${presc.state==-1}">
			<tr>
			<td>${presc.date}</td>
			<td><form target="_blank" action="${pageContext.request.contextPath}/presentation/ricetta/GetPdf.jsp" method="GET">
				<input type="hidden" name="id" value="${presc.ID}">
				<button type="submit" class="btn btn-primary">Visualizza ricetta</button>											
				</form></td>
			</tr>
			</c:when>
			</c:choose>
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
    <script>
    function displayResults(listXML, id) {
		try {
			var obj = document.getElementById(id);
			if(obj != null) {
				var rdfs = listXML.getElementsByTagName("result")[0].firstChild.nodeValue;
				obj.innerHTML =rdfs;
				console.log("Handle results");
			}
		} catch(e1) {
		}

	}
    </script>

</body>
</html>