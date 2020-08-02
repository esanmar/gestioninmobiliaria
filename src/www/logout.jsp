<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-15">
	<meta name="author" content="emesa s.l.">
	<meta name="robots" content="NOINDEX, NOFOLLOW">
	<link rel="shortcut icon" href="/gestinm/images/icon/logo.ico" type="image/x-icon">
	<link rel="stylesheet" type="text/css" href="/gestinm/css/gestinm_admin.css">
	<title><%=com.emesa.gestinm.Customization.getProperty("gestinm.title")%> - Salir</title>
</head>
<body class="bgNaranja">
<table align="center" class="bordeVerde" cellpadding="8px">
    <tr>
        <td valign="middle"><img src="/gestinm/images/logo.gif"/></td>
        <td valign="middle" class="title"><%=com.emesa.gestinm.Customization.getProperty("gestinm.title")%></td>
    </tr>
    <tr>
        <td colspan="2" align="right">Ha salido correctamente de la aplicaci&oacute;n.<br/>Pulse en <a href="/gestinm/_admin">Volver</a> para regresar a <strong><%=com.emesa.gestinm.Customization.getProperty("gestinm.title")%></strong>.<br/>
        Pulse <a href="javascript:window.close();">Cerrar</a> para cerrar esta ventana del navegador.
        </td>
    </tr>
    <tr>
        <td colspan="2" align="center">[<a href="/gestinm/_admin">Volver</a>]&nbsp;&nbsp;&nbsp;&nbsp;[<a href="javascript:window.close();">Cerrar</a>]</td>
    </tr>
    <tr>
        <td colspan="2" align="right" class="marca">Desarrollado por <a href="http://www.emesa.com">emesa s.l.</a></td>
    </tr>
</table><%

session.invalidate();

%></body>
</html>