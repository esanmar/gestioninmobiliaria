<html>
<head>
<title> <%=com.emesa.gestinm.Customization.getProperty("gestinm.title")%> - Acceso no permitido </title>
	<link href="/gestinm/css/gestinm_admin.css" rel="stylesheet" type="text/css" />
    <meta http-equiv="refresh" content="8;URL=<%=com.emesa.gestinm.Customization.getProperty("gestinm.url")%>" />
</head>
<body>
<table width="700" align="center" class="pagError">
    <tr>
    	<td rowspan="2" align="center" valign="middle" width="120"><img src="/gestinm/images/bigX.gif" width="100" height="100" border="0" alt=""></td>
    	<td><h2>Acceso no permitido</h2></td>
    </tr>
    <tr>
        <td><p><b><%=request.getRemoteUser()%></b>, est&aacute; usted intentando acceder al portal desde un lugar no permitido, si considera que se trata de un fallo o error, por favor, p&oacute;ngase en contacto con el administrador.</p>
        <p>En breve ser&aacute; redireccionado a la p&aacute;gina de inicio</p></td>
    </tr>
    <tr>
        <td class="verde" colspan="2" align="right">&copy; 2004 - <a href="<%=com.emesa.gestinm.Customization.getProperty("gestinm.url")%>"><%=com.emesa.gestinm.Customization.getProperty("gestinm.title")%></a>&nbsp;</td>
    </tr>
</table>
</body>
</html>
