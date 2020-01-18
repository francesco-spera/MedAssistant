<%@page import="model.RicercaManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
	
<% ArrayList<?> App = (ArrayList<?>) request.getSession().getAttribute("allApp"); %>

<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=ISO-8859-1"
	import="java.util.*,bean.Appointment"%>
	<%@ page contentType="text/html; charset=ISO-8859-1"
	import="java.util.*,bean.Account"%>
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>MedAssistant | Agenda Appuntamenti</title>
<link rel="icon" href="../../core/img/core-img/favicon.ico">
<link rel="stylesheet" href="../../core/css/style.css">


<link href='../../core/css/fullcalendar.css' rel='stylesheet' />
<link href='../../core/css/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src='../../core/js/jquery-1.10.2.js' type="text/javascript"></script>
<script src='../../core/js/jquery-ui.custom.min.js' type="text/javascript"></script>
<script src='../../core/js/fullcalendar.js' type="text/javascript"></script>
<script src='../../core/js/it.js' type="text/javascript"></script>

<script>

	$(document).ready(function() {
	    var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();

		/*  className colors

		className: default(transparent), important(red), chill(pink), success(green), info(blue)

		*/


		/* initialize the external events
		-----------------------------------------------------------------*/

		$('#external-events div.external-event').each(function() {

			// create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
			// it doesn't need to have a start or end
			var eventObject = {
				title: $.trim($(this).text()) // use the element's text as the event title
			};

			// store the Event Object in the DOM element so we can get to it later
			$(this).data('eventObject', eventObject);

			// make the event draggable using jQuery UI
			$(this).draggable({
				zIndex: 999,
				revert: true,      // will cause the event to go back to its
				revertDuration: 0  //  original position after the drag
			});

		});


		/* initialize the calendar
		-----------------------------------------------------------------*/

		var calendar =  $('#calendar').fullCalendar({
			header: {
				left: 'title',
				center: 'agendaDay,agendaWeek,month',
				right: 'prev,next today'
				
			},
			locale: 'it',
			editable: false,
			firstDay: 1, //  1(Monday) this can be changed to 0(Sunday) for the USA system
			selectable: false,
			defaultView: 'month',
			minTime: "00:00:00",
			maxTime: "24:00:00",


			axisFormat: 'h:mm',
			columnFormat: {
                month: 'ddd',    // Mon
                week: 'ddd d', // Mon 7
                day: 'dddd M/d',  // Monday 9/7
                agendaDay: 'dddd d'
            },
            titleFormat: {
                month: 'MMMM yyyy', // September 2009
                week: "MMMM yyyy", // September 2009
                day: 'MMMM yyyy'                  // Tuesday, Sep 8, 2009
            },
			allDaySlot: false,
			selectHelper: true,
			select: function(start, end, allDay) {
				var title = prompt('Event Title:');
				if (title) {
					calendar.fullCalendar('renderEvent',
						{
							title: title,
							start: start,
							end: end,
							allDay: allDay
						},
						true // make the event "stick"
					);
				}
				calendar.fullCalendar('unselect');
			},
			droppable: false, // this allows things to be dropped onto the calendar !!!
			drop: function(date, allDay) { // this function is called when something is dropped

				// retrieve the dropped element's stored Event Object
				var originalEventObject = $(this).data('eventObject');

				// we need to copy it, so that multiple events don't have a reference to the same object
				var copiedEventObject = $.extend({}, originalEventObject);

				// assign it the date that was reported
				copiedEventObject.start = date;
				copiedEventObject.allDay = allDay;

				// render the event on the calendar
				// the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
				$('#calendar').fullCalendar('renderEvent', copiedEventObject, true);

				// is the "remove after drop" checkbox checked?
				if ($('#drop-remove').is(':checked')) {
					// if so, remove the element from the "Draggable Events" list
					$(this).remove();
				}

			},

			events: [
				{
					start: new Date(y, m, 1)
				}
					<%
					Iterator<?> it = App.iterator();
					while (it.hasNext()) {
						Appointment bean = (Appointment) it.next();
						String[] date = bean.getDate().split("-");
						Account pat = RicercaManager.cercaAccountPaziente(bean.getPatient());
					%>
				
					<%= ", { title: '"+pat.getName()+" "+pat.getSurname()+"',start: new Date("+ date[0]+", "+ (Integer.parseInt(date[1])-1)+", "+ date[2]+", 10, 0), allDay: false, url: '"+request.getContextPath()+"/VisualizzareAppuntamento?id="+bean.getIdAppointment()+"', className: 'success'}" %>
					<%}%>
				

			],
		});


	});

</script>
<style>

	body {
		margin-top: 0px;
		text-align: center;
		font-size: 14px;
		font-family: "Helvetica Nueue",Arial,Verdana;
		background-color: #DDDDDD;
		}

	#wrap {
		width: auto;
		margin: 0 auto;
		}

	#external-events {
		float: left;
		width: auto;
		padding: 0 10px;
		text-align: left;
		}

	#external-events h4 {
		font-size: 16px;
		margin-top: 0;
		padding-top: 1em;
		}

	.external-event { /* try to mimick the look of a real event */
		margin: 10px 0;
		padding: 2px 4px;
		background: #3366CC;
		color: #fff;
		font-size: .85em;
		cursor: pointer;
		}

	#external-events p {
		margin: 1.5em 0;
		font-size: 11px;
		color: #666;
		}

	#external-events p input {
		margin: 0;
		vertical-align: middle;
		}

	#calendar {
/* 		float: right; */
        margin: 0 auto;
		width: auto;
		max-width: 1000px;
		background-color: #FFFFFF;
		  border-radius: 6px;
        box-shadow: 0 1px 2px #C3C3C3;
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
	<br>
	</div>

	
	
		  
			  	<div id='wrap'>
	
				<div id='calendar'></div>
				
				<div style='clear:both'></div>
				</div>
				


	                   
	<br>
	<br>
	<br>
	<br>

	<%@ include file="../generali/footer.jsp" %>

	<script src="../../core/vendor/bootstrap/js/popper.js"></script>
	<script src="../../core/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="../../core/vendor/select2/select2.min.js"></script>
	<script src="../../core/js/popper.min.js"></script>
    <script src="../../core/js/bootstrap.min.js"></script>
    <script src="../../core/js/plugins.js"></script>
    <script src="../../core/js/active.js"></script>
    

</body>
</html>
