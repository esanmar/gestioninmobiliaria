<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-15">
	<meta name="robots" content="NOINDEX, NOFOLLOW">
	<link rel="stylesheet" type="text/css" href="/gestinm/css/gestinm_admin.css">
	<title><%=com.emesa.gestinm.Customization.getProperty("gestinm.title")%> - Fotos</title>
</head>
<body class="bgNaranja"><jsp:useBean id="ofel_inmueble" class="com.emesa.gestinm.dao.FEL_INMUEBLE" scope="session" />
<h4>Fotos asociadas a <%=ofel_inmueble.getCODIGO()%></h4><%
String sPathToDel=request.getParameter("PATH_FOTO");
if(sPathToDel!=null && !sPathToDel.trim().equals("")) {
    try {
        com.emesa.gestinm.dao.FotosInmueble.delPicture(ofel_inmueble.getCODIGO(),sPathToDel);
        %><p>Eliminada con &eacute;xito la imagen <b><%=sPathToDel%></b> del inmueble <b><%=ofel_inmueble.getCODIGO()%></b></p><%
    }
    catch(Exception e) {
        %><p class="err">Error al eliminar la imagen <em><%=sPathToDel%></em> del inmueble <em><%=ofel_inmueble.getCODIGO()%></em>: <%=e%></p><%
    }
} else {
    java.util.Vector vFilesOk = (java.util.Vector)request.getAttribute("files_ok");
    if(vFilesOk!=null && !vFilesOk.isEmpty()) {
        %><p>Se han guardado con &eacute;xito los ficheros: <ol><%for(int i=0; i<vFilesOk.size(); i++) {
            %><li><%=vFilesOk.elementAt(i)%></li><%}%></ol></p><%
    }
    String sError=(String)request.getAttribute("error");
    if(sError!=null) {
        %><p class="err">Se ha producido un error al almacenar los ficheros: <%=sError%></p><%
    }
}
%><p align="center"><input type="button" value="Volver" onclick="javascript:history.back();"/>&nbsp;&nbsp;<input type="button" value="Cerrar" onclick="javascript:window.close();"/></p>
</body>
</html>