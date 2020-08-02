<%@page import="com.emesa.gestinm.dao.FotosInmueble"%><html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-15">
	<meta name="robots" content="NOINDEX, NOFOLLOW">
	<link rel="stylesheet" type="text/css" href="/gestinm/css/gestinm_admin.css">
	<title><%=com.emesa.gestinm.Customization.getProperty("gestinm.title")%> - Fotos</title>
</head>
<body class="bgNaranja">
<script language="javascript">
<!--
function checkForm()
{
	var sErrorMsg="Los siguientes campos contienen errores:";
	if(document.fmId.file1.value=="") {
		sErrorMsg += "\n  - Introduzca al menos un fichero";
	}

	if(sErrorMsg!="Los siguientes campos contienen errores:") {
		alert(sErrorMsg);
		return false;
	}
	else {
		return true;
	}
}
function submitForm()
{
	if(checkForm()) {
		document.fmId.submit();
	}
}
//-->
</script><jsp:useBean id="ofel_inmueble" class="com.emesa.gestinm.dao.FEL_INMUEBLE" scope="session" /><%
if(ofel_inmueble.getCODIGO()==-1) {
    %><p class="err">Antes de asociar las fotos a un inmueble, debe crear el inmueble.</p><p><input type="button" align="center" value="Cerrar" onclick="javascript:window.close();"/></p><%
} else {
%><h4>Fotos asociadas a <%=ofel_inmueble.getCODIGO()%></h4><%

//String del=request.getParameter("

%><p>Pulse en <code>Examinar</code> para subir el fichero con la foto. Una vez haya seleccionado los ficheros, pulse el bot&oacute;n <code>Subir fichero</code>. Para <a href="#borrar">borrar</a> una foto, seleccione la foto que desee eliminar y pulse <code>Borrar</code>.<br/><code>Visible para cliente</code> indica si la foto se puede mostrar en la ficha del cliente.</p>
<table border="0" cellpadding="2" align="center" class="bordeVerde"><%--

// No cambiar el nombre a los parámetros, porque si no srvupload no funcionará correctamente

--%><form method="post" name="fmId" action="/gestinm/srvupload" ENCTYPE="multipart/form-data">
    <tr>
        <th>Fichero</th>
        <th>Visible para cliente</th>
    </tr>
	<tr class="odd">
		<td><input type="file" name="file1"></td>
        <td align="center"><input type="checkbox" name="ver1"/></td>
	</tr>
	<tr class="even">
		<td><input type="file" name="file2"></td>
        <td align="center"><input type="checkbox" name="ver2"/></td>
	</tr>
	<tr class="odd">
		<td><input type="file" name="file3"></td>
        <td align="center"><input type="checkbox" name="ver3"/></td>
	</tr>
	<tr class="even">
		<td><input type="file" name="file4"></td>
        <td align="center"><input type="checkbox" name="ver4"/></td>
	</tr>
    <tr>
		<td colspan="2" class="marca" align="right"><input type="button" class="boton" value="Subir fichero" onClick="javascript:submitForm()"></td>
	</tr>
	</form>
</table>
<script language="javascript">
<!--
  function delPicture() {
    var is_ok = window.confirm("¿Está seguro de que desea eliminar la foto '"+document.fmDel.PATH_FOTO.value+"'?");
    if (is_ok) {
        document.fmDel.submit();;
    }
  }
//-->
</script><%
java.util.Vector vFotos=ofel_inmueble.getPictures();
%><br/><a name="#borrar"/><table border="0" cellpadding="2" class="bordeTopRojo" width="100%">
	<form method="post" name="fmDel" action="upload_update.jsp">
	<tr>
		<td><select name="PATH_FOTO"><%
            for(int i=0; i<vFotos.size(); i++) {
            %><option value="<%=((FotosInmueble)vFotos.elementAt(i)).getPATH_FOTO()%>"><%=((FotosInmueble)vFotos.elementAt(i)).getPATH_FOTO()%><%=((FotosInmueble)vFotos.elementAt(i)).getVISIBLE()==1?" - visible":""%></option><%
            }
        %></select>&nbsp;&nbsp;<input onclick="javascript:delPicture();" type="button" class="boton" value="Borrar"></td>
	</tr>
	</form>
</table><%
}%><p align="center"><input onclick="javascript:window.close();" type="button" class="boton" value="Cerrar"></p></body></html>