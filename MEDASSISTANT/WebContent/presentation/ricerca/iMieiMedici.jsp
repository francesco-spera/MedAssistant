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
<title>MedAssistant</title>
<link rel="icon" href="${pageContext.request.contextPath}/core/img/core-img/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath}/core/css/style.css">
</head>
<body>

	<% if(request.getSession().getAttribute("pazLog")==null){
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	%>

    <div id="preloader">
        <div class="medilife-load"></div>
    </div>

   <%@ include file="../generali/header.jsp" %>  
    
    <section class="breadcumb-area bg-img gradient-background-overlay" style="background-image: url(core/img/bg-img/breadcumb2.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="breadcumb-content">
                        <h3 class="breadcumb-title" style="margin-left:350px">I miei medici</h3>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
	<section class="elements-area section-padding-100-0">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="accordions mb-100" id="accordion" role="tablist" aria-multiselectable="true">
						<div class="elements-title">
							<h2>Cerca il tuo medico</h2>
                    	</div>
						<div class="s009">
							<form action="${pageContext.request.contextPath}/CercareMedicoNome" method="get" name="search">
        						<div class="inner-form">
          							<div class="basic-search">
            							<div class="input-field">
              								<input name="name" type="text" placeholder="Nome">
  			 								<input name="surname" type="text" placeholder="Cognome">
            							</div>
            						</div>
  									<div class="input-field">
                						<div class="group-btn">
                  							<input type="submit" class="btn-search" value="CERCA">
                						</div>
             						</div>
          						</div>
         					</form>
          					<br>
          				</div>
          				
          				<br>
          				<br>

						<div class="elements-title">
							<h2>I miei medici</h2>
                    	</div>
                    	<c:choose>
	                    	<c:when test="${allDoc==null}">
	                    		<h2>NESSUN MEDICO COLLEGATO</h2>
	                    	</c:when>
	                    	<c:otherwise>
	                    		<c:forEach items="${allDoc}" var="doc">
	                    		
	                        	<div class="panel single-accordion">
									 <h6><a role="button" class="" aria-expanded="true" aria-controls="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
									 <c:out value="${doc.surname}"/> <c:out value="${doc.name}"/>
									<span class="accor-open"><i class="fa fa-plus" aria-hidden="true"></i></span>
	                                <span class="accor-close"><i class="fa fa-minus" aria-hidden="true"></i></span>
	                                </a></h6>
	                            </div>
	                            
	                              <div id="collapseOne" class="accordion-content collapse show">
									<form method="post" action="${pageContext.request.contextPath}/VisualizzaProfiloMedico">
										<input type="hidden" name="emaildoc" value="${doc.doctor}">
										<button type="submit" class="btn btn-primary">Visualizza Profilo</button>									
									</form>
									
	                        	</div>
	                        
	                        	
	                        	
	                        </c:forEach>                   
	                    	</c:otherwise>
	                    </c:choose>
					</div>
				</div>
			</div>
		</div>    
	</section>

    <%@ include file="../generali/footer.jsp" %> 
    
    
	<script>
		$(document).ready(function(){
			$("#myInput").on("keyup", function() {
				var value = $(this).val().toLowerCase();
				$("#myTable tr").filter(function() {
					$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
				});
			});
		});
	</script>


	<script>
		var acc = document.getElementsByClassName("panel single-accordion");
		var i;

		for (i = 0; i < acc.length; i++) {
  		acc[i].addEventListener("click", function() {
    	this.classList.toggle("active");
    	var panel = this.nextElementSibling;
    	if (panel.style.display === "block") {
      	panel.style.display = "none";
    	} else {
    	 panel.style.display = "block";
   		 }
 		 });
		}
	</script>
		
		
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