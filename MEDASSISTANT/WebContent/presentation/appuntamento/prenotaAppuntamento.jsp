<%@page import="model.RicercaManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>MedAssistant | Prenota Appuntamento</title>
<link rel="icon" href="${pageContext.request.contextPath}/core/img/core-img/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath}/core/css/style.css">
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/themes/redmond/jquery-ui.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    
<style type="text/css">
 .scrollable{
   overflow-y: auto;
   overflow-x: none;
   height: 100px;
 }
 .scrollable select{
   border: none;
   outline: none;
 }
 

 
</style>
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
	<br>
	<br>
	</div>
	
	
	<div class="container mt-5">
		    <div class="col align-self-center personal-info mb-5">
		<div class="row">
			    <div class="form-group">
		           <div class="col-lg-9">
		           <h1>Appuntamento </h1>
		           </div>
		         </div>
		    </div>
		</div>
	

	<hr>
	<div class="row">
		<div class="col align-self-center personal-info mb-5">
	    <h4>Informazioni generali medico</h4>
		    <div class="row">
			    <div class="form-group">
		           <label class="col-lg-3 control-label">Nome</label>
		           <div class="col-lg-8">
		             <input class="form-control" type="text" value="${accDoc.name}" readonly>
		           </div>
		         </div>
		         <div class="form-group">
		           <label class="col-lg-3 control-label">Cognome</label>
		           <div class="col-lg-8">
		             <input class="form-control" type="text" value="${accDoc.surname}" readonly>
		           </div>
		         </div>
		    </div>
		     <div class="row">
			    <div class="form-group">
		           <label class="col-lg-3 control-label">Email</label>
		           <div class="col-lg-12">
		             <input class="form-control" type="text" value="${accDoc.doctor}" readonly>
		           </div>
		         </div>
		         <div class="form-group">
		           <label class="col-lg-12 control-label">Tipologia</label>
		           <div class="col-lg-12">
		             <input class="form-control" type="text" value="${infoDoc.type}" readonly>
		           </div>
		         </div>
		    </div>
		    
		<hr>
		<h4>Informazioni generali appuntamento</h4>
		<form action="${pageContext.request.contextPath}/PrenotaAppuntamento" method="POST">
		<input type="hidden" name="doctor" value="${accDoc.doctor}">
		<input type="hidden" name="patient" value="${pazLog.patient}">
		<div class="row">
			    <div class="form-group">
		           <label class="col-lg-3 control-label">Data</label>
		           <div class="col-lg-12">
		             <input id="date" name="date" class="form-control" type="date" value="" required/>
		           </div>
		         </div>
		         <div class="form-group">
		           <label class="col-lg-3 control-label">Ora</label>
		           <div class="col-lg-12">
		           <div class="scrollable">
		            <select name="time" class="form-control" required>
					  <option value="08:00">08:00</option>
					  <option value="08:30">08:30</option>
					  <option value="09:00">09:00</option>
					  <option value="09:30">09:30</option>
					  <option value="10:00">10:00</option>
					  <option value="10:30">10:30</option>
					  <option value="11:00">11:00</option>
					  <option value="11:30">11:30</option>
					  <option value="12:00">12:00</option>
					  <option value="12:30">12:30</option>
					  <option value="13:00">13:00</option>
					  <option value="13:30">13:30</option>
					  <option value="14:00">14:00</option>
					  <option value="14:30">14:30</option>
					  <option value="15:00">15:00</option>
					  <option value="15:30">15:30</option>
					  <option value="16:00">16:00</option>
					  <option value="16:30">16:30</option>
					  <option value="17:00">17:00</option>
					  <option value="17:30">17:30</option>
					  <option value="18:00">18:00</option>
					  <option value="18:30">18:30</option>
					  <option value="19:00">19:00</option>
					  <option value="19:30">19:30</option>
					</select>
					</div>
		           </div>
		         </div>
		         <div class="form-group">
		           <div class="col-lg-12">
		           <br>
		             <input type="submit" id="date" class="btn btn-primary" value="prenota"/>
		             <% if(request.getAttribute("error")!=null) { %> <a>&nbsp&nbsp<%=request.getAttribute("error")  %></a> <%} %>
		           </div>
		         </div>
		    </div>
		    </form>
		</div>
		</div>
	</div>

				


	                   
	<br>
	<br>
	<br>
	<br>

	<%@ include file="../generali/footer.jsp" %> 

	<script src="${pageContext.request.contextPath}/core/js/jquery/jquery-2.2.4.min.js"></script>
	<script src="${pageContext.request.contextPath}/core/vendor/bootstrap/js/popper.js"></script>
	<script src="${pageContext.request.contextPath}/core/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/core/vendor/select2/select2.min.js"></script>
	<script src="${pageContext.request.contextPath}/core/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/core/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/core/js/plugins.js"></script>
    <script src="${pageContext.request.contextPath}/core/js/active.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/core/js/datapicker_it.js"></script>
    
    <script>
    $(function() {
    	  var holidays = [
    	    
    	  ];
    	  function noSundaysOrHolidays(date) {
    	    var day = date.getDay();
    	    if (day != 0) {
    	      var d = date.getDate();
    	      var m = date.getMonth();
    	      var y = date.getFullYear();
    	      for (i = 0; i < holidays.length; i++) {
    	        if($.inArray((d) + '.' + (m+1) + '.' + y, holidays) != -1) {
    	          return [false];
    	        }
    	      }
    	      return [true];
    	    } else {
    	      return [day != 0, ''];
    	    }
    	  }

    	  $('#date').datepicker({
    	    onClose: function(dateText, inst) { 
    	        $(this).attr("disabled", false);
    	    },
    	    beforeShow: function(input, inst) {
    	      $(this).attr("disabled", true);
    	    },
    	    beforeShowDay: noSundaysOrHolidays,
    	    minDate: 0,
    	    dateFormat: 'yy-mm-dd',
    	  });
    	});
    </script>

</body>
</html>
