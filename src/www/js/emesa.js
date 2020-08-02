/* Comprueba que sea un CIF válido según el algoritmo Delphi en http://www.q3.nu/trucomania/truco.cgi?337&esp*/
function checkCIF(cif) {
	if(checkDNI(cif))
		return true;
	else {
		/* Correspondencia de las letras del CIF:
			 A - Sociedades Anónimas
			 B - Sociedades de responsabilidad limitada
			 C - Sociedades colectivas
			 D - Sociedades comanditarias
			 E - Comunidades de bienes
			 F - Sociedades cooperativas
			 G - Asociaciones y otros tipos no definidos
			 H - Comunidades de propietarios
			 P - Corporaciones locales
			 Q - Organismos autónomos
			 S - Organos de la administración
			 K, L y M - seguramente para compatibilidad con formatos antiguos
			 X - Extranjeros, que en lugar del D.N.I. tienen el N.I.E.
		*/
		var letrasCIF='ABCDEFGHPQSKLMX';
		// La primera ha de ser una letra válida...
		var primeraLetra=cif.substring(0,1).toUpperCase();
		if( letrasCIF.indexOf(primeraLetra) == -1) {
			return false;
		}
		// Un DNI extranjero...
		else if(primeraLetra=="X"){
			return checkDNI("0"+cif.substring(1,8));
		}
		// CIF 'normal'...
		else {
			//A58818501 --> x5881850x --> 8 + 1 + 5
			var suma=parseInt(cif.substring(2,3))+parseInt(cif.substring(4,5))+parseInt(cif.substring(6,7));
			for(var n=1; n<=4; n++) {
				suma+= ((2 * parseInt(cif.substring(2*n-1,2*n))) % 10) + Math.floor( (2 * parseInt(cif.substring(2*n-1,2*n))) / 10);
			}
			control=10-(suma % 10);
			// Organismos públicos
			if(primeraLetra=="P" || primeraLetra=="S") {
				return cif.substring(8,9)==String.fromCharCode(64+control);
			}
			// Resto de CIFs
			else {
				if(control==10)
					control=0;
				return cif.substring(8,9)==""+control;
			}
		}
	}
	return false;
}

/* Comprueba que sea un DNI válido*/
function checkDNI(dni) {
	if(dni.length!=9) {
		return false;
	}
	var dniNum=dni.substring(0,dni.length-1);
	var dniLetra=dni.substring(dni.length-1,dni.length);

	if (!/^\d{8}$/.test(dniNum)) {
		return false;
	}
	else {
		var letras = 'TRWAGMYFPDXBNJZSQVHLCKE';
		var indLetra = dniNum%23;
		if(dniLetra.toUpperCase()==letras.substring(indLetra,indLetra+1)) {
			return true;
		}
		else {
			return false;
		}
	}
}

/* Comprueba que el número sea decimal*/
function chekFloat(num) {
	var rree=/^[^\.\D]+\.?\d*$/;
	if(rree.test(num)) {
		return true;
	} else {
		return false;
	}
}

/* Comprueba que el número sea entero */
function chekInteger(num) {
	var rree=/^[^\.\D]+$/;
	if(rree.test(num)) {
		return true;
	} else {
		return false;
	}
}

/* Chequeo de email */
function checkEmail(emailStr)
{
	if(emailStr != "") {
		var emailPat = /^(\".*\"|[A-Za-z]\w*(\.[A-Za-z]\w*)*)@(\[\d{1,3}(\.\d{1,3}){3}]|[A-Za-z]\w*[\-]*[A-Za-z]\w*(\.[A-Za-z]\w*)+)$/; 
		var matchArray = emailStr.match(emailPat); 
		if(matchArray == null) { 
			return false;
		}

		var IPArray = emailStr.match(/^\[(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})\]$/); 
		if(IPArray != null) { 
			for (var i=1;i<=4;i++) { 
				if (IPArray[i]>255) { 
					return false;
				}
			} 
		}
		return true;
	}
	return false;
}

/* Chequeo de C.P. */
function checkCP(cp)
{
	if(cp!="" && cp.length==5 && isNumeric(cp,false)) {
		return true;
	}
	else {
		return false;
	}
}


/* Chequeo que sea un número (con posibles espacios) */
function isNumeric(string, ignoreWhiteSpace) 
{
	if(string=="") return false;
	if (string.search) 
	{
		if ((ignoreWhiteSpace && string.search(/[^\d\s]/) != -1) || (!ignoreWhiteSpace && string.search(/\D/) != -1)) return false;
	}
	return true;
}

/* Teléfonos fijos */
function checkNumPhone(objValue) {    
    var myobjDato = new String(objValue)
	
	if (myobjDato == "")                        // Comprueba que no esta vacio
		return false;
	if (myobjDato.length != 9)                  // Comprueba que tenga longitud de nueve
		return false;
	if (!isNumeric(myobjDato))                  // Comprueba si es numerico
        return false;
    if (myobjDato.substring(0,1) != '9')        // Comprueba si empieza por 9
        return false;    
	return true;
}

/* Teléfonos móviles */
function checkNumMovil(objValue) {
	var myobjDato = new String(objValue)

	if (myobjDato == "")                        // Puede estar vacio
		return true;
	if (myobjDato.length != 9)                  // Comprueba que tenga longitud de nueve
		return false;
	if (!isNumeric(myobjDato))                  // Comprueba si es numerico
        return false;
    if (myobjDato.substring(0,1) != '6')        // Comprueba si empieza por 6
        return false;    
	return true;
}

/* Verifica que el formato de la fecha sea dd/mm/aaaa */
function checkDate(fech, sep)
{
	if(fech=="" || sep=="") return false;
	//var fecha = fech.value.toString();	
	var dia = parseInt(fech.substr(0, 2),10);
	var mes = parseInt(fech.substr(3, 2),10);
	var ano = parseInt(fech.substr(6, fech.length),10);
	var separador = fech.substr(2, 1); 	
	var separador2 = fech.substr(5, 1);
	if (dia < 0 || dia > 31 || mes < 0 || mes > 13 || separador != sep || separador2 != sep || ano < 1000 || ano > 9999)
	{
		//alert ( "La fecha debe introducirse con el formato siguiente dd/mm/aaaa. Por favor, introd\372zcala de nuevo.");
		//fech.focus();
		//fech.value = "";
		return false;
	}
	return true;
}


/* Verifica que la fecha introducida sea correcta */
function validacionFecha(fech)
{
	if(fech=="") return false;
	var bisiesto;
	var days = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];
	var fecha = fech.value.toString();	

	var isDiaN = esEntero (fecha.substr(0, 2),10);
	var isMesN = esEntero (fecha.substr(3, 2),10); 
	var isAnoN = esEntero (fecha.substr(6, fecha.length),10);

	if (isDiaN == false || isMesN == false || isAnoN == false){
		alert ("El valor introducido no es num\351rico. Por favor, introd\372zcalo de nuevo.");	
		fech.focus();
		fech.value=""; 
		return false;
	}
	var dia = parseInt(fecha.substr(0, 2),10);
	var mes = parseInt(fecha.substr(3, 2),10);
	var ano = parseInt(fecha.substr(6, fecha.length),10);
	var limite = 0;
	var indice;
	var fecha1 = new Date();
	var actual = Date.parse(fecha1);

	if (mes>12 || mes<1)
	{
		alert("El mes debe estar comprendido entre 1 y 12. Por favor, introd\372zcalo de nuevo."); 
		fech.focus();
		fech.value = "";
		return false;
	}

    indice = mes--;
    (ano % 4 == 0) ? ((ano %100 == 0)?((ano % 400 == 0)? bisiesto = true : bisiesto = false) : bisiesto = true) : bisiesto = false;
    if ((bisiesto== true) && indice ==2)
        limite = 29
    else
        limite = days[mes];
    if (dia<1 || dia>limite)
    {
          alert (" El d\355a debe estar comprendido entre 1 y " + limite + ". Por favor, introd\372zcalo de nuevo.");
          fech.focus();
	  fech.value = "";
	  return false;
    }
    
    if (ano < 1900)
    {
        alert ("El a\361o tiene que ser mayor que 1900. Por favor, introd\372zcalo de nuevo.");
        fech.focus();
	fech.value = "";
	return false;

}
return true;
}