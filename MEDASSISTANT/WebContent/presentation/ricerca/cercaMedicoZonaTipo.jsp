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
<title>MedAssistant | Cerca</title>
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

	<section class="hero-area">
		<div class="s009">
			<form action="${pageContext.request.contextPath}/CercareMedicoZonaTipo" method="get" name="search">
				<div class="inner-form">
					<div class="advance-search">
						<span class="desc">RICERCA MEDICO PER SPECIALIZZAZIONE E PER ZONA</span>
						<div class="row">
							<div class="input-field">
								<div class="input-select">
									<select data-trigger="" name="tipo" class="selection" id="tipo">
										<option value="">Tipologia</option>
										<option value="medico di base">Medico di base</option>
										<option value="medico specialista">Medico Specialista</option>
									</select>
								</div>
							</div>
							<div class="input-field">
								<div class="input-select">
									<select data-trigger="" name="zona" class="selection" id="zona">
										<option value="">Zona</option>
										<option value="na">Napoli</option>
										<option value="ce">Caserta</option>
										<option value="sa">Salerno</option>
									</select>
								</div>
              				</div>
            				<div class="row third">
								<div class="input-field">
                					<div class="group-btn">
										<input type="submit" class="btn-search" value="CERCA">
									</div>
								</div>
							</div>
						</div>
					</div>
        		</div>
      		</form>
		</div>
    </section>

	<div class="container">
            <div class="row"></div>
    </div>

	<%@ include file="../generali/footer.jsp" %>   
	
	<script src="../../core/js/extention/choices.js"></script>
    <script>
      const customSelects = document.querySelectorAll("select");
      const deleteBtn = document.getElementById('delete')
      const choices = new Choices('select',
      {
        searchEnabled: false,
        itemSelectText: '',
        removeItemButton: true,
      });
      deleteBtn.addEventListener("click", function(e)
      {
        e.preventDefault()
        const deleteAll = document.querySelectorAll('.choices__button')
        for (let i = 0; i < deleteAll.length; i++)
        {
          deleteAll[i].click();
        }
      });
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