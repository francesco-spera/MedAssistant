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
<title>MedAssistant | Appuntamento</title>
<link rel="icon" href="../../core/img/core-img/favicon.ico">
<link rel="stylesheet" href="../../core/css/style.css">
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/themes/redmond/jquery-ui.css">

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
	    <h4>Informazioni generali paziente</h4>
		    <div class="row">
			    <div class="form-group">
		           <label class="col-lg-3 control-label">Nome</label>
		           <div class="col-lg-8">
		             <input class="form-control" type="text" value="${AppointmentPat.name}" readonly>
		           </div>
		         </div>
		         <div class="form-group">
		           <label class="col-lg-3 control-label">Cognome</label>
		           <div class="col-lg-8">
		             <input class="form-control" type="text" value="${AppointmentPat.surname}" readonly>
		           </div>
		         </div>
		    </div>
		     <div class="row">
			    <div class="form-group">
		           <label class="col-lg-3 control-label">Email</label>
		           <div class="col-lg-12">
		             <input class="form-control" type="text" value="${Appointment.patient}" readonly>
		           </div>
		         </div>
		         <div class="form-group">
		           <label class="col-lg-12 control-label">Data di Nascita</label>
		           <div class="col-lg-12">
		             <input class="form-control" type="date" value="${AppointmentPat.birthDate}" readonly>
		           </div>
		         </div>
		    </div>
		    
		<hr>
		<h4>Informazioni generali appuntamento</h4>
		<div class="row">
			    <div class="form-group">
		           <label class="col-lg-3 control-label">Data</label>
		           <div class="col-lg-12">
		             <input id="date" class="form-control" type="date" value="${Appointment.date}" />
		           </div>
		         </div>
		         <div class="form-group">
		           <label class="col-lg-3 control-label">Ora</label>
		           <div class="col-lg-12">
		             <input class="form-control" type="text" value="${Appointment.time}" >
		           </div>
		         </div>
		    </div>
		</div>
		</div>
	</div>

				


	                   
	<br>
	<br>
	<br>
	<br>

	<%@ include file="../generali/footer.jsp" %> 

	<script src="../../core/js/jquery/jquery-2.2.4.min.js"></script>
	<script src="../../core/vendor/bootstrap/js/popper.js"></script>
	<script src="../../core/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="../../core/vendor/select2/select2.min.js"></script>
    <script src="../../core/js/popper.min.js"></script>
    <script src="../../core/js/bootstrap.min.js"></script>
    <script src="../../core/js/plugins.js"></script>
    <script src="../../core/js/active.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
    <script type="text/javascript" src="../../core/js/datapicker_it.js"></script>
    
    <script>
    $(function() {
    	  var holidays = [
    	    '1.1.2020'
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
