<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>MedAssistant | Home</title>
<link rel="icon" href="core/img/core-img/favicon.ico">
<link rel="stylesheet" href="style.css">
</head>
<body>
    
    <div id="preloader">
        <div class="medilife-load"></div>
    </div>
	
	<%@ include file="core/header/header.jsp" %>  


    <section class="hero-area">
        <div class="hero-slides owl-carousel">
            <div class="single-hero-slide bg-img bg-overlay-white" style="background-image: url(core/img/bg-img//hero1.jpg);">
                <div class="container h-100">
                    <div class="row h-100 align-items-center">
                        <div class="col-12">
                            <div class="hero-slides-content">
                                <h2 data-animation="fadeInUp" data-delay="100ms">Semplifica <br> il tuo studio medico</h2>
                                <h6 data-animation="fadeInUp" data-delay="400ms">La piattaforma che semplifica l'interazione tra medici e pazienti.</h6>
                                <a href="registrazione.jsp" class="btn medilife-btn mt-50" data-animation="fadeInUp" data-delay="700ms">Scopri MedAssistant <span>+</span></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="single-hero-slide bg-img bg-overlay-white" style="background-image: url(core/img/bg-img//breadcumb3.jpg);">
                <div class="container h-100">
                    <div class="row h-100 align-items-center">
                        <div class="col-12">
                            <div class="hero-slides-content">
                                <h2 data-animation="fadeInUp" data-delay="100ms">Pensata per i medici <br>e per i pazienti</h2>
                                <h6 data-animation="fadeInUp" data-delay="400ms">Facilita il carico lavorativo.</h6>
                                <a href="registrazione.jsp" class="btn medilife-btn mt-50" data-animation="fadeInUp" data-delay="700ms">Scopri MedAssistant<span>+</span></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="single-hero-slide bg-img bg-overlay-white" style="background-image: url(core/img/bg-img//breadcumb1.jpg);">
                <div class="container h-100">
                    <div class="row h-100 align-items-center">
                        <div class="col-12">
                            <div class="hero-slides-content">
                                <h2 data-animation="fadeInUp" data-delay="100ms">Cosa aspetti?<br>Registrati subito!</h2>
                                <h6 data-animation="fadeInUp" data-delay="400ms">Rapida, veloce, sicura.</h6>
                                <a href="registrazione.jsp" class="btn medilife-btn mt-50" data-animation="fadeInUp" data-delay="700ms">Scopri MedAssistant<span>+</span></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

	<div class="container">
            <div class="row"></div>
    </div>

	<%@ include file="core/header/footer.jsp" %>  
	
   
    <script src="core/js/jquery/jquery-2.2.4.min.js"></script>
    <script src="core/js/popper.min.js"></script>
    <script src="core/js/bootstrap.min.js"></script>
    <script src="core/js/plugins.js"></script>
    <script src="core/js/active.js"></script>

</body>
</html>