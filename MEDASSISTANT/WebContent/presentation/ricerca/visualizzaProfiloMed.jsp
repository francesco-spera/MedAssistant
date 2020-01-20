<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
<title>MedAssistant | Profilo Medico</title>
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

	<% if(request.getSession().getAttribute("pazLog")==null){
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	%>

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
	    <h1>Profilo del dott. <c:out value="${accDoc.surname}"/></h1>
	    <img src="presentation/profilo/GetProfileImage.jsp?doctor=${accDoc.doctor}" width="230px" height="140px"/>
		
		<% boolean linkstate = (boolean) request.getAttribute("linkstate");
	    if (!linkstate){
	    %>
		<input type="submit" class="btn btn-primary" value="Richiedi Collegamento" onclick="ajaxCall('load','<%=request.getContextPath()%>/RichiedereCollegamento', displayResults(),'${infoDoc.email}','prova oggetto','Salve Dottor,\nL\'utente, email: \n\nha richiesto di effettuare un collegamento con lei: http://localhost:8080/MEDASSISTANT/visualizzaCollegamento.jsp?email=',6000)">
		<%} 
		if (linkstate){
		%>
		
		<a type="submit" class="btn btn-primary" href="${pageContext.request.contextPath}/presentation/appuntamento/prenotaAppuntamento.jsp">Prenota appuntamento</a>	
		<%}
		boolean state = (boolean) request.getAttribute("votestate");

		if (!state && linkstate){
			%>
		<a class="btn btn-success btn-green" href="#reviews-anchor" id="open-review-box">Vota</a>
		
		<%} %>
 
<div class="container">
<div class="row" style="margin-top:40px;">
  <div class="col-md-12" >
    <div class="well well-sm">
          <div class="row" id="post-review-box" style="display:none;">
          <form action="${pageContext.request.contextPath}/VotaMedico" method="GET">
          <div class="form-group" id="rating-ability-wrapper">
          <label class="control-label" for="rating">
          <span class="field-label-header">Indica un valore da 1 a 5:</span><br>
          <span class="field-label-info"></span>
          <input type="hidden" id="selected_rating" name="selected_rating" value="" required="required">
          <input type="hidden" name="emailDoc" value="${infoDoc.email}">
          <input type="hidden" name="emailPatient" value="${pazLog.patient}">
          <%	Date date = new Date();
				SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
		  %>
		  <input type="hidden" name="dateVote" value="<%=timeFormat.format(date)%>">
          </label>
          <h2 class="bold rating-header" style="">
          <span class="selected-rating">0</span><small> / 5</small>
          </h2>
          <button type="button" class="btnrating btn btn-default btn-lg" data-attr="1" id="rating-star-1">
              <i class="fa fa-star" aria-hidden="true"></i>
          </button>
          <button type="button" class="btnrating btn btn-default btn-lg" data-attr="2" id="rating-star-2">
              <i class="fa fa-star" aria-hidden="true"></i>
          </button>
          <button type="button" class="btnrating btn btn-default btn-lg" data-attr="3" id="rating-star-3">
              <i class="fa fa-star" aria-hidden="true"></i>
          </button>
          <button type="button" class="btnrating btn btn-default btn-lg" data-attr="4" id="rating-star-4">
              <i class="fa fa-star" aria-hidden="true"></i>
          </button>
          <button type="button" class="btnrating btn btn-default btn-lg" data-attr="5" id="rating-star-5">
              <i class="fa fa-star" aria-hidden="true"></i>
          </button>
          <hr>

        <input id="save" type="submit" class="btn btn-primary btn-block" value="Salva" hidden="true">
      </div>
      </form>
            </div>
         </div>

  </div>
</div>
</div>

    <hr>
    
		<div class="row">
	      <div class="col align-self-center personal-info mb-5">
	        <h3>Informazioni</h3>
	          <div class="form-group">
	            <label class="col-lg-3 control-label">Nome</label>
	            <div class="col-lg-8">
	              <input class="form-control" type="text" value="${accDoc.name}" readonly>
	            </div>
	          </div>
	            <div class="form-group">
	            <label class="col-lg-3 control-label">Numero di telefono</label>
	            <div class="col-lg-8">
	              <input class="form-control" type="text" value="${infoDoc.phoneNumber}" readonly>
	            </div>
	          </div>
	          <div class="form-group">
	            <label class="col-lg-3 control-label">Indirizzo Studio</label>
	            <div class="col-lg-8">
	              <input class="form-control" type="text" value="${infoDoc.studioAddress}" readonly>
	            </div>
	          </div>
	          <div class="form-group">
	            <label class="col-lg-3 control-label">Provincia</label>
	            <div class="col-lg-8">
	              <input class="form-control" type="text" value="${infoDoc.municipalityAddress}" readonly>
	            </div>
	          </div>
	          <div class="form-group">
	          	<label class="col-lg-3 control-label">Specializzazione</label>
	            <div class="col-lg-8">
	              <input class="form-control" type="text" value="${infoDoc.type}" readonly>
	          </div>
	          </div>
	          <div class="form-group">
	            <label class="col-lg-3 control-label">Ratings</label>
	          <div class="col-lg-8">
	            <input class="form-control" type="text"  value="${infoDoc.avgReviews}" readonly>
	            </div>
	          </div>
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
	
	//vota
	

    (function(e){var t,o={className:"autosizejs",append:"",callback:!1,resizeDelay:10},i='<textarea tabindex="-1" style="position:absolute; top:-999px; left:0; right:auto; bottom:auto; border:0; padding: 0; -moz-box-sizing:content-box; -webkit-box-sizing:content-box; box-sizing:content-box; word-wrap:break-word; height:0 !important; min-height:0 !important; overflow:hidden; transition:none; -webkit-transition:none; -moz-transition:none;"/>',n=["fontFamily","fontSize","fontWeight","fontStyle","letterSpacing","textTransform","wordSpacing","textIndent"],s=e(i).data("autosize",!0)[0];s.style.lineHeight="99px","99px"===e(s).css("lineHeight")&&n.push("lineHeight"),s.style.lineHeight="",e.fn.autosize=function(i){return this.length?(i=e.extend({},o,i||{}),s.parentNode!==document.body&&e(document.body).append(s),this.each(function(){function o(){var t,o;"getComputedStyle"in window?(t=window.getComputedStyle(u,null),o=u.getBoundingClientRect().width,e.each(["paddingLeft","paddingRight","borderLeftWidth","borderRightWidth"],function(e,i){o-=parseInt(t[i],10)}),s.style.width=o+"px"):s.style.width=Math.max(p.width(),0)+"px"}function a(){var a={};if(t=u,s.className=i.className,d=parseInt(p.css("maxHeight"),10),e.each(n,function(e,t){a[t]=p.css(t)}),e(s).css(a),o(),window.chrome){var r=u.style.width;u.style.width="0px",u.offsetWidth,u.style.width=r}}function r(){var e,n;t!==u?a():o(),s.value=u.value+i.append,s.style.overflowY=u.style.overflowY,n=parseInt(u.style.height,10),s.scrollTop=0,s.scrollTop=9e4,e=s.scrollTop,d&&e>d?(u.style.overflowY="scroll",e=d):(u.style.overflowY="hidden",c>e&&(e=c)),e+=w,n!==e&&(u.style.height=e+"px",f&&i.callback.call(u,u))}function l(){clearTimeout(h),h=setTimeout(function(){var e=p.width();e!==g&&(g=e,r())},parseInt(i.resizeDelay,10))}var d,c,h,u=this,p=e(u),w=0,f=e.isFunction(i.callback),z={height:u.style.height,overflow:u.style.overflow,overflowY:u.style.overflowY,wordWrap:u.style.wordWrap,resize:u.style.resize},g=p.width();p.data("autosize")||(p.data("autosize",!0),("border-box"===p.css("box-sizing")||"border-box"===p.css("-moz-box-sizing")||"border-box"===p.css("-webkit-box-sizing"))&&(w=p.outerHeight()-p.height()),c=Math.max(parseInt(p.css("minHeight"),10)-w||0,p.height()),p.css({overflow:"hidden",overflowY:"hidden",wordWrap:"break-word",resize:"none"===p.css("resize")||"vertical"===p.css("resize")?"none":"horizontal"}),"onpropertychange"in u?"oninput"in u?p.on("input.autosize keyup.autosize",r):p.on("propertychange.autosize",function(){"value"===event.propertyName&&r()}):p.on("input.autosize",r),i.resizeDelay!==!1&&e(window).on("resize.autosize",l),p.on("autosize.resize",r),p.on("autosize.resizeIncludeStyle",function(){t=null,r()}),p.on("autosize.destroy",function(){t=null,clearTimeout(h),e(window).off("resize",l),p.off("autosize").off(".autosize").css(z).removeData("autosize")}),r())})):this}})(window.jQuery||window.$);

    var __slice=[].slice;(function(e,t){var n;n=function(){function t(t,n){var r,i,s,o=this;this.options=e.extend({},this.defaults,n);this.$el=t;s=this.defaults;for(r in s){i=s[r];if(this.$el.data(r)!=null){this.options[r]=this.$el.data(r)}}this.createStars();this.syncRating();this.$el.on("mouseover.starrr","span",function(e){return o.syncRating(o.$el.find("span").index(e.currentTarget)+1)});this.$el.on("mouseout.starrr",function(){return o.syncRating()});this.$el.on("click.starrr","span",function(e){return o.setRating(o.$el.find("span").index(e.currentTarget)+1)});this.$el.on("starrr:change",this.options.change)}t.prototype.defaults={rating:void 0,numStars:5,change:function(e,t){}};t.prototype.createStars=function(){var e,t,n;n=[];for(e=1,t=this.options.numStars;1<=t?e<=t:e>=t;1<=t?e++:e--){n.push(this.$el.append("<span class='glyphicon .glyphicon-star-empty'></span>"))}return n};t.prototype.setRating=function(e){if(this.options.rating===e){e=void 0}this.options.rating=e;this.syncRating();return this.$el.trigger("starrr:change",e)};t.prototype.syncRating=function(e){var t,n,r,i;e||(e=this.options.rating);if(e){for(t=n=0,i=e-1;0<=i?n<=i:n>=i;t=0<=i?++n:--n){this.$el.find("span").eq(t).removeClass("glyphicon-star-empty").addClass("glyphicon-star")}}if(e&&e<5){for(t=r=e;e<=4?r<=4:r>=4;t=e<=4?++r:--r){this.$el.find("span").eq(t).removeClass("glyphicon-star").addClass("glyphicon-star-empty")}}if(!e){return this.$el.find("span").removeClass("glyphicon-star").addClass("glyphicon-star-empty")}};return t}();return e.fn.extend({starrr:function(){var t,r;r=arguments[0],t=2<=arguments.length?__slice.call(arguments,1):[];return this.each(function(){var i;i=e(this).data("star-rating");if(!i){e(this).data("star-rating",i=new n(e(this),r))}if(typeof r==="string"){return i[r].apply(i,t)}})}})})(window.jQuery,window);$(function(){return $(".starrr").starrr()})

    $(function(){

      $('#new-review').autosize({append: "\n"});

      var reviewBox = $('#post-review-box');
      var newReview = $('#new-review');
      var openReviewBtn = $('#open-review-box');
      var closeReviewBtn = $('#close-review-box');
      var ratingsField = $('#ratings-hidden');

      openReviewBtn.click(function(e)
      {
        reviewBox.slideDown(400, function()
          {
            $('#new-review').trigger('autosize.resize');
            newReview.focus();
          });
        openReviewBtn.fadeOut(100);
        closeReviewBtn.show();
      });

      closeReviewBtn.click(function(e)
      {
        e.preventDefault();
        reviewBox.slideUp(300, function()
          {
            newReview.focus();
            openReviewBtn.fadeIn(200);
          });
        closeReviewBtn.hide();
        
      });

  	jQuery(document).ready(function($){
	    
  		$(".btnrating").on('click',(function(e) {
  		
  		var previous_value = $("#selected_rating").val();
  		
  		var selected_value = $(this).attr("data-attr");
  		$("#selected_rating").val(selected_value);
  		
  		$(".selected-rating").empty();
  		$(".selected-rating").html(selected_value);
  		
  		for (i = 1; i <= selected_value; ++i) {
  		$("#rating-star-"+i).toggleClass('btn-warning');
  		$("#rating-star-"+i).toggleClass('btn-default');
  		$("#save").attr("hidden",false);
  		}
  		
  		for (ix = 1; ix <= previous_value; ++ix) {
  		$("#rating-star-"+ix).toggleClass('btn-warning');
  		$("#rating-star-"+ix).toggleClass('btn-default');
  		$("#save").attr("hidden",false);
  		}
  		
  		}));
  		
  			
  	});

    });
    
	</script>

</body>
</html>
