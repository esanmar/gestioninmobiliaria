<html>
<head>
    <title>Notas</title>
    <link rel="stylesheet" type="text/css" href="/gestinm/css/gestinm_admin.css">
</head>
<body>
<%
String sTipoNota=request.getParameter("nota");

if(sTipoNota==null)
    sTipoNota="";
sTipoNota="nota"+sTipoNota+"_upd.jsp";

%><jsp:include page="<%=sTipoNota%>"/><br/>
<span align="center"><input type="button" class="boton" value="Volver" onclick="javascript:history.back();"/></span>
</body>