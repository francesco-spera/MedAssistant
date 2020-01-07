/**
 * 
 */

function validateLoginForm(form){
	if(form.email.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w+)+$/)){
		var psw = form.psw.value;
		if(psw.length>=6)
			return true;
		else
			return false;
	} else
		return false; 
}

function valRegFormPaz(form){
	if(form.email.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w+)+$/)){
		var psw = form.psw.value;
		if(psw.length>=6)
			if(form.name.value.match(/^[A-Za-z]+$/))
				if(form.surname.value.match(/^[A-Za-z]+$/))
					if(form.cf.length==16)
						if(form.photo.length>0)
							if(form.domicile.length>0)
								if(form.residence.length>0)
									return true;
								else
									return false;
							else
								return false;
						else
							return false;
					else
						return false;
				else
					return false;
			else
				return false;
		else
			return false;
	} else
		return false;
}

function valRegFormMed(form){
	if(form.email.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w+)+$/)){
		var psw = form.psw.value;
		if(psw.length>=6)
			if(form.name.value.match(/^[A-Za-z]+$/))
				if(form.surname.value.match(/^[A-Za-z]+$/))
					if(form.mobilep.value.match(/^[0-9]{10}$/))
						if(form.cf.length==16)
							if(form.photo.length>0)
								if(form.domicile.length>0)
									if(form.residence.length>0)
										return true;
									else
										return false;
								else
									return false;
							else
								return false;
						else
							return false;
					else
						return false;
				else
					return false;
			else
				return false;
		else
			return false;
	} else
		return false;
}