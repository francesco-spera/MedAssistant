<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>

<header class="header-area">
<div class="main-header-area" id="stickyHeader">
	<div class="container h-100">
		<div class="row h-100 align-items-center">
			<div class="col-12 h-100">
				<div class="main-menu h-100">
					<nav class="navbar h-100 navbar-expand-lg">
						<a class="navbar-brand" href="index.jsp"><img src="core/img/core-img/medassistantlogo.png" alt="Logo" class="img-responsive" style="width:250px;"></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#medilifeMenu" aria-controls="medilifeMenu" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
						<div class="collapse navbar-collapse" id="medilifeMenu">
							<c:choose>
								<c:when test="${paziente == null && medico == null}">
									<ul class="navbar-nav ml-auto">
										<li class="nav-item">
											<a class="nav-link" href="#">Servizi</a>
										</li>
										<li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/registrazione.jsp">Registrati</a>
                                        </li>
                                        <li class="nav-item">
											<a href="${pageContext.request.contextPath}/login.jsp" class="btn medilife-appoint-btn ml-30">Accedi</a>
										</li>
                                    </ul>
								</c:when>
								<c:when test="${medico!=null}">
									<ul class="navbar-nav ml-auto">
										<li class="nav-item">
                                            <p class="nav-link">Benvenuto, <c:out value="${paziente.name}"/> <c:out value="${paziente.surname}"/></p>
                                        </li>
										<li class="nav-item"><h3 class="nav-link" style="visibility:hidden">#######################</h3></li>       
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/iMieiPazienti.jsp">I miei pazienti</a>
                                        </li>
									  	<li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/#">I miei appuntamenti</a>
                                        </li>
                                        <li class="nav-item">
                                        	<a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                                        </li>
									</ul>
								</c:when>
								<c:when test="${paziente!=null}">
									<ul class="navbar-nav ml-auto">
										<li class="nav-item">
                                            <p class="nav-link">Benvenuto, <c:out value="${paziente.name}"/> <c:out value="${paziente.surname}"/></p>
                                        </li>
										<li class="nav-item"><h3 class="nav-link" style="visibility:hidden">#######################</h3></li>
										<li class="nav-item">
											<a class="nav-link" href="${pageContext.request.contextPath}/cercaMedicoZonaTipo.jsp">Cerca medico</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/ImieiMedici">I miei medici</a>
                                        </li>
										<li class="nav-item">
                                        	<a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                                        </li>
                                    </ul>
								</c:when>
							</c:choose>
						</div>
					</nav>
				</div>
			</div>
		</div>
	</div>
</div>
</header>
    
</body>
</html>