/**
 * 
 */

	/*
	 *	controllo formato email
	 */

	$(document).ready(function(){
		  $("#email").blur(function(){
		    if(!$("#email").val().match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w+)+$/)){
		    	$("#outEmail").html("Email non valida");
		    }
		  });
	});
	
	/*
	 *	controllo formato email registrazione medico
	 */

	$(document).ready(function(){
		  $("#emailM").blur(function(){
		    if(!$("#emailM").val().match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w+)+$/)){
		    	$("#outEmailM").html("Email non valida");
		    }
		  });
	});
	
	/*
	 *	controllo lunghezza password
	 */
	
	$(document).ready(function(){
		  $("#psw").blur(function(){
		    if($("#psw").val().length<6){
		    	$("#outPsw").html("La password deve contenere almeno 6 caratteri");
		    }
		  });
	});
	
	/*
	 *	controllo lunghezza password registrazione medico
	 */
	
	$(document).ready(function(){
		  $("#pswM").blur(function(){
		    if($("#pswM").val().length<6){
		    	$("#outPswM").html("La password deve contenere almeno 6 caratteri");
		    }
		  });
	});
	
	/*
	 *	controllo formato name
	 */

	$(document).ready(function(){
		  $("#name").blur(function(){
		    if(!$("#name").val().match(/^[A-Za-z]+$/)){
		    	$("#outName").html("Nome non valido");
		    }
		  });
	});
	
	/*
	 *	controllo formato name registrazione medico
	 */

	$(document).ready(function(){
		  $("#nameM").blur(function(){
		    if(!$("#nameM").val().match(/^[A-Za-z]+$/)){
		    	$("#outNameM").html("Nome non valido");
		    }
		  });
	});
	
	/*
	 *	controllo formato surname
	 */

	$(document).ready(function(){
		  $("#surname").blur(function(){
		    if(!$("#surname").val().match(/^[A-Za-z]+$/)){
		    	$("#outSurname").html("Cognome non valido");
		    }
		  });
	});
	
	/*
	 *	controllo formato surname registrazione medico
	 */

	$(document).ready(function(){
		  $("#surnameM").blur(function(){
		    if(!$("#surnameM").val().match(/^[A-Za-z]+$/)){
		    	$("#outSurnameM").html("Cognome non valido");
		    }
		  });
	});
	
	/*
	 *	controllo lunghezza cf
	 */
	
	$(document).ready(function(){
		  $("#cf").blur(function(){
		    if($("#cf").val().length<16){
		    	$("#outCf").html("Codice fiscale non valido");
		    }
		  });
	});
	
	/*
	 *	controllo lunghezza cf registrazione medico
	 */
	
	$(document).ready(function(){
		  $("#cfM").blur(function(){
		    if($("#cfM").val().length<16){
		    	$("#outCfM").html("Codice fiscale non valido");
		    }
		  });
	});
	
	/*
	 *	controllo lunghezza domicile
	 */
	
	$(document).ready(function(){
		  $("#domicile").blur(function(){
		    if($("#domicile").val().length==0){
		    	$("#outDom").html("Domicilio non valido");
		    }
		  });
	});
	
	/*
	 *	controllo lunghezza residence
	 */
	
	$(document).ready(function(){
		  $("#residence").blur(function(){
		    if($("#residence").val().length==0){
		    	$("#outRes").html("Residenza non valida");
		    }
		  });
	});
	
	/*
	 *	controllo lunghezza mobile phone
	 */
	
	$(document).ready(function(){
		  $("#mobilep").blur(function(){
		    if($("#mobilep").val().length<10){
		    	$("#outMobile").html("Numero di telefono non valido");
		    }
		  });
	});
	
	/*
	 *	controllo lunghezza comune
	 */
	
	$(document).ready(function(){
		  $("#munaddr").blur(function(){
			  if(!$("#munaddr").val().match(/^[A-Za-z]+$/)){
		    	$("#outMun").html("comune non valido");
		    }
		  });
	});
	
	/*
	 *	controllo lunghezza indirizzo studio
	 */
	
	$(document).ready(function(){
		  $("#studioaddr").blur(function(){
		    if($("#studioaddr").val().length==0){
		    	$("#outStudio").html("Indirizzo studio non valido");
		    }
		  });
	});
	
	/*
	 *	controllo esistenza data di nascita
	 */
	
	$(document).ready(function(){
		  $("#birth").blur(function(){
		    if($("#birth").val()==null){
		    	$("#outData").html("Inserisci Data di nascita");
		    }
		  });
	});
	
	function sleep(milliseconds) {
		  var start = new Date().getTime();
		  for (var i = 0; i < 1e7; i++) {
		    if ((new Date().getTime() - start) > milliseconds){
		      break;
		    }
		  }
		}
	
	/*
	 *	risposta visiva al controllo credenziali login
	 */
	
	function canAccess(flag){
		//sleep(1500);
		if(!flag){
			$("#outPsw").html("Account non esistente, riprovare");
			return false;
		} else if(flag){
			$("#buttLogin").css("display", "none");
			$("#outPsw").css("display", "none");
			$("#buttLogin2").css("display", "block");
			return true;
		}
	}
	
	/*
	 *	controllo credenziali login
	 */
	
	$(document).ready(function(){
		$("#buttLogin").click(function(){
			$.post("../../autenticazione",
				{	
					email: $("#email").val(),
						psw: $("#psw").val()
				},
					function(data){
					if(data == 'false'){
						canAccess(false);
					} else{
						canAccess(true);
					}
				});
		});
	});
	
	/*
	 *	risposta visiva al controllo credenziali registrazione paziente
	 */
	
	function canRegister(flag){
		//sleep(1500);
		if(!flag){
			$("#outEmail").html("Account gia' registrato, riprovare");
			return false;
		} else if(flag){
			$("#outEmail").css("display", "none");
			$("#regFormP1").css("display", "none");
			$("#regFormP2").css("display", "block");
			return true;
		}
	}
	
	/*
	 *	risposta visiva al controllo credenziali registrazione medico
	 */
	
	function canRegisterM(flag){
		//sleep(1500);
		if(!flag){
			$("#outEmailM").html("Account già registrato, riprovare");
			return false;
		} else if(flag){
			$("#outEmailM").css("display", "none");
			$("#regFormM").css("display", "none");
			$("#regFormM2").css("display", "block");
			return true;
		}
	}
	
	/*
	 *	controllo email registrazione paziente
	 */
	
	$(document).ready(function(){
		$("#buttRegister").click(function(){
			$.post("../../controlloEmail",
				{	
					email: $("#email").val()
				},
					function(data){
					if(data == 'false'){
						canRegister(false);
					} else{
						canRegister(true);
					}
				});
		});
	});
	
	/*
	 *	controllo credenziali registrazione medico
	 */
	
	$(document).ready(function(){
		$("#buttRegisterM").click(function(){
			$.post("../../controlloEmail",
				{	
					email: $("#emailM").val(),
				},
					function(data){
					if(data == 'false'){
						canRegisterM(false);
					} else{
						canRegisterM(true);
					}
				});
		});
	});
