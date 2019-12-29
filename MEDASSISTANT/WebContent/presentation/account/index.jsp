<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MED ASSISTANT</title>
</head>
<body>

<a href="presentation/account/login.jsp">login</a>
<a href="presentation/account/registrazione.jsp">registrazione</a>
<a href="logout">logout</a>

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