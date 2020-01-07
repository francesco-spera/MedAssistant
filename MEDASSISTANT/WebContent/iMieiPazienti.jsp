<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Medilife - Health &amp; Medical Template | Elements</title>

    <!-- Favicon  -->
    <link rel="icon" href="core/img/core-img/favicon.ico">

    <!-- Style CSS -->
    <link rel="stylesheet" href="style.css">

</head>

<body>
    <!-- Preloader -->
    <div id="preloader">
        <div class="medilife-load"></div>
    </div>

    <%@ include file="core/header/header.jsp" %>  

    <!-- ***** Breadcumb Area Start ***** -->
    <section class="breadcumb-area bg-img gradient-background-overlay" style="background-image: url(core/img/bg-img/breadcumb2.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="breadcumb-content">
                        <h3 class="breadcumb-title" style="margin-left:350px;">I miei pazienti</h3>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ***** Breadcumb Area End ***** -->

    <!-- ***** Elements Area Start ***** -->
    <section class="elements-area section-padding-100-0">
        <div class="container">

            <div class="row">
                <!-- ***** Progress Bars & Accordions ***** -->
                <div class="col-12">
                    <div class="elements-title">
                        <h2>I miei pazienti - Lista</h2>
                    </div>


                    <div class="accordions mb-100" id="accordion" role="tablist" aria-multiselectable="true">
                     <div class="inner-form">
				          <div class="basic-search">
				            <div class="input-field">
                   				 <input name="name" id="myInput" type="text" placeholder="Inserisci il nome del medico che cerchi" />
				            </div>
				            </div>
				            
				         </div>
                    
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
                    
                    
                    
                    
                    
                    
                    
                        <!-- single accordian area -->
                        <c:forEach items="${accounts}" var="account">
                        <div class="panel single-accordion">
                            <h6><a role="button" class="" aria-expanded="true" aria-controls="collapseOne" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">${account.surname} ${account.name}
                                    <span class="accor-open"><i class="fa fa-plus" aria-hidden="true"></i></span>
                                    <span class="accor-close"><i class="fa fa-minus" aria-hidden="true"></i></span>
                                    </a></h6>
                            <div id="collapseOne" class="accordion-content collapse show">
                                <p>qua ci va la cartella clinica</p>
                            </div>
                        </div>
                        </c:forEach>
        </div>
                </div>
        
                </div>
                </div>
        
    </section>
    <!-- ***** Elements Area End ***** -->

    <%@ include file="core/header/footer.jsp" %>  

    <!-- jQuery (Necessary for All JavaScript Plugins) -->
    <script src="core/js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="core/js/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="core/js/bootstrap.min.js"></script>
    <!-- Plugins js -->
    <script src="core/js/plugins.js"></script>
    <!-- Active js -->
    <script src="core/js/active.js"></script>
</body>

</html>