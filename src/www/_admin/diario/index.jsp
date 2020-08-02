<%@page import="java.text.*,java.util.*,java.sql.SQLException,com.emesa.Configuration,com.emesa.gestinm.dao.FEL_DIARIO"%><%

/*
-----------------------------------------
Desarrollado por EMESA S.L.
http://www.emesa.com

$Id: index.jsp,v 1.6 2004/03/18 10:13:45 swhite Exp $
-----------------------------------------
$Author: swhite $
$Date: 2004/03/18 10:13:45 $
-----------------------------------------
*/
%><jsp:useBean id="_profile_" class="com.emesa.gestinm.portalframework.UserProfile" scope="session" /><%

SimpleDateFormat sdfDBDate=new SimpleDateFormat(Configuration.getProperty("db.date_format"));
SimpleDateFormat sdfShowDateTime = new SimpleDateFormat(Configuration.getProperty("show.date_long_format"));

String dFecha = request.getParameter("FECHA_DIARIO");
String strMensaje = request.getParameter("txtMsg");
String intIDMensaje = request.getParameter("ID_MENSAJE");

if(intIDMensaje!=null && !intIDMensaje.equals("")) {
	if (_profile_.getIdUsuario() != -1) {
		FEL_DIARIO objBorrarMensaje = new FEL_DIARIO();
	
		try {
			objBorrarMensaje.delete(Integer.parseInt(intIDMensaje));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

if(strMensaje!=null && !strMensaje.equals("")) {
	/* Submit mensaje */
	
	if (_profile_.getIdUsuario() != -1) {
		FEL_DIARIO objWriteMensaje = new FEL_DIARIO();
	
		objWriteMensaje.setID_USUARIO(_profile_.getIdUsuario());
		objWriteMensaje.setFECHA(new Date());
		
		
		//strMensaje = strMensaje.replaceAll("/\r\n|\r|\n/g", "<br />\n");
		objWriteMensaje.setMENSAJE(strMensaje);
	
		try {
			objWriteMensaje.saveToDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

if(dFecha!=null && !dFecha.equals("")) {
	
} else {
	/* First time through so use Today as default */
	dFecha = sdfDBDate.format(new Date()).toString();
}
%><html>
<head>
	<title>Diario test</title>
	<link rel="stylesheet" href="/gestinm/css/calendario.css" type="text/css">
	
	<script language="JavaScript">
	<!--
	function cargar() {
    	var dFecha;
	dFecha = document.frmFecha.FECHA_DIARIO.value;

	if(dFecha != "") {
		document.frmFecha.submit();
	} else {
		// Mandar mensaje de error O usar hoy

		var hoy = new Date();
		var dYear = hoy.getYear();
		var dMes = hoy.getMonth() + 1;
		var dDia = hoy.getDate();

		if (dMes < 10) { 
			dMes = "0" + dMes;
		}

		if (dDia < 10) { 
			dDia = "0" + dDia;
		}

		var dFechaHoy = dYear + "-" + dMes + "-" + dDia;

		document.frmFecha.FECHA_DIARIO.value = dFechaHoy;
		document.frmFecha.submit();
	}
	}
	
	function mandarMensaje() {
	var strMsg;

	strMsg = document.frmMsg.txtMsg.value;
	
	if (strMsg != "") {
		document.frmMsg.submit();
	}
	}
	
	function borrarMsg(idMensaje){
		document.frmBorrar.ID_MENSAJE.value = idMensaje;
		document.frmBorrar.submit();
	}
	
	
	function datechar() {
		var keyPressed = window.event.keyCode;
		/*
		 
		  8 = Backspace
		 16 = Shift
		 17 = Ctrl
		 
		 35 = Fin
		 36 = Inicio
		 37 = Cursor Izda
		 39 = Cursor Dcha
		 
		 46 = Supr.
		 48 = 0
		 49 = 1
		 ...
		 57 = 9
		 
		 96 = NumPad 0
		 97 = NumPad 1
		...
		105 = NumPad 9
		
		109 = NumPad -
		189 = -
		*/
		
		if (	keyPressed == 8 ||
			keyPressed == 16 ||
			keyPressed == 17 ||
			keyPressed == 35 ||
			keyPressed == 36 ||
			keyPressed == 37 ||
			keyPressed == 39 ||
			keyPressed == 46 ||
			keyPressed == 109 ||
			keyPressed == 189 ||
			(keyPressed > 47 && keyPressed < 58) ||
			(keyPressed > 95 && keyPressed < 106)
			) {
		} else if (keyPressed == 13) {
			// Intro así que hacer un "cargar()"
			cargar()
		} else {
			window.event.keyCode = 38;	//Up arrow
		}
	}
	
	function imprimir() {
		window.open("/gestinm/imprimir.jsp", "VentanaHija", "resizable=no, toolbar=no, scrollbars=yes, width=800, height=500");
	}
	
	function InsertarSaltadeLinea(strTexto) {
		
	}
	//-->
	</script>
</head>
<body>
	<form name="frmBorrar" method="POST"><input type="hidden" name="ID_MENSAJE"></form>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td width="70%">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<form name="frmMsg" method="POST"><td valign="top" width="100" align="right">Mensaje: &nbsp;</td><td valign="top"><!-- <input type="text" name="txtMsg" size="60">--><textarea name="txtMsg" cols="60" rows="3"></textarea></td><td align="left" valign="top">&nbsp;<input type="button" value="Enviar" class="calendar" onClick="mandarMensaje();"></td></form>
			<td width="100">&nbsp;</td>
		</tr>

		</table>
	</td><td  width="30%">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<form name="frmFecha" method="POST"><td><input type="text" name="FECHA_DIARIO" id="fecha_diario" size="20" class="fechabox" value="<%= dFecha %>" onkeydown="datechar();"> <input type="button" value="cargar" class="calendar" onClick="cargar();"><br /><input type="button" value="fecha" class="calendar" onClick="return showCalendar('fecha_diario', 'y-mm-dd');"> &nbsp;<script type="text/javascript" src="/gestinm/js/calendar.js"></script><i>(formato: aaaa-mm-dd)</i></td></form>
		</tr>
		</table>
</td></tr></table>
<img src="/gestinm/images/printer.png" onclick="javascript:imprimir()" alt="Imprimir" style="{cursor: hand}" align="right" />
<div id="toPrintLayer">
	<br/>
	
    <table width="100%" border="0" cellspacing="1px" cellpadding="2px">
	<thead>
	<tr>
	<th></th>
	<!-- <th>id</th> -->
	<th>Fecha</th>
	<th>Usuario</th>
	<th>Mensaje</th>
	</tr></thead>
	<tbody><%

	FEL_DIARIO objDIARIO = new FEL_DIARIO();
	FEL_DIARIO objDiarioMsg = new FEL_DIARIO();
	Vector vDiarioResultados = new Vector();
	vDiarioResultados = objDIARIO.loadFromDB(sdfDBDate.parse(dFecha));

	for(int i=0; i < vDiarioResultados.size(); i++){
		objDiarioMsg = (FEL_DIARIO)vDiarioResultados.elementAt(i);

		String trClass = " class=\"odd\"";
		String strIMGTag = "";

		if (i%2==0) {
			trClass = "odd";
		} else {
			trClass = "even";
		}

		if(_profile_.getIdUsuario() == objDiarioMsg.getID_USUARIO()) {
			/* Solo se puede borrar los mensajes de hoy */
			if(sdfDBDate.format(objDiarioMsg.getFECHA()).toString().equals(sdfDBDate.format(new Date()).toString())) {
				strIMGTag = "<td width=\"10\" valign=\"top\"><a href=\"#\" onClick=\"borrarMsg(" + objDiarioMsg.getID_MENSAJE() + ");\";><img src=\"/gestinm/images/x.gif\" alt=\"Borrar\" border=\"0\"></a></td>";
			} else {
				strIMGTag = "<td width=\"10\" valign=\"top\">&nbsp;</td>";			
			}
		} else {
			strIMGTag = "<td width=\"10\" valign=\"top\">&nbsp;</td>";			
		}

		%><tr class="<%=trClass%>"><%=strIMGTag%>
		<td width="200" valign="top"> <%=sdfShowDateTime.format(objDiarioMsg.getFECHA())%></td>
		<td width="150" valign="top"><%=objDiarioMsg.getNOMBRE_USUARIO()%> <%=objDiarioMsg.getAPELLIDO1_USUARIO()%></td>
		<td width="*" valign="top"><%
		/* Cambiar \n en texto a <br /> para que se vea bien in HTML */
		out.print(objDiarioMsg.getMENSAJE().replaceAll("/\r\n|\r|\n/g", "<br />\n")); %></td>
		</tr><%
	}
%></tbody></table>
<br /><br /></div>
<center><img src="/gestinm/images/printer.png" onclick="javascript:imprimir()" alt="Imprimir" style="{cursor: hand}" /></center><br />
</body>
</html>