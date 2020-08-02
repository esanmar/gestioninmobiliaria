<%@page import="java.util.Collection"%>
<html>
<head>
    <title><%=com.emesa.gestinm.Customization.getProperty("gestinm.title")%> - Asignaci&oacute;n de propietarios</title>
	<link rel="stylesheet" type="text/css" href="/gestinm/css/gestinm_admin.css">
</head>
<body class="bgNaranja" marginwidth="0" marginheight="0"><%
request.setAttribute("search_collection",(Collection)session.getAttribute("inf_rtado"));
request.setAttribute("search_header",(Collection)session.getAttribute("inf_header"));

%><p align="right"><img src="/gestinm/images/x.png" name="cerrDown" onclick="javascript:window.close();" alt="Cerrar" style="{cursor: hand}"/></p><jsp:include page="/reports/pager_propietarios.jsp">
    <jsp:param name="sbc" value="#FFE3B5"/>
    <jsp:param name="ps" value="12"/>
    <jsp:param name="dest" value="/gestinm/_admin/inmuebles/showResults.jsp"/>
</jsp:include>
</body>
</html>