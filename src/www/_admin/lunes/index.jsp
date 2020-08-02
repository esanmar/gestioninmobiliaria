<%@page import="java.text.*,java.util.*,java.lang.*,java.sql.SQLException,java.text.SimpleDateFormat,com.emesa.Configuration,com.emesa.gestinm.dao.FEL_LUNES"%><%

/*
-----------------------------------------
Desarrollado por EMESA S.L.
http://www.emesa.com

$Id: index.jsp,v 1.1 2004/03/25 15:18:30 esanjurjo Exp $
-----------------------------------------
$Author: esanjurjo $
$Date: 2004/03/25 15:18:30 $
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
		FEL_LUNES objBorrarMensaje = new FEL_LUNES();
	
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
		FEL_LUNES objWriteMensaje = new FEL_LUNES();
	
		objWriteMensaje.setID_USUARIO(_profile_.getIdUsuario());
		objWriteMensaje.setFECHA(new Date());
		objWriteMensaje.setMENSAJE(strMensaje);
	
		try {
			objWriteMensaje.saveToDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

Calendar calendar = new GregorianCalendar();
java.util.Date d = new Date();
int nDay=-1;
if(dFecha!=null && !dFecha.equals("")) {
	/*edu
	d=sdfDBDate.parse(dFecha);
	calendar.setTime(d);
	nDay=calendar.get(Calendar.DAY_OF_WEEK);
	*/
} else {
	/* First time through so use Today as default */
	dFecha = sdfDBDate.format(new Date()).toString();

}
%><html>
<head>
	<title>Lunes</title>
	<link rel="stylesheet" href="/gestinm/css/calendario.css" type="text/css">
	
	<script language="JavaScript">
	<!--
	
	function lunes()
	{	
		var dFecha = document.frmFecha.FECHA_DIARIO.value;
		var actual = new Date();
		if(dFecha != "") {
			var iAnyo=dFecha.indexOf("-")
			var miAnyo = dFecha.substring(0,iAnyo);
			var iMes=dFecha.lastIndexOf("-");
			var miMes = dFecha.substring(iAnyo+1,iMes);
			var miDia = dFecha.substring(iMes+1,dFecha.length);
			
			actual.setMonth(miMes-1);
			actual.setYear(miAnyo);
			actual.setDate(miDia);
		}
		return actual;
	}
	
	
function cargar() {
	
	var hoy = lunes();
	if (hoy.getDay() == "1") 
	{
		document.frmFecha.submit();
	 } else {
		alert("La Fecha no es un Lunes");
	 }
 }
	
	function mandarMensaje() {
		var hoy = new Date();
		var strMsg;
		if (hoy.getDay() == "1") 
		{
			strMsg = document.frmMsg.txtMsg.value;
			if (strMsg != "") {
				document.frmMsg.submit();
			}
		} else {
		alert("La Fecha no es un Lunes");
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
	//-->
	</script>
</head>
<body>
	<form name="frmBorrar" method="POST"><input type="hidden" name="ID_MENSAJE"></form>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">

	<tr>
		<form name="frmMsg" method="POST"><td valign="top" width="100" align="right">Mensaje: &nbsp;</td><td valign="top"><textarea name="txtMsg" cols="50" rows="4"></textarea> <input type="button" value="Enviar" class="calendar" onClick="mandarMensaje();"></td></form><td width="100">&nbsp;</td>
		<td>
		 <form name="frmFecha" method="POST">
		 <input type="text" name="FECHA_DIARIO" id="fecha_diario" size="20" class="fechabox" value="<%= dFecha %>" onkeydown="datechar();">
		 <input type="button" value="cargar" class="calendar" onClick="cargar();"><br />
		 <input type="button" value="fecha" class="calendar" onClick="return showCalendar('fecha_diario', 'y-mm-dd');"> &nbsp;
		 <script type="text/javascript" src="/gestinm/js/calendar.js"></script><i>(formato: aaaa-mm-dd)</i>
		 </form>
		</td>
	</tr>
	</table>

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

	FEL_LUNES objDIARIO = new FEL_LUNES();
	FEL_LUNES objDiarioMsg = new FEL_LUNES();
	Vector vDiarioResultados = new Vector();
	vDiarioResultados = objDIARIO.loadFromDB(sdfDBDate.parse(dFecha));

	for(int i=0; i < vDiarioResultados.size(); i++){
		objDiarioMsg = (FEL_LUNES)vDiarioResultados.elementAt(i);

		String trClass = " class=\"odd\"";
		String strIMGTag = "";

		if (i%2==0) {
			trClass = "odd";
		} else {
			trClass = "even";
		}

		if(_profile_.getIdUsuario() != objDiarioMsg.getID_USUARIO()) {
			strIMGTag = "<td width=\"10\" valign=\"top\">&nbsp;</td>";
		} else {
			strIMGTag = "<td width=\"10\" valign=\"top\"><a href=\"#\" onClick=\"borrarMsg(" + objDiarioMsg.getID_MENSAJE() + ");\";><img src=\"../images/x.gif\" alt=\"Borrar\" border=\"0\"></a></td>";
		}

		%><tr class="<%=trClass%>"><%=strIMGTag%>
		<td width="200" valign="top"> <%=sdfShowDateTime.format(objDiarioMsg.getFECHA())%></td>
		<td width="150" valign="top"><%=objDiarioMsg.getNOMBRE_USUARIO()%> <%=objDiarioMsg.getAPELLIDO1_USUARIO()%></td>
		<td width="*" valign="top"><%=objDiarioMsg.getMENSAJE()%></td>
		</tr><%
	}
%></tbody></table>
</body>
</html>